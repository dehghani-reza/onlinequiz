package ir.maktab.onlinequiz.services;

import ir.maktab.onlinequiz.dto.LoginAccountDto;
import ir.maktab.onlinequiz.dto.RegisterAccountDto;
import ir.maktab.onlinequiz.exceptions.AccountNotFoundException;
import ir.maktab.onlinequiz.exceptions.UsernameExistInSystemException;
import ir.maktab.onlinequiz.outcome.LoginToAccountOutcome;
import ir.maktab.onlinequiz.outcome.RegisterAccountOutcome;

public interface AccountService {
    RegisterAccountOutcome register(RegisterAccountDto registerAccountDto) throws UsernameExistInSystemException;

    LoginToAccountOutcome login(LoginAccountDto loginAccountDto) throws AccountNotFoundException;
}
