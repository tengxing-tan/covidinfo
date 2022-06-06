package com.example.covidinfo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import Model.Covid19CaseModel;
import Model.Covid19CaseRecord;
import Model.UpdateCovid19CaseAdapter;

public class Covid19CasesListPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid19_cases_list_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /**
         Read & display list of Covid-19 Cases
         */
        // initializing our all variables
        ArrayList<Covid19CaseModel> covid19CaseModelArrayList = new ArrayList<>();
        Covid19CaseRecord db = new Covid19CaseRecord(Covid19CasesListPage.this);

        // get array
        covid19CaseModelArrayList = db.readCovid19Case();

        // passing array into adapter
        UpdateCovid19CaseAdapter adapter = new UpdateCovid19CaseAdapter (covid19CaseModelArrayList, Covid19CasesListPage.this);
        RecyclerView rv = findViewById(R.id.rvCovid19Case);

        // setting layout manager for recycler view
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Covid19CasesListPage.this, RecyclerView.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        rv.setAdapter(adapter);
    }
}