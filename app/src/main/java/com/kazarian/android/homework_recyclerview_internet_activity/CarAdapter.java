package com.kazarian.android.homework_recyclerview_internet_activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CarAdapter extends RecyclerView.Adapter<CarViewHolder> {

    //ArrayList<String> CarList;
    ArrayList<String> Type, Img_Link;
    ArrayList<Double> Lat, Lng;

    public CarAdapter(ArrayList<String> myType, ArrayList<Double> myLat, ArrayList<Double> myLng, ArrayList<String> myimg_Link){
        //CarList = mycarlist;
        this.Type = myType;
        this.Img_Link = myimg_Link;
        this.Lat = myLat;
        this.Lng = myLng;
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_item, parent, false);
        CarViewHolder holder = new CarViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        holder.txtcartype.setText("Car Type = " + Type.get(position));
        holder.txtcarLat.setText("LAT = " + Lat.get(position).toString());
        holder.txtcarlong.setText("LNG = " + Lng.get(position).toString());
        Picasso.get().load(Img_Link.get(position)).fit().into(holder.imgcarimage);


    }

    @Override
    public int getItemCount() {
        int i = 0;
        if (Type != null)
            i = Type.size();
        return i;
    }
}
