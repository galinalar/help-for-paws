package paws.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import paws.domain.Person;
import paws.domain.Pet;
import paws.domain.Shelter;
import paws.service.PersonService;
import paws.service.PetService;
import paws.service.ShelterService;

import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class PersonCommands {
    private final PersonService personService;
    private final PetService petService;
    private final ShelterService shelterService;

    @ShellMethod(value = "get persons", key = {"persons", "p"})
    public String getAllAuthors() {
        List<Person> authors = personService.getAll();
        List<Pet> pets = petService.getAll();
        List<Shelter> shelters = shelterService.getAll();
        return authors.toString();
    }
}
