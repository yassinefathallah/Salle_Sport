package com.example.salle_sport;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Tmc extends AppCompatActivity{






        private RadioGroup genderGroup;
        private EditText ageInput, heightInput, weightInput;
        private TextView resultText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.tmc);

            genderGroup = findViewById(R.id.genderGroup);
            ageInput = findViewById(R.id.ageEditText);
            heightInput = findViewById(R.id.heightEditText);
            weightInput = findViewById(R.id.weightEditText);
            resultText = findViewById(R.id.resultTextView);

            Button calculateButton = findViewById(R.id.calculateButton);
            calculateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    calculateBMI();
                }
            });
        }

        private void calculateBMI() {
            int genderId = genderGroup.getCheckedRadioButtonId();
            double age = Double.parseDouble(ageInput.getText().toString());
            double height = Double.parseDouble(heightInput.getText().toString());
            double weight = Double.parseDouble(weightInput.getText().toString());

            double bmr;
            if (genderId == R.id.maleButton) {
                bmr = 10 * weight + 6.25 * height - 5 * age + 5;
            } else {
                bmr = 10 * weight + 6.25 * height - 5 * age - 161;
            }

            double bmi = weight / ((height / 100) * (height / 100));

            @SuppressLint("DefaultLocale") String result = "Your BMR is " + String.format("%.2f", bmr) + " and your BMI is " + String.format("%.2f", bmi);
            resultText.setText(result);
        }
    }




