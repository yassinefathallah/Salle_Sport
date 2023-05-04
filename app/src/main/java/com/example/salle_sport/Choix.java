package com.example.salle_sport;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Choix extends AppCompatActivity {

    private Button mBtnCalculerTMC;
    private Button mBtnCalculerProteines;
    private Button mBtnCalculerCalories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choix);

        mBtnCalculerTMC = (Button) findViewById(R.id.btnCalculerTMC);
        mBtnCalculerProteines = (Button) findViewById(R.id.btnCalculerProteines);
        mBtnCalculerCalories = (Button) findViewById(R.id.btnCalculerCalories);

        mBtnCalculerTMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Choix.this, Tmc.class);
                startActivity(intent3);
            }
        });

        mBtnCalculerProteines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(Choix.this, Proteine.class);
                startActivity(intent4);
            }
        });

        mBtnCalculerCalories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(Choix.this, Calorie.class);
                startActivity(intent5);
            }
        });
    }
}
