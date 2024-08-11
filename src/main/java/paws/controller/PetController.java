package paws.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import paws.domain.Pet;
import paws.exception.PawsException;
import paws.service.PetService;
import paws.service.ShelterService;

@Controller
@AllArgsConstructor
@Slf4j
public class PetController {
    private final PetService petService;
    private final ShelterService shelterService;
    private final String UPLOAD_DIR = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\uploads";
    @GetMapping("/pets/{id}")
    public String getPetsbyShelter(@PathVariable Long id, Model model) {
        log.info("Запрос на получение списка питомцев в приюте");
        List<Pet> pets = petService.getAllbyShelter(id);
        model.addAllAttributes(Map.of("pet_list", pets, "shelter", id));
        return "pets";
    }

    @GetMapping("/pets/create/{id}")
    public String createPet(Model model, @PathVariable Long id) {
        log.info("Запрос на создание питомца");
        model.addAttribute("id", id);
        return "new_pet";
    }

    @PostMapping(path = "/pets/create", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String savePet(@RequestParam("name") String name, @RequestParam("shelter") Long shelter,
                          @RequestParam("file")MultipartFile file) {
        try {
            if (file.isEmpty()) {
                petService.savePet(name, shelter);
            } else {
                StringBuilder fileName = new StringBuilder();
                    Path path = Paths.get(UPLOAD_DIR, file.getOriginalFilename());
                    fileName.append(file.getOriginalFilename());
                    Files.write(path, file.getBytes());
                    petService.savePetWithFile(name,shelter,file.getOriginalFilename());
            }
            log.info("Успешное создание питомца");
            return "redirect:/pets/"+shelter;

        }  catch (PawsException e){
            return "error";
        }catch (IOException e){
            e.printStackTrace();
            return "redirect:/pets/"+shelter;
        }
    }

    @GetMapping("/pets/edit/{id}")
    public String editPet(Model model, @PathVariable Long id) {
        try {
            log.info("Запрос на изменение данных питомца");
            Pet pet = petService.getPetById(id);

            model.addAllAttributes(Map.of("id", id, "petName", pet.getName(), "shelterID", pet.getShelter().getId()
                    , "shelter_list", shelterService.getAll()));
            return "edit_pet";
        } catch (PawsException e){
            return "error";
        }
    }

    @PostMapping(path = "/pets/edit")
    public String editPet(@RequestParam("name") String name, @RequestParam("shelter") Long shelter, @RequestParam("id") Long id) {
        try {
            petService.updatePet(id, name, shelter);
            log.info("Успешное изменение данных питомца");
            return "redirect:/pets/"+shelter;
        }  catch (PawsException e){
            return "error";
        }
    }

    @PostMapping("/pets/home")
    public String deletePet(@RequestParam("pet") Long id, @RequestParam("shelter") Long shelter) {
        try {
            petService.deletePetById(id);
            log.info("Усыновление питомца");
            return "redirect:/pets/"+shelter;
        }  catch (PawsException e){
            return "error";
        }
    }
}
