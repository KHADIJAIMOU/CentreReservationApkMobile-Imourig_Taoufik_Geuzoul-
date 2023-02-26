package com.example.centrereservation.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.centrereservation.R;
import com.example.centrereservation.model.users;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText PersonEmail,Password;
    Button SeConnect,Inscription;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);
        Password=findViewById(R.id.editTextTextPassword);
        PersonEmail=findViewById(R.id.editTextTextPersonName);
        SeConnect=findViewById(R.id.SeConnect);
        Inscription=findViewById(R.id.Inscription);
        SeConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validatePassword()|!validateUsername()){

                }
                else {
                    checkuser();

                }

            }
        });

        Inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, InscriptionActivity.class);
                startActivity(intent);

            }
        });
    }
    public Boolean validateUsername() {
        String val = PersonEmail.getText().toString();
        if (val.isEmpty()) {
            PersonEmail.setError("Usernane cannot be empty");
            return false;
        } else {
            PersonEmail.setError(null);
            return true;
        }
    }public Boolean validatePassword() {
        String val = Password.getText().toString();
        if (val.isEmpty()) {
            Password.setError("Password cannot be empty");
            return false;
        } else {
            Password.setError(null);
            return true;
        }
    }
    public void checkuser (){
        String userusername = PersonEmail.getText().toString().trim();
        String userpassword = Password.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users") ;
        Query checkUserDatabase = reference. orderByChild ("email").equalTo(userusername);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    PersonEmail.setError(null);
                    String key = snapshot.getChildren().iterator().next().getKey();

                    String passwordFromDb = snapshot.child(key).child("password").getValue(String.class);
                    if(passwordFromDb.equals(userpassword)){
                        PersonEmail.setError(null);

                        String mobilePhone = snapshot.child(key).child("mobilePhone").getValue(String.class);
                        String password = snapshot.child(key).child("password").getValue(String.class);
                        String token = snapshot.child(key).child("token").getValue(String.class);

                        String adress = snapshot.child(key).child("adress").getValue(String.class);
                        String userEmail = PersonEmail.getText().toString().trim();
                        SharedPreferences sharedPref = getSharedPreferences("myPrefs", MODE_PRIVATE);


                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putString("userEmail", userEmail);
                        editor.putString("adress", adress);
                        editor.putString("mobilePhone", mobilePhone);
                        editor.putString("password", password);
                        editor.putString("token", token);

                        editor.apply();
                        Intent intent=new Intent(MainActivity.this, AppActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Password.setError("invalid credential");
                        Password.requestFocus();
                    }
                }else {
                    PersonEmail.setError("user not exist ");
                    PersonEmail.requestFocus();


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}