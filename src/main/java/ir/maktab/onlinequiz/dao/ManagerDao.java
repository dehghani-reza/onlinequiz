package ir.maktab.onlinequiz.dao;

import ir.maktab.onlinequiz.models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerDao extends JpaRepository<Manager, Long> {
}
