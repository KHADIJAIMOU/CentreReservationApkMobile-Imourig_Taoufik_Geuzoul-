package com.example.centrereservation.controller;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.centrereservation.R;
import com.example.centrereservation.model.center;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    CentreAdapter adapter;
    ArrayList<center> list;

    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recycleview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext())) ;
        adapter = new CentreAdapter();
        recyclerView.setAdapter(adapter);
        databaseReference = FirebaseDatabase.getInstance().getReference("Centre");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<center> centres = new ArrayList<>();
                for (DataSnapshot centreSnapshot : snapshot.getChildren()) {
                    center centre = centreSnapshot.getValue(center.class);
                    centres.add(centre);
                }
                adapter.setCentres(centres);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("CentreFragment", "Failed to read value.", error.toException());
            }
        });
//        FirebaseRecyclerOptions<center> options = new FirebaseRecyclerOptions.Builder<center>().setQuery(FirebaseDatabase.getInstance().getReference().child("Centre"), center.class).build();

//        adapter_centere=new List_Adapter_centre(options);
//        recyclerView.setAdapter(adapter_centere);
        // Add an OnItemClickListener to the RecyclerView items

        return view;
    }
    private class CentreAdapter extends RecyclerView.Adapter<CentreViewHolder> {

        private List<center> centres = new ArrayList<>();

        public void setCentres(List<center> centres) {
            this.centres = centres;
            notifyDataSetChanged();
        }
        @NonNull
        @Override
        public CentreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_des_centeres, parent, false);
            return new CentreViewHolder(view);
        }

        @Override
        public int getItemCount() {
            return centres.size();
        }

        @Override
        public void onBindViewHolder(@NonNull CentreViewHolder holder, int position) {
            center centre = centres.get(position);
            holder.bind(centre);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showSalleFragment(centre.getIdCentre());
                }
            });
        }
    };



    private static class CentreViewHolder extends RecyclerView.ViewHolder {
        ImageView img_centre;
        TextView Nom_centre;

        TextView features_centre;
        public CentreViewHolder (@NonNull  View Itemview) {
            super(Itemview);

            img_centre=Itemview.findViewById(R.id.img_center);
            Nom_centre=Itemview.findViewById(R.id.name_center);
            features_centre =Itemview.findViewById(R.id.features_centre);
        }

        public void bind(center centre) {
            Glide.with(img_centre.getContext())
                    .load(centre.getImage())
                    .into(img_centre);
            Nom_centre.setText(centre.getName());
            features_centre.setText(centre.getFeatures());
        }
    }

    private void showSalleFragment(String centreId) {
        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        salleActivity1 fragment = new salleActivity1();
        Bundle args = new Bundle();
        args.putString("centreId", centreId);
        fragment.setArguments(args);
        transaction.replace(R.id.navHostFragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}

