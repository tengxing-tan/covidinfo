package com.example.EHealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.EHealth.Covid19Info.Covid19InfoPage;
import com.example.EHealth.Covid19Info.ManageCovid19InfoPage;

public class MainActivity extends AppCompatActivity {

    Button goToCovidInfo;
    Button goToManageCovidInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goToCovidInfo = (Button)findViewById(R.id.buttonGotoCovidInfo);
        goToCovidInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Covid19InfoPage.class);
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