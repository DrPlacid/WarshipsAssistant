package com.drplacid.warshipsassistant.view.recycler.viewholder;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.drplacid.warshipsassistant.R;

public class ParameterViewHolder extends RecyclerView.ViewHolder {

    private TextView nameText;
    private TextView valueText;
    private ProgressBar progress;

    public ParameterViewHolder(@NonNull View itemView) {
        super(itemView);

        nameText = itemView.findViewById(R.id.parameterNameTextView);
        valueText = itemView.findViewById(R.id.parameterNumberTextView);
        progress = itemView.findViewById(R.id.parameterProgressBar);
    }

    public void setData(String name, int value) {
        nameText.setText(name);
        valueText.setText(
                String.valueOf(value)
        );

        if (value > 100) {
            value /= 1000;
        }

        progress.setProgress(value);
    }
}
