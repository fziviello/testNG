package com.academy.utils;

import java.util.HashMap;
import java.util.Map;

public class ParamContainer {
    private Map<String, String> values = new HashMap<>();

    public ParamContainer() {
        values.put("val_1", "1");
        values.put("val_2", "2");
        values.put("val_3", "3");
        values.put("val_4", "4");
    }

    public Map<String, String> getValues() {
        return values;
    }
}