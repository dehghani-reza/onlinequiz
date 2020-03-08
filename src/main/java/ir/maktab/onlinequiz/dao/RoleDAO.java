package ir.maktab.onlinequiz.dao;

import ir.maktab.onlinequiz.enums.RoleTypes;
import ir.maktab.onlinequiz.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDAO extends JpaRepository<Role, Long> {
    Role findRoleJpaEntityByRoleType(RoleTypes roleType);
}
