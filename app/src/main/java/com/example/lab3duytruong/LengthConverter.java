package com.example.lab3duytruong;

import java.util.HashMap;
import java.util.Map;

public class LengthConverter {
    private static final Map<String, Double> conversionTable = new HashMap<>();

    static {
        conversionTable.put("Hải lý", 1852.0);
        conversionTable.put("Dặm", 1609.344);
        conversionTable.put("Km", 1000.0);
        conversionTable.put("Lý", 91.44);
        conversionTable.put("Met", 1.0);
        conversionTable.put("Yard", 0.9144);
        conversionTable.put("Foot", 0.3048);
        conversionTable.put("Inch", 0.0254);
    }
    public static double convert(double value, String fromUnit, String toUnit) {
        if (!conversionTable.containsKey(fromUnit) || !conversionTable.containsKey(toUnit)) {
            throw new IllegalArgumentException("Đơn vị không hợp lệ");
        }

        double valueInMeters = value * conversionTable.get(fromUnit);
        return valueInMeters / conversionTable.get(toUnit);
    }

    public static Map<String, Double> convertToAll(double value, String fromUnit) {
        Map<String, Double> results = new HashMap<>();

        for (String unit : conversionTable.keySet()) {
            results.put(unit, convert(value, fromUnit, unit));
        }
        return results;
    }
    public static String[] getAllUnits() {
        return conversionTable.keySet().toArray(new String[0]);
    }
}

