package com.example.EHealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.EHealth.Covid19Info.ManageCovid19InfoPage;

public class MainStaff extends AppCompatActivity {

    Button goToManageCovidInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_staff);

        /**
         * Manage Covid info
         */
        goToManageCovidInfo = (Button) findViewById(R.id.buttonGoToManageCovidInfo);
        goToManageCovidInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainStaff.this, ManageCovid19InfoPage.class);
                startActivity(intent);
            }
        });
    }
}