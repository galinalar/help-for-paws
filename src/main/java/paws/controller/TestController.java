package paws.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import paws.domain.Person;
import paws.domain.PersonQuestion;
import paws.domain.Token;
import paws.dto.PersonQuestionDto;
import paws.service.PersonQuestionServiceImpl;
import paws.service.PersonService;

import javax.security.auth.login.AccountException;
import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class TestController {
    private final PersonQuestionServiceImpl service;
    @GetMapping("/test")
//    @Secured({"ROLE_SUPER_USER", "ROLE_USER"})
    public String getCurrentPerson(Principal principal, Model model) {
        List<PersonQuestion> questions = service.getAll();
        model.addAttribute("question_list", questions);
        return "test";
    }
    @ResponseBody
    @PostMapping("/test")
    public void test(HttpServletRequest request) {//request.getParameterMap()
            System.out.println("jjjj");//через мапу с реквестпарм

    }
}
