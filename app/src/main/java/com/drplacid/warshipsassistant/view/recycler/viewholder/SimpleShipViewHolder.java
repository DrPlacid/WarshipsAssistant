package com.drplacid.warshipsassistant.view.recycler.viewholder;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drplacid.warshipsassistant.model.RomanNumberUtil;
import com.drplacid.warshipsassistant.view.InteractionListener;
import com.drplacid.warshipsassistant.R;
import com.drplacid.warshipsassistant.model.dto.ShipDTO;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class SimpleShipViewHolder extends RecyclerView.ViewHolder {

    private ShipDTO shipDTO;
    private ImageView shipContour;
    private TextView textView;
    private Context context;

    public SimpleShipViewHolder(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();

        textView = itemView.findViewById(R.id.shipName);
        shipContour = itemView.findViewById(R.id.shipContourImageView);

        itemView.setOnClickListener(view -> {
            InteractionListener listener = (InteractionListener) context;
            long id = shipDTO.getShipId();
            listener.setShip(id);
        });
    }

    public void setData(ShipDTO dto) {
        this.shipDTO = dto;
        String url = dto.getImages().getContour();
        String text = RomanNumberUtil.toRoman(dto.getTier()) + " " + dto.getName();

        textView.setText(text);
        Picasso.get().load(url).into(shipContour);
    }


}
