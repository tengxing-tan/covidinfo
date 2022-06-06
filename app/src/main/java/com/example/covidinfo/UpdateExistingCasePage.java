package com.example.covidinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import Model.Covid19CaseRecord;

public class UpdateExistingCasePage extends AppCompatActivity {

    // variables for edit text, button, strings and dbhandler
    private EditText inputIcNumber, inputDate, inputCaseType;
    private Button updateButton, closeCaseButton;
    private Covid19CaseRecord db;
    int id;
    String icNumber, activeDate, caseType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_existing_case_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // initializing variables
        inputIcNumber = findViewById(R.id.inputIcNumber);
        inputDate = findViewById(R.id.inputDate);
        inputCaseType = findViewById(R.id.inputCaseType);
        updateButton = findViewById(R.id.updateButton);
        closeCaseButton = findViewById(R.id.closeCaseButton);

        // dbhandler
        db = new Covid19CaseRecord(UpdateExistingCasePage.this);

        // receive data which passed by adapter
        id = getIntent().getIntExtra("id", 999);
        icNumber = getIntent().getStringExtra("patientID");
        activeDate = getIntent().getStringExtra("activeDate");
        caseType = getIntent().getStringExtra("caseType");

        // display data
        inputIcNumber.setText(icNumber);
        inputDate.setText(activeDate);
        inputCaseType.setText(caseType);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inside this method we are calling an update course 
                // method and passing all our edit text values.
                db.updateExistingCase(id, inputIcNumber.getText().toString(), inputDate.getText().toString(), inputCaseType.getText().toString());
                  
                // launching our main activity.
                Intent i = new Intent(UpdateExistingCasePage.this, Covid19CasesListPage.class);
                startActivity(i);
            }
        });

        closeCaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // get date today
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Calendar obj = Calendar.getInstance();
                String today = formatter.format(obj.getTime());

                // inside this method we are calling an update course
                // method and passing all our edit text values.
                db.closeCase(id, today);

                // launching our main activity.
                Intent i = new Intent(UpdateExistingCasePage.this, Covid19CasesListPage.class);
                startActivity(i);
            }
        });

    }
}
