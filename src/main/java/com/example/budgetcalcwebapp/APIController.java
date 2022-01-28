package com.example.budgetcalcwebapp;

import org.json.JSONObject;
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

    final CalcModel calcModel;

    public APIController(CalcModel calcModel) {
        this.calcModel = calcModel;
    }

    @RequestMapping(value = "/results", method = RequestMethod.POST)
    public Map createCalcOutput(@RequestBody(required = false) ArrayList<CalcModel> data) {
        return calcModel.computeResponseMap(data);
    }
}
