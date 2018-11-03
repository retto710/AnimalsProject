package com.example.anthony.animalsx.Classes.Anim;

import com.example.anthony.animalsx.Classes.Matriz;

public class Perro {
    private String name= "perro";
    private Integer maxAge = 10;
    private double[][] rates = { { 0, 125.8, 125.8,125.8,125.8,125.8,125.8,125.8,125.8,125.8}, { 4.25, 8, 4.25, 8,4.25, 8,4.25, 8,4.25, 8} };
    private Matriz animalRate;
    private String srcName= "dog";

    public Perro() {
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
