package ir.maktab.onlinequiz.controllers;

import ir.maktab.onlinequiz.dto.PersonCompletionDTO;
import ir.maktab.onlinequiz.exceptions.PreviouslyRecordedInformation;
import ir.maktab.onlinequiz.models.Person;
import ir.maktab.onlinequiz.outcome.PersonCompletionOutcome;
import ir.maktab.onlinequiz.services.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping
public class PersonController {
    final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/guest/personCompletion")
    private PersonCompletionOutcome completion(@RequestBody PersonCompletionDTO personCompletionDto) throws PreviouslyRecordedInformation, ParseException {
        return personService.completion(personCompletionDto);
    }
}
