package ir.maktab.onlinequiz.mappers;


import ir.maktab.onlinequiz.dto.RoleDto;
import ir.maktab.onlinequiz.models.Role;

public class RoleMapper {
    public static RoleDto map(Role role) {
        return new RoleDto(
                role.getRoleType().toString()
        );
    }
}
