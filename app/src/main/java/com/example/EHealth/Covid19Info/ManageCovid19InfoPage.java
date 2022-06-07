package com.example.EHealth.Covid19Info;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.EHealth.R;

import java.util.ArrayList;

import Model.Covid19InfoModel;
import Model.Covid19InfoRecord;

public class ManageCovid19InfoPage extends AppCompatActivity {

    Button goToAddPositiveCase;
    Button goToUpdateExistingCase;
    Button goToPublishCovid19Info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_covid19_info_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        goToAddPositiveCase = (Button) findViewById(R.id.buttonAddPositiveCase);
        goToAddPositiveCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManageCovid19InfoPage.this, AddPositiveCasePage.class);
                startActivity(intent);
            }
        });

        goToUpdateExistingCase = (Button) findViewById(R.id.buttonUpdateExtistingCase);
        goToUpdateExistingCase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManageCovid19InfoPage.this, Covid19CasesListPage.class);
                startActivity(intent);
            }
        });

        goToPublishCovid19Info = (Button) findViewById(R.id.buttonPublishCovid19Info);
        goToPublishCovid19Info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ManageCovid19InfoPage.this, PublishCovid19InfoPage.class);
                startActivity(intent);
            }
        });

        /**
            Read & display list of Covid-19 information
        */
        // initializing our all variables
        ArrayList<Covid19InfoModel> covid19InfoModelArrayList = new ArrayList<>();
        Covid19InfoRecord db = new Covid19InfoRecord(ManageCovid19InfoPage.this);

        // get array
        covid19InfoModelArrayList = db.readCovid19Info();

        // passing array into adapter
        UpdateCovid19InfoAdapter adapter = new UpdateCovid19InfoAdapter(covid19InfoModelArrayList, ManageCovid19InfoPage.this);
        RecyclerView rv = findViewById(R.id.rvCovid19Info);

        // setting layout manager for recycler view
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ManageCovid19InfoPage.this, RecyclerView.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);

        // setting our adapter to recycler view.
        rv.setAdapter(adapter);
    }

}
