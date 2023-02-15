package com.example.centrereservation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.centrereservation.controller.salleActivity1;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.text.BreakIterator;

public class List_Adapter_centre extends FirebaseRecyclerAdapter<center,List_Adapter_centre.MyViewHolder>
{

    public List_Adapter_centre(@NonNull FirebaseRecyclerOptions<center> options) {
        super(options);

    }


    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull center model) {


        holder.Nom_centre.setText(model.getName());
        holder.features_centre.setText(model.getfeatures());
        Glide.with(holder.img_centre.getContext()).load(model.getImage()).into(holder.img_centre);
        holder.img_centre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.home,new salleActivity1()).addToBackStack(null).commit();
            }
        });

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_des_centeres,parent,false);
        return new MyViewHolder(v);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView img_centre;
        TextView Nom_centre;

        TextView features_centre;
        public MyViewHolder (@NonNull  View Itemview) {
            super(Itemview);

            img_centre=Itemview.findViewById(R.id.img_center);
            Nom_centre=Itemview.findViewById(R.id.name_center);
            features_centre =Itemview.findViewById(R.id.features_centre);
        }

    }



}