package com.drplacid.warshipsassistant.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.drplacid.warshipsassistant.R;
import com.drplacid.warshipsassistant.model.dto.ShipDTO;
import com.drplacid.warshipsassistant.view.recycler.viewholder.SimpleShipViewHolder;

import java.util.List;

public class SimpleShipAdapter extends RecyclerView.Adapter<SimpleShipViewHolder> {

    List<ShipDTO> shipsInTier;

    public SimpleShipAdapter(List<ShipDTO> shipsInTier) {
        this.shipsInTier = shipsInTier;
    }

    @NonNull
    @Override
    public SimpleShipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_ship_cell, parent, false);
        return new SimpleShipViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleShipViewHolder holder, int position) {
        holder.setData(shipsInTier.get(position));
    }

    @Override
    public int getItemCount() {
        return shipsInTier.size();
    }
}
