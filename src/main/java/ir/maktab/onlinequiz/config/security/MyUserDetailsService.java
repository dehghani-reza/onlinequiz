package ir.maktab.onlinequiz.config.security;

import ir.maktab.onlinequiz.dao.AccountDAO;
import ir.maktab.onlinequiz.models.Account;
import lombok.SneakyThrows;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    final AccountDAO accountDao;

    public MyUserDetailsService(AccountDAO accountDao) {
        this.accountDao = accountDao;
    }


    @SneakyThrows
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) {
        Optional<Account> account = accountDao.findByUsername(userName);

        account.orElseThrow(() -> new Exception("اطلاعات وارد شده صحبح نمی باشد"));

        return account.map(MyUserDetails::new).get();
    }
}
