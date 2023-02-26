package com.example.centrereservation.controller;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.centrereservation.R;

public class ProfilFragment extends Fragment {


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

        return view;
    }
}