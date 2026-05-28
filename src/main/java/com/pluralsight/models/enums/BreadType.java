package com.pluralsight.models.enums;

public enum BreadType {
    WHITE("White"),
    WHEAT("Wheat"),
    WRAP("Wrap"),
    RYE("Rye");
    private final String label;
    BreadType(String label){
        this.label = label;
    }
    public String getLabel() {
        return label;
    }

}