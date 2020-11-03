package com.drplacid.warshipsassistant.model;

import androidx.annotation.NonNull;

import com.drplacid.warshipsassistant.model.dto.ShipDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TierWrapper {

    private List<ShipDTO> shipsOfTier = new ArrayList<>();
    private Set<String> nameSet = new HashSet<>();

    public final int TIER;

    public TierWrapper(int tier) {
        TIER = tier;
    }

    public List<ShipDTO> getShipsOfTier() {
        return shipsOfTier;
    }

    public void add(ShipDTO dto) {
        if (checkAvailableName(dto) && checkNotDuplicates(dto)) addAndSort(dto);
    }

    private boolean checkAvailableName(ShipDTO dto) {
        return !dto.getName().contains("[")|| dto.getName().contains("'");
    }

    private boolean checkNotDuplicates(ShipDTO dto) {
        return !nameSet.contains(dto.getName());
    }

    private void addAndSort(ShipDTO dto) {
        shipsOfTier.add(dto);
        nameSet.add(dto.getName());

        Collections.sort(shipsOfTier, (dto1, dto2) -> {
            if((dto1.isPremium() || dto1.isSpecial()) && (!dto2.isPremium() || !dto2.isSpecial())) return 1;
            if((!dto1.isPremium() || !dto1.isSpecial()) && (dto2.isPremium() || dto2.isSpecial())) return -1;
            else return 0;
        });
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ShipDTO dto : shipsOfTier) {
            sb.append(dto.getName())
                    .append(" ");
        }
        return sb.toString();
    }
}
