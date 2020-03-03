package ir.maktab.onlinequiz.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.maktab.onlinequiz.enums.PrivilegeTypes;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PrivilegeTypes privilegeTypes;

    @JsonIgnore
    @ManyToMany(mappedBy = "privileges")
    private Set<Role> roles;
}
