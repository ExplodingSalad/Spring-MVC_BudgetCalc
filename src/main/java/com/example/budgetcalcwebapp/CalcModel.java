package com.example.budgetcalcwebapp;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class CalcModel {

    public String name;
    public String category;
    public Double amount;

    public CalcModel() {

    }

    public HashMap<String, Double> computeResponseMap(ArrayList<CalcModel> modelList) {
        HashMap<String, Double> map = new HashMap<>();
        for (int i = 0; i<modelList.size(); i++) {
            if (!map.containsKey(modelList.get(i).category)) {
                map.put(modelList.get(i).category, modelList.get(i).amount);
            } else {
                Double tempStorage = modelList.get(i).amount + map.get(modelList.get(i).category);
                map.replace(modelList.get(i).category, tempStorage);
            }
        }
        return map;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
