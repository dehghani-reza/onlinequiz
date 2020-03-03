package ir.maktab.onlinequiz.services;

import ir.maktab.onlinequiz.dto.LoginAccountDto;
import ir.maktab.onlinequiz.dto.RegisterAccountDto;
import ir.maktab.onlinequiz.exceptions.AccountNotFoundException;
import ir.maktab.onlinequiz.exceptions.UsernameExistInSystemException;
import ir.maktab.onlinequiz.models.Account;
import ir.maktab.onlinequiz.outcome.LoginToAccountOutcome;
import ir.maktab.onlinequiz.outcome.RegisterAccountOutcome;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AccountService {
    RegisterAccountOutcome register(RegisterAccountDto registerAccountDto) throws UsernameExistInSystemException;

    LoginToAccountOutcome login(LoginAccountDto loginAccountDto) throws AccountNotFoundException;

    Page<Account> paginatedAwaitingApprovalAccounts(int pageNo, int pageSize);

    void acceptAllSelected(List<Long> idList);

    void dismissAllSelected(List<Long> idList);

    void acceptAll();

    void dismissAll();
}
