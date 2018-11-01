package com.example.anthony.animalsx.Classes.Anim;

import com.example.anthony.animalsx.Classes.Matriz;

public class Ardilla {
    private String name= "rata";
    private Integer maxAge = 3;
    private double[][] rates = { { 0.28, 1.2, 0.5 }, { 0.51, 0.81, 0} };
    private Matriz animalRate;
    private String srcName= "mouse";

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
