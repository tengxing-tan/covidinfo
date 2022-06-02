package com.example.covidinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ManageCovid19InfoPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_covid19_info_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}