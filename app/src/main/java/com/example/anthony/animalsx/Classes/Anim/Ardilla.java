package com.example.anthony.animalsx.Classes.Anim;

import com.example.anthony.animalsx.Classes.Matriz;

public class Ardilla {
    private String name= "ardilla";
    private Integer maxAge = 6;
    private double[][] rates = { { 0,0,0.8,0.9,0.3,0 }, { 0.8,0.9,0.9,0.6,0.4,0} };
    private Matriz animalRate;
    private String srcName= "chipmunk";

    public Ardilla() {
        this.setAnimalRate(new Matriz(rates));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(Integer maxAge) {
        this.maxAge = maxAge;
    }


    public String getSrcName() {
        return srcName;
    }

    public void setSrcName(String srcName) {
        this.srcName = srcName;
    }

    public double[][] getRates() {
        return rates;
    }

    public void setRates(double[][] rates) {
        this.rates = rates;
    }

    public Matriz getAnimalRate() {
        return animalRate;
    }

    public void setAnimalRate(Matriz animalRate) {
        this.animalRate = animalRate;
    }
}
