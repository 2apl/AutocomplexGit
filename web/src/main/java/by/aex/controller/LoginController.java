package by.aex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController extends ControllerBase {

    @GetMapping("/login")
    public String loginPage(HttpServletRequest request) {
        return "login";
    }
}
