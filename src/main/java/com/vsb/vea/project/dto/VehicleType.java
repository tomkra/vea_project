package com.vsb.vea.project.dto;

public enum VehicleType {
    CAR("Auto"),
    TRUCK("Kamion");

    private final String displayValue;

    private VehicleType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
