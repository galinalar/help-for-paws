package paws.controller;

import java.security.Principal;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import paws.domain.CombinationResult;
import paws.domain.Person;
import paws.domain.Pet;
import paws.exception.PawsException;
import paws.service.CombinationService;
import paws.service.PersonService;
import paws.service.PetService;

@Controller
@AllArgsConstructor
@Slf4j
public class CombinationController {
    private final PersonService service;
    private final PetService petService;
    private final CombinationService combinationService;
    @GetMapping("/combination/{id}")
    public String checkCombination(@PathVariable Long id, Principal principal, Model model) throws PawsException {
        Person person = service.getCurrentUser(principal.getName());
        Pet pet = petService.getPetById(id);
        CombinationResult combination = combinationService.getByAnswers(person,pet);
        model.addAllAttributes(Map.of("person", person, "pet", pet, "result", combination.getResult()));
        log.info("Запрос на проверку совместимости питомца " + pet.getName() + "и пользователя" + person.getName());
        return "combination";
    }

}
