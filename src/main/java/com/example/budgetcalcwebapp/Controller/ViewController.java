package com.example.budgetcalcwebapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Controller for fetching HTML Views using Thymeleaf
 * */

@Controller
public class ViewController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage() {
        return "index";
    }
}
