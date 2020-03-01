package ir.maktab.onlinequiz.services;

import ir.maktab.onlinequiz.dao.AccountDao;
import ir.maktab.onlinequiz.dao.PersonDao;
import ir.maktab.onlinequiz.dao.RoleDao;
import ir.maktab.onlinequiz.dto.LoginAccountDto;
import ir.maktab.onlinequiz.dto.RegisterAccountDto;
import ir.maktab.onlinequiz.enums.AccountStatus;
import ir.maktab.onlinequiz.enums.RoleTypes;
import ir.maktab.onlinequiz.exceptions.AccountNotFoundException;
import ir.maktab.onlinequiz.exceptions.UsernameExistInSystemException;
import ir.maktab.onlinequiz.mappers.RoleMapper;
import ir.maktab.onlinequiz.models.Account;
import ir.maktab.onlinequiz.models.Person;
import ir.maktab.onlinequiz.outcome.LoginToAccountOutcome;
import ir.maktab.onlinequiz.outcome.RegisterAccountOutcome;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    final AccountDao accountDao;
    final RoleDao roleDao;
    final PersonDao personDao;

    public AccountServiceImpl(AccountDao accountDao, RoleDao roleDao, PersonDao personDao) {
        this.accountDao = accountDao;
        this.roleDao = roleDao;
        this.personDao = personDao;
    }

    @Override
    public RegisterAccountOutcome register(RegisterAccountDto registerAccountDto) throws UsernameExistInSystemException {
        if (accountDao.findByUsername(registerAccountDto.getUsername()).isPresent())
            throw new UsernameExistInSystemException("کاربری با این نام کاربری در سیستم وجود دارد!");

        Account account = accountDao.saveAndFlush(
                new Account(
                        null,
                        registerAccountDto.getUsername(),
                        new BCryptPasswordEncoder().encode(registerAccountDto.getPassword()),
                        AccountStatus.DEACTIVATE,
                        new Date(),
                        null,
                        new Person(),
                        true,
                        Set.of(roleDao.findRoleJpaEntityByRoleType(RoleTypes.valueOf(registerAccountDto.getRole())),
                                roleDao.findRoleJpaEntityByRoleType(RoleTypes.ROLE_GUEST))
                ));

        return new RegisterAccountOutcome(account.getUsername());
    }

    @Override
    public LoginToAccountOutcome login(LoginAccountDto loginAccountDto) throws AccountNotFoundException {
        Optional<Account> account = accountDao.findByUsername(loginAccountDto.getUsername());
        if (account.isEmpty())
            throw new AccountNotFoundException("اطلاعات وارد شده صحبح نمی باشد");

        account.get().setLastLoginDate(new Date());
        accountDao.save(account.get());
        return new LoginToAccountOutcome(account.get().getUsername(),
                account
                        .stream()
                        .flatMap(accountJpaEntity -> accountJpaEntity.getRoles().stream())
                        .map(RoleMapper::map)
                        .collect(Collectors.toSet()));
    }
}
