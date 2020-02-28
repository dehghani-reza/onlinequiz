package ir.maktab.onlinequiz.dao;

import ir.maktab.onlinequiz.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonDao extends JpaRepository<Lesson, Long> {
}
