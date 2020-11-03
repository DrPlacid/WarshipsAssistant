package com.drplacid.warshipsassistant.view.recycler.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.drplacid.warshipsassistant.R;
import com.drplacid.warshipsassistant.model.parameters.Type;
import com.drplacid.warshipsassistant.view.InteractionListener;

public class TypeViewHolder extends RecyclerView.ViewHolder {

    private Type type;
    private ImageView imageView;
    private CardView container;

    private Context context;

    public TypeViewHolder(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();

        imageView = itemView.findViewById(R.id.typeImage);
        container = itemView.findViewById(R.id.typeHolder);

        imageView.setOnClickListener(view -> {
            InteractionListener listener = (InteractionListener) context;
            listener.setType(this.type, container);
        });
    }

    public void setData(Type type) {
        this.type =  type;
        String imageName = type.getImagePath();

        if (!("").equals(imageName)) {
            int imgId = context.getResources()
                    .getIdentifier(imageName, "drawable", context.getPackageName());
            imageView.setImageResource(imgId);
        }
    }
}
