package com.example.tp1bourseprojetjavafx.expense;

import java.time.LocalDate;
import java.util.Date;

public class Expense {

    private String name;
    private LocalDate date;
    private String housing;
    private Boolean food;
    private Boolean goingOut;
    private Boolean transportation;
    private Boolean travel;
    private Boolean tax;
    private Boolean other;


    public Expense(
        String name,
        LocalDate date,
        String housing,
        Boolean food,
        Boolean goingOut,
        Boolean transportation,
        Boolean travel,
        Boolean tax,
        Boolean other
    ) {
        this.name = name;
        this.date = date;
        this.housing = housing;
        this.food = food;
        this.goingOut = goingOut;
        this.transportation = transportation;
        this.travel = travel;
        this.tax = tax;
        this.other = other;
    }

    public Boolean getFood() {
        return food;
    }

    public void setFood(Boolean food) {
        this.food = food;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getHousing() {
        return housing;
    }

    public void setHousing(String housing) {
        this.housing = housing;
    }

    public Boolean getGoingOut() {
        return goingOut;
    }

    public void setGoingOut(Boolean goingOut) {
        this.goingOut = goingOut;
    }

    public Boolean getTransportation() {
        return transportation;
    }

    public void setTransportation(Boolean transportation) {
        this.transportation = transportation;
    }

    public Boolean getTravel() {
        return travel;
    }

    public void setTravel(Boolean travel) {
        this.travel = travel;
    }

    public Boolean getTax() {
        return tax;
    }

    public void setTax(Boolean tax) {
        this.tax = tax;
    }

    public Boolean getOther() {
        return other;
    }

    public void setOther(Boolean other) {
        this.other = other;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
