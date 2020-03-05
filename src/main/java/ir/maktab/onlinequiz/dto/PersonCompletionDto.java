package ir.maktab.onlinequiz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class PersonCompletionDto {
    String username;
    String firstName;
    String lastName;
    String fathersName;
    String nationalCode;
    String degreeOfEducation;
    String phoneNumber;
    String cellPhoneNumber;
    String email;
    String address;
    String birthOfDate;
}
