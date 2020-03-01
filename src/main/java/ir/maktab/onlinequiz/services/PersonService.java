package ir.maktab.onlinequiz.services;


import ir.maktab.onlinequiz.dto.PersonCompletionDto;
import ir.maktab.onlinequiz.exceptions.PreviouslyRecordedInformation;
import ir.maktab.onlinequiz.outcome.PersonCompletionOutcome;

public interface PersonService {
    PersonCompletionOutcome completion(PersonCompletionDto personCompletionDto) throws PreviouslyRecordedInformation;
}
