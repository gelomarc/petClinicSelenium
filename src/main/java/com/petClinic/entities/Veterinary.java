package com.petClinic.entities;

import java.util.ArrayList;
import java.util.List;

public class Veterinary {

    private String name;

    private List<String> specialities;

    public Veterinary(String name) {
        this.name = name;
        this.specialities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSpecialities() {
        return specialities;
    }
}
