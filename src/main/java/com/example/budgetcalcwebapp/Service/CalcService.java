package com.example.budgetcalcwebapp.Service;


import com.example.budgetcalcwebapp.DataModel.CalcModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/** Service Class used for Business Logic */

@Service
public class CalcService {

    final CalcModel calcModel;

    public CalcService(CalcModel calcModel) {
        this.calcModel = calcModel;
    }

    // uses LinkedHashMap rather than HashMap to ignore auto sort of hashed keys
    // usually better to expect JSON input and also put out JSON, TODO: transform map to json
    public Map<String, Double> computeResponseMap(ArrayList<CalcModel> modelList) {
        Map<String, Double> map = new LinkedHashMap<>();

        // loop through input, if map contains key add amount to existing key value, else add key and value
        for (CalcModel calcModel : modelList) {

            if (calcModel.category != null && calcModel.amount != null) {
                if (!map.containsKey(calcModel.category)) {
                    map.put(calcModel.category, calcModel.amount);
                } else {
                    Double tempStorage = calcModel.amount + map.get(calcModel.category);
                    map.replace(calcModel.category, tempStorage);
                }

            } else {
                //TODO: categorize null values in "Category"
                System.out.println("null value present");
            }
        }
        //Add a total to the map
        map.put("Total", map.values().stream()
                .mapToDouble(d -> d)
                .sum());

        return map;
    }

}
