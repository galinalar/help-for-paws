package paws.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import paws.domain.ApplicationUser;
import paws.service.AccountService;

import javax.security.auth.login.AccountException;

@Controller
@AllArgsConstructor
@Slf4j
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @GetMapping("/registration")
    public String registration(ApplicationUser applicationUser) {
        log.info("Запрос на регистрацию");
        return "registration";
    }
    @PostMapping("/registration")
    public String createAccount(ApplicationUser user, Model model) {
        try {
            accountService.registration(user);
            log.info("Успешная регистрация");
            return "redirect:/login";
        } catch (AccountException e) {
            model.addAttribute("error", e.getMessage());
            return "account/registration";
        }
    }

}
