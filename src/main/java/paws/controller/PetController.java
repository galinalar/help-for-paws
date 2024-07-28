package paws.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import paws.domain.Pet;
import paws.dto.PetDto;
import paws.service.PetService;

import java.util.List;

@Controller
@AllArgsConstructor
public class PetController {
    private final PetService petService;
    @GetMapping("/pets")
    public String getPets(Model model) {
        List<PetDto> pets = petService.getAll();
        model.addAttribute("pet_list", pets);
        return "pets";
    }
    @GetMapping("/pets/{id}")
    public String getPetsbyShelter(@PathVariable Long id, Model model) {
        List<PetDto> pets = petService.getAllbyShelter(id);
        model.addAttribute("pet_list", pets);
        return "pets";
    }
}
