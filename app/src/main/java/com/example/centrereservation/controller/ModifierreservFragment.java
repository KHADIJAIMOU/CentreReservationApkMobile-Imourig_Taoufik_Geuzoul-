package com.example.centrereservation.controller;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.centrereservation.R;
import com.example.centrereservation.model.Reservation;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class ModifierreservFragment extends Fragment {
    ImageButton btnBack;
    Button btnMod;
    EditText dateDebut, dateFin, tempsD,tempsF,obj;
    String reservationId;
    DatabaseReference mDatabase;
    public ModifierreservFragment() {
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_modifierreserv, container, false);
        btnBack = view.findViewById(R.id.buttonBack2);
        dateDebut = view.findViewById(R.id.editTextDateD);
        dateFin = view.findViewById(R.id.editTextDateF);
        tempsD = view.findViewById(R.id.editTextTempsD);
        tempsF = view.findViewById(R.id.editTextTempsF);
        obj = view.findViewById(R.id.editTextObj);
        btnMod = view.findViewById(R.id.btnmodifier);
        dateDebut.setInputType(InputType.TYPE_NULL);
        dateFin.setInputType(InputType.TYPE_NULL);
        tempsD.setInputType(InputType.TYPE_NULL);
        tempsF.setInputType(InputType.TYPE_NULL);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        String centreId = getArguments().getString("centreId");
        String salleId = getArguments().getString("salleId");

        reservationId = getArguments().getString("reservationId");

        mDatabase.child("Reservation").child(reservationId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Reservation reservation = dataSnapshot.getValue(Reservation.class);
                if (reservation != null) {
                    // Display the reservation details in the EditTexts
                    dateDebut.setText(reservation.getDateStart());
                    dateFin.setText(reservation.getDateEnd());
                    tempsD.setText(reservation.getTimeStart());
                    tempsF.setText(reservation.getTimeEnd());
                    obj.setText(reservation.getNotice());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("ModifierreservFragment", "onCancelled: " + databaseError.getMessage());
            }
        });

        btnMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newDateDebut = dateDebut.getText().toString().trim();
                String newDateFin = dateFin.getText().toString().trim();
                String newtempsD = tempsD.getText().toString().trim();
                String newtempsF = tempsF.getText().toString().trim();
                String newobj = obj.getText().toString().trim();
                if(newDateDebut.isEmpty() || newDateFin.isEmpty() || newtempsD.isEmpty() || newtempsF.isEmpty() || newobj.isEmpty()){
                    Toast.makeText(getActivity(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    Map<String, Object> reservationUpdates = new HashMap<>();
                    reservationUpdates.put("dateStart",dateDebut.getText() );
                    reservationUpdates.put("dateEnd", dateFin.getText());
                    reservationUpdates.put("timeStart", tempsD.getText());
                    reservationUpdates.put("timeEnd", tempsF.getText());
                    reservationUpdates.put("notice", obj.getText());
                    Reservation updatedReservation = new Reservation(reservationId, newDateDebut, newDateFin, newtempsD, newtempsF, "en attente", newobj,centreId,salleId);
                    Map<String, Object> reservationValues = updatedReservation.toMap();
                    Map<String, Object> childUpdates = new HashMap<>();
                    childUpdates.put("/Reservation/" + reservationId, reservationValues);
                    mDatabase.updateChildren(childUpdates, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                            if (databaseError != null) {
                                Log.d("ModifierreservFragment", "onComplete: " + databaseError.getMessage());
                                Toast.makeText(getContext(), "Erreur lors de la modification de la réservation", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getContext(), "Réservation modifiée avec succès", Toast.LENGTH_LONG).show();
                                AffichagereservFragment affFrag = new AffichagereservFragment();
                                Bundle bundle = new Bundle();
                                bundle.putString("reservationId", reservationId);
                                affFrag.setArguments(bundle);
                                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                fragmentTransaction.replace(R.id.navHostFragment, affFrag);
                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                            }
                        }
                    });
                }
            }
        });

        dateDebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(dateDebut);
            }
        });

        dateFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(dateFin);
            }
        });
        tempsD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog(tempsD);
            }
        });
        tempsF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog(tempsF);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AffichagereservFragment affFrag = new AffichagereservFragment();
                Bundle bundle = new Bundle();
                bundle.putString("reservationId", reservationId);
                affFrag.setArguments(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.navHostFragment, affFrag);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;

    }
    private void showTimePickerDialog(EditText edt) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(
                getContext(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        // Set the time to the EditText
                        String time = hour + ":" + minute;
                        edt.setText(time);
                    }
                },
                Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                Calendar.getInstance().get(Calendar.MINUTE),
                false
        );
        timePickerDialog.show();

    }

    private void showDatePickerDialog(EditText edt) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        String date = day + "/" + (month + 1) + "/" + year;
                        edt.setText(date);
                    }
                }, year, month, day);
        datePickerDialog.show();
    }

}