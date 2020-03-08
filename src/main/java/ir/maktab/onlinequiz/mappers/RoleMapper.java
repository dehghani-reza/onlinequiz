package ir.maktab.onlinequiz.mappers;


import ir.maktab.onlinequiz.dto.RoleDTO;
import ir.maktab.onlinequiz.models.Role;

public class RoleMapper {
    public static RoleDTO map(Role role) {
        return new RoleDTO(
                role.getRoleType().toString()
        );
    }
}
