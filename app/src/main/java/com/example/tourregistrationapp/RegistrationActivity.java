package com.example.tourregistrationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private Spinner spinnerGroupType;
    private RadioGroup radioGroupPackages;
    private CheckBox checkBoxDelhi, checkBoxKokan, checkBoxNepal;
    private Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        spinnerGroupType = findViewById(R.id.spinnerGroupType);
        radioGroupPackages = findViewById(R.id.radioGroupPackages);
        checkBoxDelhi = findViewById(R.id.checkBoxDelhi);
        checkBoxKokan = findViewById(R.id.checkBoxKokan);
        checkBoxNepal = findViewById(R.id.checkBoxNepal);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Populate the spinner with group type
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.group_type_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGroupType.setAdapter(adapter);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedGroupType = spinnerGroupType.getSelectedItem().toString();
                int selectedPackageId = radioGroupPackages.getCheckedRadioButtonId();
                RadioButton selectedPackage = findViewById(selectedPackageId);
                boolean isDelhiChecked = checkBoxDelhi.isChecked();
                boolean isKokanChecked = checkBoxKokan.isChecked();
                boolean isNepalChecked = checkBoxNepal.isChecked();

                Intent intent = new Intent(RegistrationActivity.this, DisplayActivity.class);
                intent.putExtra("selectedGroupType", selectedGroupType);
                intent.putExtra("selectedPackage", selectedPackage.getText().toString());
                intent.putExtra("isDelhiChecked", isDelhiChecked);
                intent.putExtra("isKokanChecked", isKokanChecked);
                intent.putExtra("isNepalChecked", isNepalChecked);
                startActivity(intent);
            }
        });
    }
}
