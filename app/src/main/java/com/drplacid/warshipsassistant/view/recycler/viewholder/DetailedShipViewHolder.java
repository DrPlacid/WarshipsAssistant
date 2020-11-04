package com.drplacid.warshipsassistant.view.recycler.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.drplacid.warshipsassistant.R;
import com.drplacid.warshipsassistant.model.RomanNumberUtil;
import com.drplacid.warshipsassistant.model.dto.ShipDTO;
import com.drplacid.warshipsassistant.view.InteractionListener;
import com.drplacid.warshipsassistant.view.recycler.adapter.ParametersAdapter;
import com.squareup.picasso.Picasso;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailedShipViewHolder extends RecyclerView.ViewHolder {

    private ShipDTO dto;
    private Context context;
    private boolean initialized = false;

    private ImageView shipImage;
    private ImageButton remove;
    private TextView shipName;
    private TextView shipAdditionalInfo;
    private RecyclerView parameters;

    private List<String> names = new ArrayList<>();
    private List<Integer> values = new ArrayList<>();

    public DetailedShipViewHolder(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();

        names.addAll(
                Arrays.asList(
                        context.getResources().getStringArray(R.array.parameters)
                )
        );

        shipImage = itemView.findViewById(R.id.shipImage);
        shipName = itemView.findViewById(R.id.shipName);
        shipAdditionalInfo = itemView.findViewById(R.id.shipAdditionalInfo);
        parameters = itemView.findViewById(R.id.recyclerParameters);
        remove = itemView.findViewById(R.id.removeShipButton);

        remove.setOnClickListener(view -> ((InteractionListener) itemView.getContext()).removeShip(dto));
    }

    public void setData(ShipDTO dto) {
        this.dto = dto;

        if (!initialized) {
            initValues();
            initialized = true;
        }

        initRecycler();
        setImage();
        setHeaderText();
    }

    private void initValues() {
        values.add(this.dto.getDefaultProfile().getHull().getHealth());
        values.add(this.dto.getDefaultProfile().getArmour().getTotal());
        values.add(this.dto.getDefaultProfile().getWeaponry().getArtillery());
        values.add(this.dto.getDefaultProfile().getWeaponry().getTorpedoes());
        values.add(this.dto.getDefaultProfile().getWeaponry().getAircraft());
        values.add(this.dto.getDefaultProfile().getWeaponry().getAntiAircraft());
        values.add(this.dto.getDefaultProfile().getMobility().getTotal());
        values.add(this.dto.getDefaultProfile().getConcealment().getTotal());
    }

    private void setImage() {
        String url = dto.getImages().getImage();
        Picasso.get().load(url).into(shipImage);
    }

    private void setHeaderText() {
        String nation = dto.getNation();

        if (("usa").equals(nation) || ("ussr").equals(nation) || ("uk").equals(nation)) {
            nation = nation.toUpperCase();
        } else {
            nation = StringUtils.capitalize(nation);
        }

        String tier = RomanNumberUtil.toRoman(dto.getTier());

        shipName.setText(dto.getName());
        StringBuilder additionalInfo = new StringBuilder()
                .append(nation)
                .append(" ")
                .append(dto.getType())
                .append(" tier ")
                .append(tier);
        shipAdditionalInfo.setText(additionalInfo.toString());
    }

    private void initRecycler() {
        parameters.setLayoutManager(
                new LinearLayoutManager(context)
        );
        parameters.setHasFixedSize(true);
        ParametersAdapter adapter = new ParametersAdapter(names, values);
        parameters.setAdapter(adapter);
    }

}
