package com.kazarian.android.homework_recyclerview_internet_activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CarViewHolder extends RecyclerView.ViewHolder {

    TextView txtcartype;
    TextView txtcarlong;
    TextView txtcarLat;
    ImageView imgcarimage;

    public CarViewHolder(@NonNull View itemView) {
        super(itemView);

        txtcartype = itemView.findViewById(R.id.txtCarType);
        txtcarlong = itemView.findViewById(R.id.txtCarLong);
        txtcarLat = itemView.findViewById(R.id.txtCarLat);
        imgcarimage = itemView.findViewById(R.id.imgCarImage);

    }
}
