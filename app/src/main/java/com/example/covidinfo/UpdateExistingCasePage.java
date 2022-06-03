package com.example.covidinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class UpdateExistingCasePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_existing_case_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
