package com.drplacid.warshipsassistant.view;

import com.drplacid.warshipsassistant.model.dto.ShipDTO;
import com.drplacid.warshipsassistant.model.parameters.Nation;
import com.drplacid.warshipsassistant.model.parameters.Type;

public interface InteractionListener {
    void setNation(Nation nation);
    void setType(Type type);
    void setShip(long shipId);
    void removeShip(ShipDTO dto);
}
