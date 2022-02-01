package com.example.budgetcalcwebapp.DataModel;
import org.springframework.stereotype.Component;

/** Custom Data Model class which is expected in the API request body */

@Component
public class CalcModel {

    public String name;
    public String category;
    public Double amount;

    public CalcModel() {
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
