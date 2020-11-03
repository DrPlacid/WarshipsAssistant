package com.drplacid.warshipsassistant.view;

import androidx.cardview.widget.CardView;

import com.drplacid.warshipsassistant.model.dto.ShipDTO;
import com.drplacid.warshipsassistant.model.parameters.Nation;
import com.drplacid.warshipsassistant.model.parameters.Type;

public interface InteractionListener {
    void setNation(Nation nation, CardView cardView);
    void setType(Type type, CardView cardView);
    void setShip(long shipId);
    void removeShip(ShipDTO dto);
}
