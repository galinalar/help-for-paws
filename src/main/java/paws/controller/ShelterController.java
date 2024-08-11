package paws.controller;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import paws.domain.Shelter;
import paws.exception.PawsException;
import paws.service.ShelterService;

@Controller
@AllArgsConstructor
@Slf4j
public class ShelterController {
    private final ShelterService service;
    @GetMapping("/shelters")
    public String getShelters(Model model) {
        log.info("Запрос на получение списка приютов");
        List<Shelter> shelters = service.getAll();
        model.addAttribute("shelter_list", shelters);
        return "shelters";
    }
    @GetMapping("/shelters/create")
    public String createShelter(Model model) {
        log.info("Запрос на создание приюта");
        return "new_shelter";
    }

    @PostMapping("/shelters/create")
    public String saveShelter(@RequestParam("name") String name) {
        service.saveShelter(name);
        log.info("Успешное создание приюта");
        return "redirect:/shelters";
    }

    @PostMapping("/shelters/delete/{id}")
    public String deleteShelter(@PathVariable Long id) {
        try {
            service.deleteShelterById(id);
            log.info("Отключение приюта");
            return "redirect:/shelters";
        } catch (PawsException e){
            return "error";
        }
    }
    @GetMapping("/shelters/edit/{id}")
    public String editShelter(Model model, @PathVariable Long id) {
        try {
            log.info("Запрос на изменение данных приюта");
            Shelter shelter = service.getShelterById(id);

            model.addAllAttributes(Map.of("id", id, "shelterName", shelter.getName()));
            return "edit_shelter";
        }  catch (PawsException e){
            return "error";
        }
    }

    @PostMapping(path = "/shelters/edit")
    public String editShelter(@RequestParam("name") String name, @RequestParam("id") Long id) {
        service.updateShelter(id, name);
        log.info("Успешное изменение данных приюта");
        return "redirect:/shelters";
    }

}
