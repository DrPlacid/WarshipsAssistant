package com.drplacid.warshipsassistant.view.recycler.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.drplacid.warshipsassistant.R;
import com.drplacid.warshipsassistant.model.parameters.Type;
import com.drplacid.warshipsassistant.view.recycler.viewholder.TypeViewHolder;

import java.util.List;

public class TypeAdapter extends RecyclerView.Adapter<TypeViewHolder> {

    private List<Type> types;

    public TypeAdapter(List<Type> types) {
        this.types = types;
    }

    private static final DiffUtil.ItemCallback<Type> DIFF_CALLBACK = new DiffUtil.ItemCallback<Type>() {

        @Override
        public boolean areItemsTheSame(@NonNull Type oldItem, @NonNull Type newItem) {
            return oldItem.getName().equals(newItem.getName());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Type oldItem, @NonNull Type newItem) {
            return false;
        }
    };

    @NonNull
    @Override
    public TypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_type_cell, parent, false);
        return new TypeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TypeViewHolder holder, int position) {
        holder.setData(types.get(position));
    }

    @Override
    public int getItemCount() {
        return types.size();
    }

}
