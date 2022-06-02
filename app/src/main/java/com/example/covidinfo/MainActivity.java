package com.example.covidinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button goToCovidInfo;
    Button goToCovidNews;
    Button goToManageCovidInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToCovidInfo = (Button)findViewById(R.id.button);
        goToCovidInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Covid19Info.class);
                startActivity(intent);
            }
        });

        goToCovidNews = (Button) findViewById(R.id.buttonGoToCovidNews);
        goToCovidNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Covid19Information.class);
                startActivity(intent);
            }
        });

        goToManageCovidInfo = (Button) findViewById(R.id.buttonGoToManageCovidInfo);
        goToManageCovidInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ManageCovid19InfoPage.class);
                startActivity(intent);
            }
        });
    }
}