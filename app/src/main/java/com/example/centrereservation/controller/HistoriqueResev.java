package com.example.centrereservation.controller;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.centrereservation.R;
import com.example.centrereservation.model.Reservation;
import com.example.centrereservation.controller.List_Adapter_reservation;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;

public class HistoriqueResev extends Fragment {
    RecyclerView recyclerView;
    DatabaseReference database;
    List_Adapter_reservation adapter_reserv;
    ArrayList<Reservation> list;

    public HistoriqueResev() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_historique_resev, container, false);
        recyclerView =view.findViewById(R.id.recycleviewHis);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        FirebaseRecyclerOptions<Reservation> options = new FirebaseRecyclerOptions.Builder<Reservation>().setQuery(FirebaseDatabase.getInstance().getReference().child("Reservation"), Reservation.class).build();

        adapter_reserv = new List_Adapter_reservation(options);
        recyclerView.setAdapter(adapter_reserv);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter_reserv.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter_reserv.stopListening();
    }
}