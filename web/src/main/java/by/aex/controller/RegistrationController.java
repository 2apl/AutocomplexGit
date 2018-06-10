package by.aex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String registrationPage(HttpServletRequest request) {
        return "registration";
    }
}
