package com.drplacid.warshipsassistant.model.dto.detailed;

import com.google.gson.annotations.SerializedName;

public class MobilityDTO {

    @SerializedName("rudder_time")
    double rudderTime;

    int total;

    @SerializedName("turning_radius")
    int turningRadius;

    @SerializedName("max_speed")
    double maxSpeed;

    public double getRudderTime() {
        return rudderTime;
    }

    public int getTotal() {
        return total;
    }

    public int getTurningRadius() {
        return turningRadius;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }
}
