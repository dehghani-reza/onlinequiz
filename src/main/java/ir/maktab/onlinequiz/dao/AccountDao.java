package ir.maktab.onlinequiz.dao;

import ir.maktab.onlinequiz.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountDao extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
}
