package paws.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import paws.domain.Combination;
import paws.domain.CombinationResult;
import paws.domain.Person;
import paws.domain.Pet;
import paws.service.CombinationService;
import paws.service.PersonService;
import paws.service.PetService;

import java.security.Principal;
import java.util.Map;

@Controller
@AllArgsConstructor
public class CombinationController {
    private final PersonService service;
    private final PetService petService;
    private final CombinationService combinationService;
    @GetMapping("/combination/{id}")
//    @Secured({"ROLE_SUPER_USER", "ROLE_USER"})
    public String checkCombination(@PathVariable Long id, Principal principal, Model model) {
        Person person = service.getCurrentUser(principal.getName());
        Pet pet = petService.getPetById(id);
        CombinationResult combination = combinationService.getByAnswers(person,pet);
        model.addAllAttributes(Map.of("person", person, "pet", pet, "result", combination.getResult()));
        return "combination";
    }

}
