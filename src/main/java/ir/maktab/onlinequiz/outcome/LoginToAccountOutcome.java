package ir.maktab.onlinequiz.outcome;

import ir.maktab.onlinequiz.dto.RoleDto;
import lombok.Value;

import java.util.Set;

@Value
public class LoginToAccountOutcome {
    String username;
    Set<RoleDto> roles;
}
