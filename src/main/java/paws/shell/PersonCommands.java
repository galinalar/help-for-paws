package paws.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import paws.domain.*;
import paws.dto.PersonDto;
import paws.service.*;

import java.util.List;

@ShellComponent
@RequiredArgsConstructor
public class PersonCommands {
    private final PersonService personService;
    private final PetService petService;
    private final ShelterService shelterService;
    private final PersonQuestionService personQuestionService;
    private final PersonTestService personTestService;

    @ShellMethod(value = "get persons", key = {"persons", "p"})
    public String getAllAuthors() {
        List<PersonDto> authors = personService.getAll();
        List<Pet> pets = petService.getAll();
        List<Shelter> shelters = shelterService.getAll();
        List<PersonQuestion> questions = personQuestionService.getAll();
        List<PersonAnswer> answers = questions.get(0).getAnswers();
        List<PersonTest> tests = personTestService.getAll();
        return authors.toString();
    }
}
