package by.aex.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllerBase {

    @ExceptionHandler(Exception.class)
    public String handleException(Model model, Exception e) {
        model.addAttribute("errorMessage", e.getMessage());
        return "error";
    }
}
