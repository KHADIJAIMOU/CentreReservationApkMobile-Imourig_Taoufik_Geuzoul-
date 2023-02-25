package com.example.centrereservation.controller;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.centrereservation.R;
import com.example.centrereservation.model.center;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    CentreAdapter adapter;
    ArrayList<center> list;
    private EditText mSearchEditText;
    public HomeFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_home, container, false);
        mSearchEditText = view.findViewById(R.id.search_box);

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
        mSearchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String queryText = s.toString().trim();
                search(queryText);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        return view;
    }
    private void search(String queryText) {
        Query query = FirebaseDatabase.getInstance().getReference().child("Centre")
                .orderByChild("name")
                .startAt(queryText)
                .endAt(queryText + "\uf8ff");
        query.addValueEventListener(new ValueEventListener() {
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
        ImageView img_centre,localisation_icon;
        TextView Nom_centre;


        TextView features_centre;
        public CentreViewHolder (@NonNull  View Itemview) {
            super(Itemview);

            img_centre=Itemview.findViewById(R.id.img_center);
            Nom_centre=Itemview.findViewById(R.id.name_center);
            features_centre =Itemview.findViewById(R.id.features_centre);
            localisation_icon =Itemview.findViewById(R.id.localisation_icon);
        }

        public void bind(center centre) {
            Glide.with(img_centre.getContext())
                    .load(centre.getImage())
                    .into(img_centre);
            Nom_centre.setText(centre.getName());
            features_centre.setText(centre.getFeatures());
            localisation_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    double latitude =centre.getLatitude(); // get latitude from the data model
                    double longitude = centre.getLongitude(); // get longitude from the data model
                    String image = centre.getImage(); // get longitude from the data model
                    String Name =centre.getName(); // get longitude from the data model
                    AppCompatActivity activity = (AppCompatActivity)view.getContext();
                    Intent intent = new Intent(activity, MapsActivity.class);
                    intent.putExtra("latitude", latitude); // pass latitude to the MapsActivity
                    intent.putExtra("longitude", longitude);
                    intent.putExtra("image", image); // pass latitude to the MapsActivity
                    intent.putExtra("Name", Name); // pass longitude to the MapsActivity
                    activity.startActivity(intent);
                }
            });
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

