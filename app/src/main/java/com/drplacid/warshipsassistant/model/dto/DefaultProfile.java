package com.drplacid.warshipsassistant.model.dto;

import com.drplacid.warshipsassistant.model.dto.detailed.ArmourDTO;
import com.drplacid.warshipsassistant.model.dto.detailed.ConcealmentDTO;
import com.drplacid.warshipsassistant.model.dto.detailed.HullDTO;
import com.drplacid.warshipsassistant.model.dto.detailed.MobilityDTO;
import com.drplacid.warshipsassistant.model.dto.detailed.WeaponryDTO;

public class DefaultProfile {

    ArmourDTO armour;

    HullDTO hull;

    WeaponryDTO weaponry;

    MobilityDTO mobility;

    ConcealmentDTO concealment;

    public ArmourDTO getArmour() {
        return armour;
    }

    public HullDTO getHull() {
        return hull;
    }

    public WeaponryDTO getWeaponry() {
        return weaponry;
    }

    public MobilityDTO getMobility() {
        return mobility;
    }

    public ConcealmentDTO getConcealment() {
        return concealment;
    }
}
