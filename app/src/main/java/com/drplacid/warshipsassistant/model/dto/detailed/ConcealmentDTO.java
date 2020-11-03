package com.drplacid.warshipsassistant.model.dto.detailed;

import com.google.gson.annotations.SerializedName;

public class ConcealmentDTO {

    int total;

    @SerializedName("detect_distance_by_plane")
    double detectDistanceByPlane;

    @SerializedName("detect_distance_by_ship")
    double detectDistanceByShip;

    public int getTotal() {
        return total;
    }

    public double getDetectDistanceByPlane() {
        return detectDistanceByPlane;
    }

    public double getDetectDistanceByShip() {
        return detectDistanceByShip;
    }
}
