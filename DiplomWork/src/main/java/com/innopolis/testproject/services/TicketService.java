package com.innopolis.testproject.services;

import com.innopolis.testproject.domain.Ticket;
import com.innopolis.testproject.repos.ProgramRepo;
import com.innopolis.testproject.repos.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private ProgramRepo programRepo;

    public Ticket saveTicket(Ticket ticket){
        return ticketRepo.save(ticket);
    }

    public Ticket saveTicket(String number, Long programid){
        Ticket ticket = new Ticket();
        ticket.setSold(false);
        ticket.setNumber(number);
        ticket.setProgram(programRepo.findById(programid).orElse(null));
        return ticketRepo.save(ticket);
    }

    public Ticket updateTicket(String number, Long ticketid){
        Ticket ticket = ticketRepo.findById(ticketid).orElse(null);
        if (ticket == null) {
            return null;
        }
        ticket.setNumber(number);
        return ticketRepo.save(ticket);
    }

    public void deleteTicket(Long ticketid){
        ticketRepo.deleteById(ticketid);
    }

    public Ticket getTicket(Long id){
        return ticketRepo.findById(id).orElse(null);
    }

    public List<Ticket> getAllByProgramId(Long id){
        return ticketRepo.findByProgramIdAndIsSoldFalse(id);
    }
}
