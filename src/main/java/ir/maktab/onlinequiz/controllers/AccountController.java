package ir.maktab.onlinequiz.controllers;

import ir.maktab.onlinequiz.dto.LoginAccountDto;
import ir.maktab.onlinequiz.dto.RegisterAccountDto;
import ir.maktab.onlinequiz.exceptions.AccountNotFoundException;
import ir.maktab.onlinequiz.exceptions.UsernameExistInSystemException;
import ir.maktab.onlinequiz.outcome.LoginToAccountOutcome;
import ir.maktab.onlinequiz.outcome.RegisterAccountOutcome;
import ir.maktab.onlinequiz.services.AccountService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/")
public class AccountController {

    final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("register")
    private RegisterAccountOutcome register(@RequestBody RegisterAccountDto registerAccountDto) throws UsernameExistInSystemException {
        return accountService.register(registerAccountDto);
    }


    @PostMapping("login")
    private LoginToAccountOutcome login(@RequestBody LoginAccountDto loginAccountDto) throws AccountNotFoundException {
        return accountService.login(loginAccountDto);
    }
}
