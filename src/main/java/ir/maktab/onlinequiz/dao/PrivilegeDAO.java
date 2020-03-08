package ir.maktab.onlinequiz.dao;

import ir.maktab.onlinequiz.models.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeDAO extends JpaRepository<Privilege, Long> {
}
