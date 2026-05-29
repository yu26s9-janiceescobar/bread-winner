package com.pluralsight.models.enums;

public enum SpecialitySandwich {
        BLT("BLT"),
    PHILLY_CHEESE("Philly Cheese Steak"),
    TURKEY_CLUB("Turkey Club");

        private String label;
        SpecialitySandwich(String label){
            this.label = label;
        }
        public String getLabel(){
            return label;
        }
}
