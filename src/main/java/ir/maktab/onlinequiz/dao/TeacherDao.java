package ir.maktab.onlinequiz.dao;

import ir.maktab.onlinequiz.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDao extends JpaRepository<Teacher, Long> {
}
