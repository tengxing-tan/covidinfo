package com.example.covidinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import Model.Covid19InfoModel;
import Model.Covid19InfoRecord;

public class Covid19InfoPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid19_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /**
            Read & display list of Covid-19 information
        */
        // initializing our all variables
        ArrayList<Covid19InfoModel> covid19InfoModelArrayList = new ArrayList<>();
        Covid19InfoRecord db = new Covid19InfoRecord(Covid19InfoPage.this);

        // get array
        covid19InfoModelArrayList = db.readCovid19Info();

        // passing array into adapter
        Covid19InfoAdapter adapter = new Covid19InfoAdapter(covid19InfoModelArrayList, Covid19InfoPage.this);
        RecyclerView rv = findViewById(R.id.rvCovid19Info);

        // setting layout manager for recycler view
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Covid19InfoPage.this, RecyclerView.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        rv.setAdapter(adapter);
    }
}