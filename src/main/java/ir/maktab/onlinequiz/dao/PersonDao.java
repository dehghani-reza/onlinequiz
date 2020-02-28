package ir.maktab.onlinequiz.dao;

import ir.maktab.onlinequiz.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDao extends JpaRepository<Person, Long> {
}
