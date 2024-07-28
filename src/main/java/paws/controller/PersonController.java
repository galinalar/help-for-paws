package paws.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import paws.domain.ApplicationUser;
import paws.domain.Person;
import paws.domain.Token;
import paws.dto.ShelterDto;
import paws.service.*;

import javax.security.auth.login.AccountException;
import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class PersonController {
    private final PersonService service;

    private final AccountService accountService;
    @GetMapping("/persons")
//    @Secured({"ROLE_SUPER_USER", "ROLE_USER"})
    public String getCurrentPerson(Principal principal, Model model) {
        Person person = service.getCurrentUser(principal.getName());
        model.addAttribute("person", person);
        return "person";
    }
    @GetMapping("/persons/create")
    public String createPerson(Model model) {
        return "new_person";
    }

    @ResponseBody
    @PostMapping("/persons/create")
    public String userPerson(@RequestParam("username") String username, Principal principal) {
        try {
            Person person = service.savePerson(new Person(null, username));
            ApplicationUser user = accountService.getUser(principal.getName());
            user.setPerson(person);
            accountService.updateUser(user);
            return "persons";
        } catch (AccountException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
