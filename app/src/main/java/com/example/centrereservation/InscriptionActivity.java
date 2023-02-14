package com.example.centrereservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.centrereservation.model.Association;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InscriptionActivity extends AppCompatActivity {

    EditText email, password;
    Button login, register;
    FirebaseDatabase database;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextnom = (EditText) findViewById(R.id.editTextNom);
        EditText editTextPrenom = (EditText) findViewById(R.id.editTextPrenom);
        EditText editTextMatricule = (EditText) findViewById(R.id.editTextMatricule);
        EditText editTextAdresse = (EditText) findViewById(R.id.editTextAdresse);
        EditText editTextTelephone = (EditText) findViewById(R.id.editTextTéléphone);
        EditText editTextNomassociation = (EditText) findViewById(R.id.editTextNomassociation);
        EditText editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        EditText editTextMotdepasse = (EditText) findViewById(R.id.editTextMotdepasse);
        EditText editTextCodeVerification = (EditText) findViewById(R.id.editTextCodeVerification);
        Button ImporterFichierJuridique = (Button) findViewById(R.id.ImporterFichierJuridique);
        Button buttonCreer = (Button) findViewById(R.id.buttonCreer);
        Button seConnect=(Button)findViewById(R.id.seConnect);
        buttonCreer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");
                String firstName = editTextPrenom.getText().toString();
                String lastName = editTextnom.getText().toString();
                String matricule = editTextMatricule.getText().toString();
                String adress = editTextAdresse.getText().toString();
                String mobilePhone = editTextTelephone.getText().toString();
                String email = editTextEmail.getText().toString();
                String nomAssociation = editTextNomassociation.getText().toString();
                String password = editTextMotdepasse.getText().toString();
                Date now = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String today = formatter.format(now);
                Date dateCreation = null;
                try {
                    dateCreation = formatter.parse(today);

                } catch (IllegalArgumentException | ParseException e) {
                    e.printStackTrace();
                }
                Date dateValidation = null;
                try {
                    dateValidation = formatter.parse(today);

                } catch (IllegalArgumentException | ParseException e) {
                    e.printStackTrace();
                }
                Date lastConnection = null;
                try {
                    lastConnection = formatter.parse(today);

                } catch (IllegalArgumentException | ParseException e) {
                    e.printStackTrace();
                }
                String legalFile = "java/com/example/centrereservation/legalFile/associationamoudo.pdf";
                String Image = "java/com/example/centrereservation/images/user1.png";
                Integer etat = 1;
                String typeUser = "Association";
                String token = editTextMotdepasse.getText().toString();

                String adressIp = "192.12.3.3";
                if (TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) || TextUtils.isEmpty(mobilePhone)
                        || TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    // If any field is empty, display an error message
                    Toast.makeText(InscriptionActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 8) {
                    // If the password is less than 8 characters, display an error message
                    Toast.makeText(InscriptionActivity.this, "Password must be at least 8 characters long", Toast.LENGTH_SHORT).show();
                } else {
                    // If all fields are filled in and the password is greater than 8, proceed with user creation and verification
                    if (!isValidMobile(mobilePhone)) {
                        // If the mobile phone number is not valid, display an error message
                        Toast.makeText(InscriptionActivity.this, "Invalid mobile phone number \n (+212634983334)", Toast.LENGTH_SHORT).show();
                    } else if (!isValidEmail(email)) {
                        // If the email address is not valid, display an error message
                        Toast.makeText(InscriptionActivity.this, "Invalid email address\n  (email@exemple.com)", Toast.LENGTH_SHORT).show();
                    } else {
                        Association association = new Association(firstName, lastName, mobilePhone, adress, matricule, email, password, typeUser, token, etat, dateCreation, dateValidation, lastConnection, adressIp, nomAssociation, legalFile, Image);
                        String idAssociation = reference.push().getKey();
                        reference.child(idAssociation).setValue(association);
                        Toast.makeText(InscriptionActivity.this, "you have signup successfully ", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(InscriptionActivity.this, MainActivity.class);

                    }
                }
            }
        });
        seConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(InscriptionActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    private boolean isValidMobile(String mobile) {
                return mobile.matches("\\+?212[\\s-]?[567]\\d{8}");
    }
}