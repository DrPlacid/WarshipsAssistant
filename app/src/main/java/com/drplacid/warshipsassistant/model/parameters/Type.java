package com.drplacid.warshipsassistant.model.parameters;

public enum Type {

    DESTROYER("Destroyer", "icon_destroyer1"),

    CRUISER("Cruiser", "icon_cruiser1"),

    BATTLESHIP("Battleship", "icon_battleship1"),

    CARRIER("AirCarrier", "icon_carrier1");

    private String name;
    private String imagePath;

    Type(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }

    public String getName(){
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }
}
