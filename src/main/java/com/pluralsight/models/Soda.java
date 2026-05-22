package com.pluralsight.models;

public class Soda implements OrderItem{
    private final double smallPrice;
    private final double mediumPrice;
    private final double largePrice;
    private String selectedDrink;
    private Size size;

    public Soda(double smallPrice, double mediumPrice, double largePrice,String selectedDrink, Size size){
        this.smallPrice = smallPrice;
        this.mediumPrice = mediumPrice;
        this.largePrice = largePrice;
        this.selectedDrink = selectedDrink;
        this.size = size;
    }
    @Override
    public String getName(){
        return "Soda";
    }
    @Override
    public String getSodaType(){
        return selectedDrink;
    }
    @Override
    public double getPrice(){
        return switch(size){
            case SMALL -> smallPrice;
            case MEDIUM -> mediumPrice;
            case LARGE -> largePrice;
        };
    }
    public void setSelectedDrink(String selectedDrink){
        this.selectedDrink = selectedDrink;
    }

    public void setSize(Size size){
        this.size = size;
    }
    public Size getSize(){
        return size;
    }
}
