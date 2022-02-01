package com.example.budgetcalcwebapp.Controller;

import com.example.budgetcalcwebapp.DataModel.CalcModel;
import com.example.budgetcalcwebapp.Service.CalcService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;

/**
 * REST Controller for API Services (Data extraction)
 * */

@RestController
@RequestMapping(("/api"))
public class APIController {

    final CalcService calcService;

    public APIController(CalcService calcService) {
        this.calcService = calcService;
    }

    // POST endpoint accepting an array of CalcModel objects, returning a grouped summary to the frontend
    @RequestMapping(value = "/results", method = RequestMethod.POST)
    public Map createCalcOutput(@RequestBody(required = false) ArrayList<CalcModel> data) {
        return calcService.computeResponseMap(data);
    }
}
