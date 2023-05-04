package com.example.salle_sport;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

    public class Proteine extends AppCompatActivity {

        private EditText weightInput;
        private RadioGroup activityLevelGroup;
        private Button calculateButton;
        private TextView resultText;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.proteine);

            weightInput = findViewById(R.id.weightInput);
            activityLevelGroup = findViewById(R.id.activityLevelGroup);
            calculateButton = findViewById(R.id.calculateButton);
            resultText = findViewById(R.id.resultText);

            calculateButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    calculateProteinNeeds();
                }
            });
        }

        private void calculateProteinNeeds() {
            // Get the user's weight in kg
            double weight = Double.parseDouble(weightInput.getText().toString());

            // Determine the user's activity level based on the selected radio button
            String activityLevel = "0";
            int selectedId = activityLevelGroup.getCheckedRadioButtonId();
            if (selectedId == R.id.sedentaryButton) {
                activityLevel = "1";
            } else if (selectedId == R.id.lightButton) {
                activityLevel = "1.3";
            } else if (selectedId == R.id.moderateButton) {
                activityLevel = "1.6";
            } else if (selectedId == R.id.heavyButton) {
                activityLevel = "1.8";
            } else if (selectedId == R.id.veryHeavyButton) {
                activityLevel =  "2.0";
            }

            // Calculate the user's protein needs
            double proteinNeeds = weight * Integer.parseInt(activityLevel);

            // Display the result
            resultText.setText("Your protein needs are " + proteinNeeds + " grams per day.");
        }
    }


