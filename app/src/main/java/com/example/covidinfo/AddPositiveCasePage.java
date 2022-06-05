package com.example.covidinfo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import Model.Covid19CaseModel;

public class AddPositiveCasePage extends AppCompatActivity {

    EditText inputIcNumber, inputCaseType, inputDate;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_positive_case_page);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        inputIcNumber = findViewById(R.id.inputIcNumber);
        inputCaseType = findViewById(R.id.inputCaseType);
        inputDate = findViewById(R.id.inputDate);
        // inputName = findViewById(R.id.inputName);
        // inputGender = findViewById(R.id.inputGender);
        // inputPhoneNum = findViewById(R.id.inputPhoneNum);
        // inputAddress = findViewById(R.id.inputAddress);

        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(view -> {
            Covid19CaseModel myDB = new Covid19CaseModel(AddPositiveCasePage.this);
            myDB.addPositiveCase(
                    inputIcNumber.getText().toString().trim(),
                    inputCaseType.getText().toString().trim(),
                    inputDate.getText().toString().trim()
            );
        });
    }

}
