package ir.maktab.onlinequiz.dao;

import ir.maktab.onlinequiz.models.Person;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonDAO extends PagingAndSortingRepository<Person, Long>, JpaSpecificationExecutor<Person> {
}
