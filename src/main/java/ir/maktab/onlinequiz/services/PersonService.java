package ir.maktab.onlinequiz.services;


import ir.maktab.onlinequiz.dto.PersonCompletionDto;
import ir.maktab.onlinequiz.exceptions.PreviouslyRecordedInformation;
import ir.maktab.onlinequiz.outcome.PersonCompletionOutcome;
import org.springframework.security.access.annotation.Secured;

import java.text.ParseException;

public interface PersonService {
    @Secured("ROLE_USER")
    PersonCompletionOutcome completion(PersonCompletionDto personCompletionDto) throws PreviouslyRecordedInformation, ParseException;
}
