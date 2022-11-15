package com.innopolis.testproject.controller;

import com.innopolis.testproject.domain.UserDetailsImpl;
import com.innopolis.testproject.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/addticket/{programid}")
    public String addTicket(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable Long programid, Map<String, Object> model) {
        model.put("programid", programid);
        return "addticket";
    }

    @PostMapping("/addticket")
    public String addTicket(@AuthenticationPrincipal UserDetailsImpl user, String programid,
                            String number, Map<String, Object> model) {
        ticketService.saveTicket(number, Long.valueOf(programid));
        return "redirect:/";
    }

    @GetMapping("/updateticket/{ticketid}")
    public String updateTicket(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable Long ticketid, Map<String, Object> model) {
        model.put("ticketid", ticketid);
        return "updateticket";
    }

    @PostMapping("/updateticket")
    public String updateTicket(@AuthenticationPrincipal UserDetailsImpl user, String ticketid,
                               String number, Map<String, Object> model) {
        ticketService.updateTicket(number, Long.valueOf(ticketid));
        return "redirect:/";
    }

    @PostMapping("/deleteticket/{ticketid}")
    public String deleteTicket(@AuthenticationPrincipal UserDetailsImpl user, @PathVariable Long ticketid,
                               Map<String, Object> model) {
        ticketService.deleteTicket(Long.valueOf(ticketid));
        return "redirect:/";
    }
}
