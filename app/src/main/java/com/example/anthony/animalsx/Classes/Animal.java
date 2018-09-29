package com.example.anthony.animalsx.Classes;

import java.util.UUID;

public class Animal {
    private String id;
    private String name;
    private String photoLink;

    public Animal(String name){
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }
}
