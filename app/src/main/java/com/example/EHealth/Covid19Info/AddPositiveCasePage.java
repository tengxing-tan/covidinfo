package com.example.EHealth.Covid19Info;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.EHealth.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

import Model.Covid19CaseRecord;

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

        // get date today
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar obj = Calendar.getInstance();
        String today = formatter.format(obj.getTime());

        inputDate.setText(today);

        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(view -> {
            Covid19CaseRecord myDB = new Covid19CaseRecord(AddPositiveCasePage.this);
            myDB.addPositiveCase(
                inputIcNumber.getText().toString().trim(),
                inputDate.getText().toString().trim(),
                inputCaseType.getText().toString().trim()
            );

            // launching our main activity.
                Intent i = new Intent(AddPositiveCasePage.this, ManageCovid19InfoPage.class);
                startActivity(i);
        });
    }

}
