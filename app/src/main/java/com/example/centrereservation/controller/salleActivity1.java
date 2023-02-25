package com.example.centrereservation.controller;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.centrereservation.R;
import com.example.centrereservation.model.salle;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class salleActivity1 extends Fragment {

    RecyclerView recyclerView;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    SalleAdapter adapter;
    ArrayList<salle> list;

    public salleActivity1() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_salle_activity1, container, false);
        recyclerView = v.findViewById(R.id.recycleview_salle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext())) ;
        adapter = new SalleAdapter();
        recyclerView.setAdapter(adapter);
        String centreId = getArguments().getString("centreId");
        databaseReference = FirebaseDatabase.getInstance().getReference("salle");
        databaseReference.orderByChild("idCentre").equalTo(centreId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<salle> salles = new ArrayList<>();
                for (DataSnapshot salleSnapshot : snapshot.getChildren()) {
                    salle salle = salleSnapshot.getValue(salle.class);
                    salles.add(salle);
                }
                adapter.setSalles(salles);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("SalleFragment", "Failed to read value.", error.toException());
            }
        });

        return  v;
    }
    private class SalleAdapter extends RecyclerView.Adapter<SalleViewHolder> {

        private List<salle> salles = new ArrayList<>();

        public void setSalles(List<salle> salles) {
            this.salles = salles;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public SalleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_des_salles, parent, false);
            return new SalleViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull SalleViewHolder holder, int position) {
            salle salle = salles.get(position);
            holder.bind(salle);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    effectuerReserv(salle.getIdCentre(),salle.getIdSalle());
//                    Toast.makeText(getActivity(),String.valueOf(salle.getIdCentre())+" est "+String.valueOf(salle.getIdSalle()),Toast.LENGTH_LONG).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return salles.size();
        }
    }

    private static class SalleViewHolder extends RecyclerView.ViewHolder {

        ImageView img_salle;
        TextView availab_salle,nbSeats_sal,typesalle;

        public SalleViewHolder(@NonNull View itemView) {
            super(itemView);
            img_salle = itemView.findViewById(R.id.image_salle);
            availab_salle=itemView.findViewById(R.id.availability_);
            nbSeats_sal=itemView.findViewById(R.id.nbSeats_);
            typesalle=itemView.findViewById(R.id.typeSalle_);
        }

        public void bind(salle salle) {
            Glide.with(img_salle.getContext())
                    .load(salle.getImage())
                    .into(img_salle);
            availab_salle.setText(String.valueOf(salle.getAvailability()));
            nbSeats_sal.setText(String.valueOf(salle.getNbSeats()));
            typesalle.setText(salle.getTypeSalle());
        }
    }
    private void effectuerReserv(String centreId,String salleId) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        ReservationFragment fragment = new ReservationFragment();
        Bundle args = new Bundle();
        args.putString("centreId", centreId);
        args.putString("salleId", salleId);
        fragment.setArguments(args);
        transaction.replace(R.id.navHostFragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}