package paws.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import paws.dto.ShelterDto;

import java.util.List;

@Controller
public class StartController {
    @GetMapping("/")
    public String getStart(Model model) {
        return "start";
    }
}
