package com.drplacid.warshipsassistant.view.recycler.viewholder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.drplacid.warshipsassistant.R;
import com.drplacid.warshipsassistant.model.TierWrapper;
import com.drplacid.warshipsassistant.view.recycler.adapter.SimpleShipAdapter;


public class TierViewHolder extends RecyclerView.ViewHolder {

    RecyclerView shipsInTierRecycler;

    public TierViewHolder(@NonNull View itemView) {
        super(itemView);
        shipsInTierRecycler = itemView.findViewById(R.id.shipsInTierRecycler);
        shipsInTierRecycler.setLayoutManager(
                new LinearLayoutManager(itemView.getContext())
        );
        shipsInTierRecycler.setHasFixedSize(true);
    }

    public void setData(TierWrapper tierWrapper) {
        SimpleShipAdapter adapter = new SimpleShipAdapter(tierWrapper.getShipsOfTier());
        shipsInTierRecycler.setAdapter(adapter);
    }
}
