package com.example.budgetcalcwebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Controller for fetching HTML Views using Thymeleaf
 * */

@Controller
public class AppController {

    final CalcModel calcModel;

    public AppController(CalcModel calcModel) {
        this.calcModel = calcModel;
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getHomePage() {
        return "index";
    }


    @RequestMapping(value = "/home/result", method = RequestMethod.GET)
    public ModelAndView getCalcResults(ArrayList<CalcModel> data) {
        ModelAndView mav = new ModelAndView("index");
        if (data != null) {
            mav.addObject("entries", calcModel.computeResponseMap(data));
        }
        return mav;
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public ModelAndView postCalcInput(@RequestBody(required = false) ArrayList<CalcModel> data) {
        return getCalcResults(data);
    }

}
