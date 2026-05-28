package com.pluralsight.models.enums;

public enum SpecialitySandwich {
        BLT("BLT"),
    PHILLY_CHEESE("Philly Cheese Steak");

        private String label;
        SpecialitySandwich(String label){
            this.label = label;
        }
        public String getLabel(){
            return label;
        }
}
