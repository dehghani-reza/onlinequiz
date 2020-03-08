package ir.maktab.onlinequiz.services;

import ir.maktab.onlinequiz.dao.AccountDAO;
import ir.maktab.onlinequiz.dao.PersonDAO;
import ir.maktab.onlinequiz.dto.PersonCompletionDTO;
import ir.maktab.onlinequiz.enums.AccountStatus;
import ir.maktab.onlinequiz.exceptions.PreviouslyRecordedInformation;
import ir.maktab.onlinequiz.models.Account;
import ir.maktab.onlinequiz.models.Communication;
import ir.maktab.onlinequiz.models.Person;
import ir.maktab.onlinequiz.outcome.PersonCompletionOutcome;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;

@Service
public class PersonServiceImpl implements PersonService {

    final AccountDAO accountDao;
    final PersonDAO personDAO;

    public PersonServiceImpl(AccountDAO accountDao, PersonDAO personDAO) {
        this.accountDao = accountDao;
        this.personDAO = personDAO;
    }

    @Override
    public PersonCompletionOutcome completion(PersonCompletionDTO personCompletionDto) throws PreviouslyRecordedInformation, ParseException {
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
