package ir.maktab.onlinequiz.dao;

import ir.maktab.onlinequiz.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonDAO extends JpaRepository<Lesson, Long> {
}
