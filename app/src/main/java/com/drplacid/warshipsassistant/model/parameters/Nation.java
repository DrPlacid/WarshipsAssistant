package com.drplacid.warshipsassistant.model.parameters;

public enum Nation {

    JAPAN("japan",
            "Japan",
            "flag_japan",
            new Type[] {Type.DESTROYER, Type.CRUISER, Type.BATTLESHIP, Type.CARRIER}),

    USA("usa",
            "USA",
            "flag_usa",
            new Type[] {Type.DESTROYER, Type.CRUISER, Type.BATTLESHIP, Type.CARRIER}),

    UK("uk",
            "UK",
            "flag_uk",
            new Type[] {Type.DESTROYER, Type.CRUISER, Type.BATTLESHIP, Type.CARRIER}),

    GERMANY("germany",
            "Germany",
            "flag_germany",
            new Type[] {Type.DESTROYER, Type.CRUISER, Type.BATTLESHIP, Type.CARRIER}),

    EU("europe",
            "Europe",
            "flag_eu",
            new Type[] {Type.DESTROYER}),

    PAN_ASIA("pan_asia",
            "Pan Asia",
            "flag_pan_asia",
            new Type[] {Type.DESTROYER, Type.CRUISER}),

    USSR("ussr",
            "USSR",
            "flag_ussr",
            new Type[] {Type.DESTROYER, Type.CRUISER, Type.BATTLESHIP}),

    FRANCE("france",
            "France",
            "flag_france",
            new Type[] {Type.DESTROYER, Type.CRUISER, Type.BATTLESHIP}),

    ITALY("italy",
            "Italy",
            "flag_italy",
            new Type[] {Type.DESTROYER, Type.CRUISER, Type.BATTLESHIP});

/*    PAN_AMERICA("pan_america",
            "",
            new Type[]{Type.CRUISER});*/

    private String apiName;
    private String displayedName;
    private String imagePath;
    private Type[] typesAvailable;

    Nation(String apiName, String displayedName, String imagePath, Type[] typesAvailable) {
        this.apiName = apiName;
        this.displayedName = displayedName;
        this.imagePath = imagePath;
        this.typesAvailable = typesAvailable;
    }

    public String getApiName(){
        return apiName;
    }

    public String getDisplayedName() {
        return displayedName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public Type[] getTypesAvailable() {
        return typesAvailable;
    }
}
