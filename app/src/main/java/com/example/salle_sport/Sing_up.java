package com.example.salle_sport;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Sing_up extends AppCompatActivity {
    EditText user;
    EditText email;
    EditText tel;
    EditText daten;
    EditText pass;
    Button rg;
    DatabaseReference database;
    Client client ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sing_up);
        user = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        tel = (EditText) findViewById(R.id.tel);
        daten = (EditText) findViewById(R.id.dateb);
        pass = (EditText) findViewById(R.id.password);
        rg = (Button) findViewById(R.id.signupbtn);
        Intent i = getIntent();

        database = FirebaseDatabase.getInstance().getReference().child("Client");

        rg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String use = user.getText().toString();
                String emai = email.getText().toString();
                String tl = tel.getText().toString();
                String dat = daten.getText().toString();
                String pas = pass.getText().toString();
                if (!use.isEmpty() && !emai.isEmpty() && !tl.isEmpty() && !dat.isEmpty()&& !pas.isEmpty()){
                    if (TextUtils.isDigitsOnly(tl)) {
                        client = new Client();
                        client.setUser(use);
                        client.setDaten(dat);
                        client.setEmail(emai);
                        client.setPass(pas);
                        client.setTel(Long.parseLong(tl));

                        // Set the value of the child to the client object
                        database.child(tl).setValue(client);
                        Toast.makeText(getApplicationContext(), "Data inserted!", Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Phone number must be a valid number!", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Remplir tous les champs!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
