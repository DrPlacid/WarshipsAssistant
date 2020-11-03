package com.drplacid.warshipsassistant.model.dto;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.drplacid.warshipsassistant.model.RomanNumberUtil;
import com.drplacid.warshipsassistant.model.dto.detailed.Media;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import kotlin.jvm.Transient;

public class ShipDTO implements Comparable<ShipDTO> {

    @SerializedName("ship_id")
    long shipId;

    String name;

    String nation;

    String type;

    int tier;

    @SerializedName("is_premium")
    boolean isPremium;

    @SerializedName("is_special")
    boolean isSpecial;

    @SerializedName("default_profile")
    DefaultProfile defaultProfile;

    Media images;


    public long getShipId() {
        return shipId;
    }

    public String getName() {
        return name;
    }

    public String getNation() {
        return nation;
    }

    public String getType() {
        return type;
    }

    public int getTier() {
        return tier;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public boolean isSpecial() {
        return isSpecial;
    }

    public DefaultProfile getDefaultProfile() {
        return defaultProfile;
    }

    public Media getImages() {
        return images;
    }

    @Override
    public int compareTo(ShipDTO shipDTO) {
        return -1*Integer.compare(shipDTO.getTier(), this.tier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shipId);
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return shipId == ((ShipDTO) obj).getShipId();
    }

    @NonNull
    @Override
    public String toString() {
        return this.getName();
    }
}
