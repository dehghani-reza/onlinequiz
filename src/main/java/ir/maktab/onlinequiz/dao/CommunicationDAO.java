package ir.maktab.onlinequiz.dao;

import ir.maktab.onlinequiz.models.Communication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunicationDAO extends JpaRepository<Communication, Long> {
}
