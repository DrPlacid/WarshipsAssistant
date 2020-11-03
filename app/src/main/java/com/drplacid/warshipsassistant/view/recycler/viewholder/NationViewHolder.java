package com.drplacid.warshipsassistant.view.recycler.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.drplacid.warshipsassistant.view.InteractionListener;
import com.drplacid.warshipsassistant.R;
import com.drplacid.warshipsassistant.model.parameters.Nation;

public class NationViewHolder extends RecyclerView.ViewHolder {

    private Nation nation;
    private ImageView imageView;
    private CardView container;

    private Context context;

    public NationViewHolder(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();
        imageView = itemView.findViewById(R.id.nationImage);
        container = itemView.findViewById(R.id.nationHolder);

        imageView.setOnClickListener(view -> {
            InteractionListener listener = (InteractionListener) context;
            listener.setNation(this.nation, container);
        });
    }

    public void setData(Nation nation) {
        this.nation = nation;

        String imageName = nation.getImagePath();

        if (!("").equals(imageName)) {
            int imgId = context.getResources()
                    .getIdentifier(imageName, "drawable", context.getPackageName());
            imageView.setImageResource(imgId);
        }
    }
}
