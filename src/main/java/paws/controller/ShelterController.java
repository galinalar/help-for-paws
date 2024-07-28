package paws.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import paws.dto.PetDto;
import paws.dto.ShelterDto;
import paws.service.PetService;
import paws.service.ShelterService;

import java.security.Principal;
import java.util.List;

@Controller
@AllArgsConstructor
public class ShelterController {
    private final ShelterService service;
    @GetMapping("/shelters")
//    @Secured({"ROLE_SUPER_USER", "ROLE_USER"})
    public String getShelters(Model model) {
        List<ShelterDto> shelters = service.getAll();
        model.addAttribute("shelter_list", shelters);
        return "shelters";
    }

}
