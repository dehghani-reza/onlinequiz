package ir.maktab.onlinequiz.dao;

import ir.maktab.onlinequiz.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Long> {
}
