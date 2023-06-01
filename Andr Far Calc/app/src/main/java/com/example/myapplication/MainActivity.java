package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private EditText editTextHeight;
    private EditText editTextFingerLength;
    private EditText editTextEyeToFingerDistance;
    private EditText editTextFingerProjectionRatio;
    private Button buttonCalculate;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHeight = findViewById(R.id.editTextHeight);
        editTextFingerLength = findViewById(R.id.editTextFingerLength);
        editTextEyeToFingerDistance = findViewById(R.id.editTextEyeToFingerDistance);
        editTextFingerProjectionRatio = findViewById(R.id.editTextFingerProjectionRatio);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDistance();
            }
        });
    }

    private void calculateDistance() {
        double height = Double.parseDouble(editTextHeight.getText().toString());
        double fingerLength = Double.parseDouble(editTextFingerLength.getText().toString());
        double eyeToFingerDistance = Double.parseDouble(editTextEyeToFingerDistance.getText().toString());
        double fingerProjectionRatio = Double.parseDouble(editTextFingerProjectionRatio.getText().toString());

        double objectLength = (fingerProjectionRatio * fingerLength) / 100; // Проекция длины объекта на палец
        double distance = (height * eyeToFingerDistance) / objectLength; // Расчет расстояния

        textViewResult.setText("Расстояние до объекта: " + distance + " метров");
    }
}