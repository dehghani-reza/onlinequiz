package ir.maktab.onlinequiz.services;


import ir.maktab.onlinequiz.dto.PersonCompletionDTO;
import ir.maktab.onlinequiz.exceptions.PreviouslyRecordedInformation;
import ir.maktab.onlinequiz.models.Person;
import ir.maktab.onlinequiz.outcome.PersonCompletionOutcome;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;

import java.text.ParseException;

public interface PersonService {
    @Secured("ROLE_USER")
    PersonCompletionOutcome completion(PersonCompletionDTO personCompletionDto) throws PreviouslyRecordedInformation, ParseException;
}
