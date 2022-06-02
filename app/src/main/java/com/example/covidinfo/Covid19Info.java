package com.example.covidinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Covid19Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid19_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}