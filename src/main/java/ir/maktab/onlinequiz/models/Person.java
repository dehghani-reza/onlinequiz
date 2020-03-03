package ir.maktab.onlinequiz.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PERSON_TYPE", discriminatorType = DiscriminatorType.STRING)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String fathersName;

    private String nationalCode;

    @Temporal(TemporalType.DATE)
    private Date birthOfDate;

    private String degreeOfEducation;

    @JsonIgnore
    @OneToOne(mappedBy = "person")
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    private Communication communication;
}
