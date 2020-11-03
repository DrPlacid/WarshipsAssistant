package com.drplacid.warshipsassistant.view.recycler.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drplacid.warshipsassistant.R;
import com.drplacid.warshipsassistant.model.parameters.Type;
import com.drplacid.warshipsassistant.view.InteractionListener;

public class TypeViewHolder extends RecyclerView.ViewHolder {

    private Type type;
    ImageView imageView;
    Context context;

    public TypeViewHolder(@NonNull View itemView) {
        super(itemView);
        context = itemView.getContext();

        imageView = itemView.findViewById(R.id.typeImage);

        imageView.setOnClickListener(view -> {
            InteractionListener listener = (InteractionListener) context;
            listener.setType(this.type);
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
