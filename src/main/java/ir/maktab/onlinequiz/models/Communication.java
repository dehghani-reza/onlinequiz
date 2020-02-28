package ir.maktab.onlinequiz.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Communication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String phoneNumber;

    private String cellPhoneNumber;

    private String address;

    @OneToOne(mappedBy = "communication")
    private Person person;
}
