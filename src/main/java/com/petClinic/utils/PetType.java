package com.petClinic.utils;

public enum PetType {

    BIRD("bird"),
    CAT("cat"),
    DOG("dog"),
    HAMSTER("hamster"),
    LIZARD("lizard"),
    SNAKE("snake");

    private String petType;

    PetType(String petType) {
        this.petType = petType;
    }

    public String getPetType() {
        return petType;
    }
}
