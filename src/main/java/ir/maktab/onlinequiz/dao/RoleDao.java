package ir.maktab.onlinequiz.dao;

import ir.maktab.onlinequiz.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
