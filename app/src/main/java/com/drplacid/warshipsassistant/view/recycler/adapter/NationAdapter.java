package com.drplacid.warshipsassistant.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drplacid.warshipsassistant.R;
import com.drplacid.warshipsassistant.model.parameters.Nation;
import com.drplacid.warshipsassistant.view.recycler.viewholder.NationViewHolder;

import java.util.List;


public class NationAdapter extends RecyclerView.Adapter<NationViewHolder> {

    private List<Nation> nations;

    public NationAdapter(List<Nation> nations) {
        this.nations = nations;
    }

    @NonNull
    @Override
    public NationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_nation_cell, parent, false);
        return new NationViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NationViewHolder holder, int position) {
        holder.setData(nations.get(position));
    }

    @Override
    public int getItemCount() {
        return nations.size();
    }
}
