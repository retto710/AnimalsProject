package com.example.anthony.animalsx.Classes.Anim;

import com.example.anthony.animalsx.Classes.Matriz;

public class Example {
    private String name= "example";
    private Integer maxAge = 8;
    private double[][] rates = { { 0, 0, 0.8,0.6,0.1,0.2,0.2,0 }, { 0.95, 0.9,0.75,0.1,0.5,0.3,0,0} };
    private Matriz animalRate;
    private String srcName= "mouse";

    public Example() {
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
