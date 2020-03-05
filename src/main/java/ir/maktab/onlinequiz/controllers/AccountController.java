package ir.maktab.onlinequiz.controllers;

import ir.maktab.onlinequiz.dto.LoginAccountDto;
import ir.maktab.onlinequiz.dto.NewUsersIdsList;
import ir.maktab.onlinequiz.dto.RegisterAccountDto;
import ir.maktab.onlinequiz.exceptions.AccountNotFoundException;
import ir.maktab.onlinequiz.exceptions.UsernameExistInSystemException;
import ir.maktab.onlinequiz.models.Account;
import ir.maktab.onlinequiz.outcome.LoginToAccountOutcome;
import ir.maktab.onlinequiz.outcome.RegisterAccountOutcome;
import ir.maktab.onlinequiz.services.AccountService;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping
public class AccountController {

    final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/user/register")
    private RegisterAccountOutcome register(@RequestBody RegisterAccountDto registerAccountDto) throws UsernameExistInSystemException {
        return accountService.register(registerAccountDto);
    }

    @PostMapping("/user/login")
    private LoginToAccountOutcome login(@RequestBody LoginAccountDto loginAccountDto) throws AccountNotFoundException {
        return accountService.login(loginAccountDto);
    }

    @PostMapping("/manager/accounts/{pageNo}/{pageSize}")
    public Page<Account> getPaginatedAwaitingApprovalAccounts(@PathVariable int pageNo, @PathVariable int pageSize) {
        return accountService.paginatedAwaitingApprovalAccounts(pageNo, pageSize);
    }

    @PostMapping("/manager/new-user-list/accept-all-selected")
    private void acceptAllSelected(@RequestBody NewUsersIdsList newUsersIdsList) {
        accountService.acceptAllSelected(newUsersIdsList.getListId()
                .stream()
                .map(Long::parseLong)
                .collect(Collectors.toList()));
    }

    @PostMapping("/manager/new-user-list/accept-all")
    private void acceptAll() {
        accountService.acceptAll();
    }

    @PostMapping("/manager/new-user-list/dismiss-all-selected")
    private void dismissAllSelected(@RequestBody NewUsersIdsList newUsersIdsList) {
        accountService.dismissAllSelected(newUsersIdsList.getListId()
                .stream()
                .map(Long::parseLong)
                .collect(Collectors.toList()));
    }

    @PostMapping("/manager/new-user-list/dismiss-all")
    private void dismissAll() {
        accountService.dismissAll();
    }

}
