package ir.maktab.onlinequiz.dao;

import ir.maktab.onlinequiz.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDAO extends JpaRepository<Course, Long> {
}
