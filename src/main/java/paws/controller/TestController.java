package paws.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import paws.domain.Person;
import paws.domain.PersonQuestion;
import paws.exception.PawsException;
import paws.service.PersonQuestionService;
import paws.service.PersonService;
import paws.service.PersonTestService;

@Controller
@AllArgsConstructor
@Slf4j
public class TestController {
    private final PersonQuestionService service;
    private final PersonTestService personTestService;
    private final PersonService personService;
    @GetMapping("/test")
    public String getTest(Model model) {
        log.info("Запрос на прохождение опроса");
        List<PersonQuestion> questions = service.getAll();
        model.addAttribute("question_list", questions);
        return "test";
    }
    @ResponseBody
    @PostMapping("/test")
    public void test(@RequestParam Map<String, String> param) {//request.getParameterMap()
            System.out.println("jjjj");//через мапу с реквестпарм

    }
    @GetMapping("/person/test")
    public String getTestByPerson(Principal principal, Model model) {
        log.info("Запрос на получение конкретного опроса");
       try {
            Person person = personService.getCurrentUser(principal.getName());
            List<PersonQuestion> questions = personTestService.getPersonTestById(person);
            if (!questions.isEmpty()) {
                model.addAttribute("question_list", questions);
                return "test_person";
            } else return  "redirect:/test";
        }catch ( PawsException e){
            return "error";
        }
    }
}
