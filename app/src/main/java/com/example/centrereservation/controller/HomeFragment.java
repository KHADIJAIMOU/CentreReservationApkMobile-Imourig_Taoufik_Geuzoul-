package com.example.centrereservation.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.centrereservation.controller.List_Adapter_centre;
import com.example.centrereservation.R;
import com.example.centrereservation.center;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    DatabaseReference database;
    List_Adapter_centre adapter_centere;
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
        FirebaseRecyclerOptions<center> options = new FirebaseRecyclerOptions.Builder<center>().setQuery(FirebaseDatabase.getInstance().getReference().child("Centre"), center.class).build();


        adapter_centere=new List_Adapter_centre(options);
        recyclerView.setAdapter(adapter_centere);
        // Add an OnItemClickListener to the RecyclerView items

        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        adapter_centere.startListening();
    }
    @Override
    public void onStop() {
        super.onStop();
        adapter_centere.stopListening();
    }
}