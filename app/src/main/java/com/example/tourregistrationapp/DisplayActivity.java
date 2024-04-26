package com.example.tourregistrationapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayActivity extends AppCompatActivity {

    private TextView textViewDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        textViewDisplay = findViewById(R.id.textViewDisplay);

        String selectedGroupType = getIntent().getStringExtra("selectedGroupType");
        String selectedPackage = getIntent().getStringExtra("selectedPackage");
        boolean isDelhiChecked = getIntent().getBooleanExtra("isDelhiChecked", false);
        boolean isKokanChecked = getIntent().getBooleanExtra("isKokanChecked", false);
        boolean isNepalChecked = getIntent().getBooleanExtra("isNepalChecked", false);

        String displayText = "Group Type: " + selectedGroupType + "\n" +
                "Selected Package: " + selectedPackage + "\n" +
                "Delhi: " + (isDelhiChecked ? "Yes" : "No") + "\n" +
                "Kokan: " + (isKokanChecked ? "Yes" : "No") + "\n" +
                "Nepal: " + (isNepalChecked ? "Yes" : "No");

        textViewDisplay.setText(displayText);
    }
}
