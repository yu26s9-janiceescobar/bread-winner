package com.pluralsight.models;

public enum SandwichSize{

        SMALL(4,5.5),
        MEDIUM(8, 7.0),
        LARGE(12, 8.5);

        private final double basePrice;

        private final int inches;
         SandwichSize(int inches, double basePrice){
             this.inches = inches;
             this.basePrice = basePrice;
        }
        public int getInches(){
             return inches;
        }
        public double getBasePrice(){
            return basePrice;
        }
        @Override
        public String toString(){
             return String.format("""
                     %d --- $%.2f", name(), price)""",
                     inches, basePrice);
        }
}
