package ir.maktab.onlinequiz.config.security;

import ir.maktab.java32.projects.onlineexamsmanagement.modules.usermanagement.features.accountmanagement.adapter.persistance.entities.AccountJpaEntity;
import ir.maktab.java32.projects.onlineexamsmanagement.modules.usermanagement.features.accountmanagement.adapter.persistance.repositories.AccountRepository;
import ir.maktab.java32.projects.onlineexamsmanagement.modules.usermanagement.features.accountmanagement.application.port.in.exceptions.LoginToAccountByUserException;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    final AccountRepository accountRepository;

    public MyUserDetailsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @SneakyThrows
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) {
        Optional<AccountJpaEntity> account = accountRepository.findByUsername(userName);

        account.orElseThrow(() -> new LoginToAccountByUserException("اطلاعات وارد شده صحبح نمی باشد"));

        return account.map(MyUserDetails::new).get();
    }
}
