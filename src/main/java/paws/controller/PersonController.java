package paws.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import paws.domain.ApplicationUser;
import paws.domain.Person;
import paws.dto.PersonDto;
import paws.exception.PawsException;
import paws.service.*;

import javax.security.auth.login.AccountException;
import java.security.Principal;
import java.util.Map;

@Controller
@AllArgsConstructor
@Slf4j
public class PersonController {
    private final PersonService service;

    private final AccountService accountService;
    @GetMapping("/persons")
    public String getCurrentPerson(Principal principal, Model model) {
        try {
            log.info("Запрос на вход в личный кабинет");
            Person person = service.getCurrentUser(principal.getName());
            model.addAttribute("person", person);
            return "person";
        } catch  (PawsException e ) {
            return "error";
        }
    }
    @GetMapping("/persons/create")
    public String createPerson(Model model) {
        log.info("Запрос на создание персонажа");
        return "new_person";
    }

    @PostMapping("/persons/create")
    public String userPerson(@RequestParam("username") String username, Principal principal) {
        try {
            Person person = service.savePerson(new Person(null, username, 1));
            ApplicationUser user = accountService.getUser(principal.getName());
            user.setPerson(person);
            accountService.updateUser(user);
            log.info("Успешное создание персонажа");
            return "redirect:/persons";
        } catch (AccountException e) {
            return "new_person";
        } catch (PawsException e){
            return "error";
        }
    }

    @GetMapping("/persons/edit/{id}")
    public String editPerson(Model model, @PathVariable Long id){
        try {
            PersonDto person = service.getPersonById(id);

            model.addAllAttributes(Map.of("id", id, "name", person.getName()));
            return "edit_person";
        } catch (PawsException e ) {
            return "error";
        }
    }

    @PostMapping(path = "/persons/edit")
    public String editPerson(@RequestParam("name") String name, @RequestParam("id") Long id) {
        service.updatePerson(id, name);
        return "redirect:/persons";
    }
}
