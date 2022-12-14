package com.innopolis.testproject.repos;

import com.innopolis.testproject.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {

    List<Ticket> findByProgramIdAndIsSoldFalse(Long id);
}
