package com.innopolis.testproject.controller;

import com.innopolis.testproject.domain.Program;
import com.innopolis.testproject.domain.Ticket;
import com.innopolis.testproject.domain.UserDetailsImpl;
import com.innopolis.testproject.services.ProgramService;
import com.innopolis.testproject.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private ProgramService programService;

    @Autowired
    private TicketService ticketService;

    @GetMapping("/")
    public String main(@AuthenticationPrincipal UserDetailsImpl user, Map<String, Object> model) {
        model.put("programs", programService.getAll());
        return "mainpage";
    }

    @GetMapping("/{programid}")
    public String getTickets(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable Long programid,
                             @RequestParam(required = false) Long maxPrice, Map<String, Object> model) {
        Program program = programService.getById(programid);
        if (program != null) {
            model.put("program", program);
        }
        model.put("tickets", ticketService.getAllByProgramId(programid));
        return "programpage";
    }

    @PostMapping("/buyTicket")
    public String buyTickets(@AuthenticationPrincipal UserDetailsImpl user, Long id, Map<String, Object> model) {
//        if (user.user.getRoles().contains("USER")){
//            //buy ticket
//        }//else not buy
        Ticket ticket = ticketService.getTicket(id);
        ticket.setSold(true);
        ticketService.saveTicket(ticket);
        return "redirect:/";
    }
}
