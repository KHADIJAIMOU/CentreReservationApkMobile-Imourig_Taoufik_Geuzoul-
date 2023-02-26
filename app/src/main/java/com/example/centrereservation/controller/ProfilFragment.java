package com.example.centrereservation.controller;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.centrereservation.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfilFragment extends Fragment {
    private DatabaseReference mDatabase;

    public ProfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_profil, container, false);
        SharedPreferences sharedPref = getActivity().getSharedPreferences("myPrefs", MODE_PRIVATE);
        String userEmail = sharedPref.getString("userEmail", "");
        String adress = sharedPref.getString("adress", "");
        String mobilePhone = sharedPref.getString("mobilePhone", "");
        String password = sharedPref.getString("password", "");
        String token = sharedPref.getString("token", "");

        // use userEmail as needed
        EditText emailTextView = view.findViewById(R.id.editTextEmail);
        EditText editTextTel = view.findViewById(R.id.editTextTel);
        EditText textViewAdresse = view.findViewById(R.id.editTextAdresse);
        EditText edittextpassword = view.findViewById(R.id.editTextPassword);
        EditText edittexttoken = view.findViewById(R.id.editTextRepet);

        emailTextView.setText(userEmail);
        editTextTel.setText(mobilePhone);
        textViewAdresse.setText(adress);
        edittextpassword.setText(password);
        edittexttoken.setText(token);
        Button saveButton = view.findViewById(R.id.editButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the new values from the UI elements
                String newMobilePhone = editTextTel.getText().toString();
                String newAddress = textViewAdresse.getText().toString();
                String newPassword = edittextpassword.getText().toString();
                String newToken = edittexttoken.getText().toString();

                // Save the new values to SharedPreferences
                SharedPreferences sharedPref = getActivity().getSharedPreferences("myPrefs", MODE_PRIVATE);
                String key = sharedPref.getString("key", "");
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("mobilePhone", newMobilePhone);
                editor.putString("adress", newAddress);
                editor.putString("password", newPassword);
                editor.putString("token", newToken);
                editor.apply();
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("users").child("mobilePhone");
                ref.setValue(newMobilePhone);
                DatabaseReference ref2 = FirebaseDatabase.getInstance().getReference().child("users").child("adress");
                ref2.setValue(newAddress);
                DatabaseReference ref3 = FirebaseDatabase.getInstance().getReference().child("users").child("password");
                ref3.setValue(newPassword);
                DatabaseReference ref4 = FirebaseDatabase.getInstance().getReference().child("users").child("token");
                ref4.setValue(newToken);

                // Show the update message as a Toast
                Toast.makeText(getActivity(), "Your data has been updated.", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }


}