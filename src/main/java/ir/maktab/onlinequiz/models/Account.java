package ir.maktab.onlinequiz.models;

import ir.maktab.onlinequiz.enums.AccountStatus;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    private Date createAccountDate;

    private Date lastLoginDate;

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    private boolean active;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    @Column(nullable = false)
    private Set<Role> roles;
}
