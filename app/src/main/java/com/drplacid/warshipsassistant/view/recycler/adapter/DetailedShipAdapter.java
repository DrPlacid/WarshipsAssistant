package com.drplacid.warshipsassistant.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.drplacid.warshipsassistant.R;
import com.drplacid.warshipsassistant.model.dto.ShipDTO;
import com.drplacid.warshipsassistant.view.recycler.viewholder.DetailedShipViewHolder;


public class DetailedShipAdapter extends ListAdapter<ShipDTO, DetailedShipViewHolder> {

    public DetailedShipAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<ShipDTO> DIFF_CALLBACK = new DiffUtil.ItemCallback<ShipDTO>() {
        @Override
        public boolean areItemsTheSame(@NonNull ShipDTO oldItem, @NonNull ShipDTO newItem) {
            return oldItem.getShipId() == newItem.getShipId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull ShipDTO oldItem, @NonNull ShipDTO newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    };

    @NonNull
    @Override
    public DetailedShipViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_ship_info, parent, false);
        int margin = 7;
        int width = parent.getMeasuredWidth() / 2 - 2*margin;
        CardView.LayoutParams p = new CardView.LayoutParams(width, ViewGroup.LayoutParams.WRAP_CONTENT);
        p.setMarginStart(margin);
        p.setMarginEnd(margin);
        itemView.setLayoutParams(p);
        return new DetailedShipViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailedShipViewHolder holder, int position) {
        holder.setData(getItem(position));
    }

}
