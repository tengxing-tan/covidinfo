package com.example.covidinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                Intent intent = new Intent(ManageCovid19InfoPage.this, UpdateExistingCasePage.class);
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
    }

}
