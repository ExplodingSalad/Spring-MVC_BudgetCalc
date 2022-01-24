package com.example.budgetcalcwebapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.*;

public class CalcModelTest {

    CalcModel calcModel;

    @BeforeEach
    void setUp() {
        calcModel = new CalcModel();
    }

    @Test
    void testComputeResponseMap() {

        CalcModel calcModel1 = new CalcModel();
        calcModel1.category = "Category 1";
        calcModel1.amount = 100.0;

        CalcModel calcModel2 = new CalcModel();
        calcModel2.category = "Category 1";
        calcModel2.amount = 100.0;

        CalcModel calcModel3 = new CalcModel();
        calcModel3.category = "Category 2";
        calcModel3.amount = 100.0;

        ArrayList<CalcModel> arrayList = new ArrayList<>();
        arrayList.add(calcModel1);
        arrayList.add(calcModel2);
        arrayList.add(calcModel3);

        System.out.println(calcModel.computeResponseMap(arrayList));
    }
}
