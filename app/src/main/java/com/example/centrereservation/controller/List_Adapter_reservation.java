package com.example.centrereservation.controller;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.centrereservation.R;
import com.example.centrereservation.model.Reservation;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.text.SimpleDateFormat;

public class List_Adapter_reservation extends FirebaseRecyclerAdapter<Reservation, List_Adapter_reservation.MyViewHolder> {

    private FirebaseStorage mStorage;

    public List_Adapter_reservation(@NonNull FirebaseRecyclerOptions<Reservation> options) {
        super(options);
        mStorage = FirebaseStorage.getInstance();
    }

    @Override
    protected void onBindViewHolder(@NonNull final List_Adapter_reservation.MyViewHolder holder, int position, @NonNull Reservation model) {
        String progress = model.getProgress();

        if (progress.equals("en attente")) {
            holder.Avancement.setTextColor(Color.parseColor("#FFA500"));
        } else if (progress.equals("Acceptée")) {
            holder.Avancement.setTextColor(Color.GREEN);
        } else if (progress.equals("Refusée")) {
            holder.Avancement.setTextColor(Color.RED);
        }

        holder.Nom_rese.setText( "\nDate Début : " + model.getDateStart() + "\nDate Fin : " + model.getDateEnd() + "\nTemps Début : " + model.getTimeStart() + "\nTemps Fin : " + model.getTimeEnd() + "\nAvancement :  \n");
        holder.Avancement.setText("        \n\n            "+progress);

        // Fetch the center's image URL from Firebase Storage using the center's id
        DatabaseReference centerRef = FirebaseDatabase.getInstance().getReference("Centre").child(model.getIdCentre());
        centerRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String imageUrl = snapshot.child("image").getValue(String.class);
                    String nameCentrre = snapshot.child("name").getValue(String.class);
                    holder.NomCentre.setText("Centre : " + nameCentrre);

                    // Load the center's image into the ImageView using Glide library
                    Glide.with(holder.itemView.getContext())
                            .load(imageUrl)
                            .into(holder.CenterImage);
                } else {
                    // Hide the ImageView if the center is not found in the database
                    holder.CenterImage.setVisibility(View.GONE);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            };
        });

        // Fetch the salle's name from Firebase Database using the salle's id
        DatabaseReference salleRef = FirebaseDatabase.getInstance().getReference("salle").child(model.getIdSalle());
        salleRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    String namesalle = snapshot.child("typeSalle").getValue(String.class);
                    holder.NomSalle.setText("Salle : " + namesalle);
                } else {
                    // Hide the NomSalle TextView if the salle is not found in the database
                    holder.NomSalle.setVisibility(View.GONE);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            };
        });
    }



    @NonNull
    @Override
    public List_Adapter_reservation.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_des_reservation, parent, false);
        return new List_Adapter_reservation.MyViewHolder(v);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView Nom_rese, Progress,NomCentre,NomSalle,Avancement;
        ImageView CenterImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Avancement= itemView.findViewById(R.id.Avancement);
            Nom_rese = itemView.findViewById(R.id.Nom_rese);
            CenterImage = itemView.findViewById(R.id.img_reser);
            NomCentre= itemView.findViewById(R.id.NomCentre);
            NomSalle= itemView.findViewById(R.id.NomSalle);
        }
    }
}

