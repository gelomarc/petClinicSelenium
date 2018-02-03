package com.petClinic.entities;

import com.petClinic.utils.PetType;

import java.time.LocalDateTime;
import java.util.List;

public class Pet {

    private String name;

    private LocalDateTime birthDate;

    private PetType petType;

    private Owner owner;

    private List<Visit> visitList;

    public Pet(String name, LocalDateTime birthDate, PetType petType, Owner owner) {
        this.name = name;
        this.birthDate = birthDate;
        this.petType = petType;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Visit> getVisitList() {
        return visitList;
    }
}
