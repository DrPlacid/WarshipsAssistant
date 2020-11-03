package com.drplacid.warshipsassistant.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drplacid.warshipsassistant.R;
import com.drplacid.warshipsassistant.model.TierWrapper;
import com.drplacid.warshipsassistant.view.recycler.viewholder.TierViewHolder;

import java.util.List;

public class TierAdapter extends RecyclerView.Adapter<TierViewHolder> {

    private List<TierWrapper> tiers;

    public TierAdapter(List<TierWrapper> tiers) {
        this.tiers = tiers;
    }

    @NonNull
    @Override
    public TierViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_one_tier, parent, false);
        return new TierViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TierViewHolder holder, int position) {
        holder.setData(tiers.get(position));
        System.out.println(tiers.get(position).TIER);
    }

    @Override
    public int getItemCount() {
        return tiers.size();
    }
}
