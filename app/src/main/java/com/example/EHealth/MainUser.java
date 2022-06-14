package com.example.EHealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.EHealth.Covid19Info.Covid19InfoPage;
import com.example.EHealth.Covid19Info.ManageCovid19InfoPage;

public class MainUser extends AppCompatActivity {

    Button goToCovidInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_user);

        /**
         * View Covid info
         */
        goToCovidInfo = (Button)findViewById(R.id.buttonGoToCovidInfo);
        goToCovidInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainUser.this, Covid19InfoPage.class);
                startActivity(intent);
            }
        });

    }
}