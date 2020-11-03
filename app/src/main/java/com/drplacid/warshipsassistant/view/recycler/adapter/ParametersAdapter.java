package com.drplacid.warshipsassistant.view.recycler.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drplacid.warshipsassistant.R;
import com.drplacid.warshipsassistant.view.recycler.viewholder.ParameterViewHolder;

import java.util.List;

public class ParametersAdapter extends RecyclerView.Adapter<ParameterViewHolder> {

    private List<String> names;
    private List<Integer> values;

    public ParametersAdapter(List<String> names, List<Integer> values) {
        this.names = names;
        this.values = values;
        Log.i("TAGGGGG", "" + names + values);
    }

    @NonNull
    @Override
    public ParameterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_ship_parameter, parent, false);
        return new ParameterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ParameterViewHolder holder, int position) {
        String name = names.get(position);
        int value = values.get(position);

        holder.setData(name, value);
    }

    @Override
    public int getItemCount() {
        if (values.size() == names.size()) return values.size();
        return 0;
    }
}
