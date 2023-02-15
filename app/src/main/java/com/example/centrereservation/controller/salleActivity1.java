package com.example.centrereservation.controller;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.centrereservation.controller.List_Adapter_centre;
import com.example.centrereservation.R;
import com.example.centrereservation.center;
import com.example.centrereservation.list_adapter_salle;
import com.example.centrereservation.salle;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link salleActivity1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class salleActivity1 extends Fragment {

    RecyclerView recyclerView;
    DatabaseReference database;
    list_adapter_salle adapter_salle;
    ArrayList<salle> list;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public salleActivity1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment salleActivity1.
     */
    // TODO: Rename and change types and number of parameters
    public static salleActivity1 newInstance(String param1, String param2) {
        salleActivity1 fragment = new salleActivity1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_salle_activity1, container, false);
        recyclerView = v.findViewById(R.id.recycleview_salle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext())) ;
        FirebaseRecyclerOptions<salle> options = new FirebaseRecyclerOptions.Builder<salle>().setQuery(FirebaseDatabase.getInstance().getReference().child("salle"), salle.class).build();

        adapter_salle=new list_adapter_salle(options);
        recyclerView.setAdapter(adapter_salle);
        return  v;
    }
    @Override
    public void onStart() {
        super.onStart();
        adapter_salle.startListening();
    }
    @Override
    public void onStop() {
        super.onStop();
        adapter_salle.stopListening();
    }
}