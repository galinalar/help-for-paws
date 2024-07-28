package paws.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import paws.domain.Person;
import paws.dto.ShelterDto;
import paws.service.PersonService;
import paws.service.PetService;
import paws.service.ShelterService;
import paws.service.UserDetailService;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class PersonController {
    private final PersonService service;
    @GetMapping("/persons")
//    @Secured({"ROLE_SUPER_USER", "ROLE_USER"})
    public String getCurrentPerson(Principal principal, Model model) {
        Person person = service.getCurrentUser(principal.getName());
        model.addAttribute("person", person);
        return "person";
    }

}
