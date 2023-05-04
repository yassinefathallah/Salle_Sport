package com.example.salle_sport;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Calorie extends Activity {

    private RadioGroup genderGroup;
    private RadioButton maleButton;
    private RadioButton femaleButton;
    private EditText ageInput;
    private EditText heightInput;
    private EditText weightInput;
    private Button calculateButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tmc1);

        genderGroup = findViewById(R.id.genderGroup);
        maleButton = findViewById(R.id.maleButton);
        femaleButton = findViewById(R.id.femaleButton);
        ageInput = findViewById(R.id.ageInput1);
        heightInput = findViewById(R.id.heightInput1);
        weightInput = findViewById(R.id.weightInput1);
        calculateButton = findViewById(R.id.calculateButton);
        resultText = findViewById(R.id.resultText1);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private void calculate() {
        int genderId = genderGroup.getCheckedRadioButtonId();
        double age = Double.parseDouble(ageInput.getText().toString());
        double height = Double.parseDouble(heightInput.getText().toString());
        double weight = Double.parseDouble(weightInput.getText().toString());

        double bmr;
        if (genderId == maleButton.getId()) {
            bmr = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else {
            bmr = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }

        resultText.setText("Your BMR is " + bmr);
    }
}
