package com.drplacid.warshipsassistant.model.dto.detailed;

import com.google.gson.annotations.SerializedName;

public class WeaponryDTO {

    @SerializedName("anti_aircraft")
    int antiAircraft;

    int aircraft;

    int artillery;

    int torpedoes;

    public int getAntiAircraft() {
        return antiAircraft;
    }

    public int getAircraft() {
        return aircraft;
    }

    public int getArtillery() {
        return artillery;
    }

    public int getTorpedoes() {
        return torpedoes;
    }
}
