package com.example.centrereservation.controller;

import static com.example.centrereservation.R.id.buttonBack1;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.centrereservation.R;
import com.example.centrereservation.model.Reservation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AffichagereservFragment extends Fragment {
    Button btnM,btnAnn;
    ImageButton btnBack;
    TextView txtDD,txtDF,txtTD,txtTF,txtObj;
    ImageView imgProgress;
    DatabaseReference databaseReference;
    public AffichagereservFragment() {
        // Required empty public constructor
    }
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_affichagereserv, container, false);
        btnM= view.findViewById(R.id.buttonMod);
        btnBack = view.findViewById(buttonBack1);
        imgProgress = view.findViewById(R.id.imageView2);
        txtDD = view.findViewById(R.id.textDateD);
        txtDF = view.findViewById(R.id.textDateF);
        txtTD = view.findViewById(R.id.textTempsD);
        txtTF = view.findViewById(R.id.textTempsF);
        txtObj = view.findViewById(R.id.textObj);
        btnAnn = view.findViewById(R.id.buttonAnn);

        String centreId = getArguments().getString("centreId");
        String salleId = getArguments().getString("salleId");
        String reservationId = getArguments().getString("reservationId");
        databaseReference = FirebaseDatabase.getInstance().getReference("Reservation");

        // retrieve reservation data and update text views
        databaseReference.child(reservationId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Reservation reservation = snapshot.getValue(Reservation.class);
                if (reservation != null) {
                    txtDD.setText(reservation.getDateStart());
                    txtDF.setText(reservation.getDateEnd());
                    txtTD.setText(reservation.getTimeStart());
                    txtTF.setText(reservation.getTimeEnd());
                    txtObj.setText(reservation.getNotice());
                    if(reservation.getProgress() == "en attente"){
                        imgProgress.setImageResource(getResources().getIdentifier("encour","drawable",requireContext().getPackageName()));
                    }
                    else if(reservation.getProgress() == "accepté"){
                        imgProgress.setImageResource(getResources().getIdentifier("accept","drawable",requireContext().getPackageName()));

                    }
                    else if(reservation.getProgress() == "refuseer"){
                        imgProgress.setImageResource(getResources().getIdentifier("refus","drawable",requireContext().getPackageName()));

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("AffichagereservFragment", "Error retrieving reservation data", error.toException());
            }
        });

        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModifierreservFragment modFrag = new ModifierreservFragment();
                Bundle bundle = new Bundle();
                bundle.putString("reservationId", reservationId);
                bundle.putString("centreId", centreId);
                bundle.putString("salleId", salleId);
                modFrag.setArguments(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.navHostFragment, modFrag);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        btnAnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.child(reservationId).removeValue()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                // deletion successful
                                Toast.makeText(getActivity(), "Reservation deleted successfully", Toast.LENGTH_SHORT).show();
                                ReservationFragment resFrag = new ReservationFragment();
                                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.navHostFragment, resFrag);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                // deletion failed
                                Toast.makeText(getActivity(), "Failed to delete reservation", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReservationFragment resFrag = new ReservationFragment();
                Bundle bundle = new Bundle();
                bundle.putString("reservationId", reservationId);
                bundle.putString("centreId", centreId);
                bundle.putString("salleId", salleId);
                resFrag.setArguments(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.navHostFragment, resFrag);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}