package com.mmestre.model;

import java.util.List;

@lombok.Getter @lombok.Setter
public class Maker {
    private String name;
    private String unFixedName;
    private String placeOfBirth;
    private String dateOfBirth;
    private String dateOfBirthPrecision;
    private String dateOfDeath;
    private String dateOfDeathPrecision;
    private String placeOfDeath;
    private List<String> occupation ;
    private List<String> roles;
    private String nationality;
    private String biography;
    private List<String> productionPlaces;
    private String qualification;
    private String labelDesc;
}
