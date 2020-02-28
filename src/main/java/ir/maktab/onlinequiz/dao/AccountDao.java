package ir.maktab.onlinequiz.dao;

import ir.maktab.onlinequiz.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Long> {
}
