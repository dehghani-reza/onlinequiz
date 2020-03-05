package ir.maktab.onlinequiz.services;

import ir.maktab.onlinequiz.dao.AccountDao;
import ir.maktab.onlinequiz.dto.PersonCompletionDto;
import ir.maktab.onlinequiz.enums.AccountStatus;
import ir.maktab.onlinequiz.exceptions.PreviouslyRecordedInformation;
import ir.maktab.onlinequiz.models.Account;
import ir.maktab.onlinequiz.models.Communication;
import ir.maktab.onlinequiz.models.Person;
import ir.maktab.onlinequiz.outcome.PersonCompletionOutcome;
import ir.maktab.onlinequiz.utils.MyDate;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

@Service
public class PersonServiceImpl implements PersonService {

    final AccountDao accountDao;

    public PersonServiceImpl(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public PersonCompletionOutcome completion(PersonCompletionDto personCompletionDto) throws PreviouslyRecordedInformation, ParseException {
        Account account;
        Person person;

        if (accountDao.findByUsername(personCompletionDto.getUsername()).isPresent()) {
            account = accountDao.findByUsername(personCompletionDto.getUsername()).get();
            person = account.getPerson();
            if (account.getAccountStatus().equals(AccountStatus.DEACTIVATE)) {
                person.setFirstName(personCompletionDto.getFirstName());
                person.setLastName(personCompletionDto.getLastName());
                person.setNationalCode(personCompletionDto.getNationalCode());
                person.setFathersName(personCompletionDto.getFathersName());
                person.setDegreeOfEducation(personCompletionDto.getDegreeOfEducation());
                person.setBirthOfDate(LocalDate.parse(personCompletionDto.getBirthOfDate()).plusDays(1));
                person.setCommunication(new Communication(
                        null,
                        personCompletionDto.getEmail(),
                        personCompletionDto.getPhoneNumber(),
                        personCompletionDto.getCellPhoneNumber(),
                        personCompletionDto.getAddress(),
                        person
                ));
                account.setAccountStatus(AccountStatus.AWAITING_APPROVAL);
                accountDao.save(account);
            } else
                throw new PreviouslyRecordedInformation("کاربر گرامی اطلاعات شما قبلا در سیستم ثبت شده است لطفا منتظر تایید باشید با تشکر از شکیبایی شما");
        }

        return new PersonCompletionOutcome(1L);
    }
}
