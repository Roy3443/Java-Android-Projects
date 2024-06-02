package com.example.register_and_login;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyPlaceAdapter extends RecyclerView.Adapter<MyPlaceAdapter.ViewHolder> {
    PLace_data[]  place_data;
    Context context;

    public MyPlaceAdapter(PLace_data[] pLace_Data, MainActivity activity) {
        this.place_data=pLace_Data;
        this.context=activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.places,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final  PLace_data pLace_data_list= place_data[position];
        holder.textViewName.setText(pLace_data_list.getPlace_name());
        holder.textViewCountry.setText(pLace_data_list.getPlace_country());
        holder.place_image.setImageResource(pLace_data_list.getPlace_image());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,pLace_data_list.getPlace_name(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return place_data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView place_image;
        TextView textViewName;
        TextView textViewCountry;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            place_image=itemView.findViewById(R.id.image_view);
            textViewName=itemView.findViewById(R.id.place_name);
            textViewCountry=itemView.findViewById(R.id.place_country);
        }
    }
}
