package com.example.centrereservation.controller;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.InputType;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class ReservationFragment extends Fragment{
    Button btn;
    EditText dateDebut, dateFin, tempsD,tempsF,obj;
    FirebaseDatabase database;
    DatabaseReference reference;
    ImageButton buttonBack;
    public ReservationFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reservation, container, false);
        btn= view.findViewById(R.id.btnreserver);
        dateDebut = view.findViewById(R.id.editTextDateD);
        dateFin = view.findViewById(R.id.editTextDateF);
        tempsD = view.findViewById(R.id.editTextTempsD);
        tempsF = view.findViewById(R.id.editTextTempsF);
        obj = view.findViewById(R.id.editTextObj);
        buttonBack = view.findViewById(R.id.buttonBack);
        dateDebut.setInputType(InputType.TYPE_NULL);
        dateFin.setInputType(InputType.TYPE_NULL);
        tempsD.setInputType(InputType.TYPE_NULL);
        tempsF.setInputType(InputType.TYPE_NULL);
        String centreId = getArguments().getString("centreId");
        String salleId = getArguments().getString("salleId");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("Reservation");
                DatabaseReference newRef = reference.push();
                String reservationId = newRef.getKey();
                String dateD = dateDebut.getText().toString();
                String dateF =dateFin.getText().toString();
                String tempsDeb = tempsD.getText().toString();
                String tempsFin = tempsF.getText().toString();
                String object = obj.getText().toString();
                String progress = "en attente";
                if(dateD.isEmpty() || dateF.isEmpty() || tempsDeb.isEmpty() || tempsFin.isEmpty() || object.isEmpty()){
                    Toast.makeText(getActivity(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    Reservation reservation = new Reservation(reservationId,dateD,dateF,tempsDeb,tempsFin,progress,object,centreId,salleId);
                    newRef.setValue(reservation);
                    AffichagereservFragment affFrag = new AffichagereservFragment();
                    Bundle bundle = new Bundle();
                    bundle.putString("reservationId", reservationId);
                    bundle.putString("centreId", centreId);
                    bundle.putString("salleId", salleId);
                    affFrag.setArguments(bundle);
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.navHostFragment, affFrag);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
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

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment salleAc = new HomeFragment();
                Bundle bundle = new Bundle();
                bundle.putString("centreId", centreId);
                salleAc.setArguments(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.navHostFragment, salleAc);
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