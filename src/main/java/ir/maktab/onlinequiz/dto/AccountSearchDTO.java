package ir.maktab.onlinequiz.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountSearchDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String fathersName;
    private String nationalCode;
    private String degreeOfEducation;
    private String phoneNumber;
    private String cellPhoneNumber;
    private String address;
    private String email;
    private String role;
}
