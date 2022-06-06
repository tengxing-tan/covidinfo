package com.example.covidinfo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

import Model.Covid19InfoRecord;

public class PublishCovid19InfoPage extends AppCompatActivity {

    EditText inputTitle, inputContent;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_covid19_info);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        inputTitle = findViewById(R.id.inputTitle);
        inputContent = findViewById(R.id.inputContent);
        // get date today
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar obj = Calendar.getInstance();
        String date = formatter.format(obj.getTime());

        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(view -> {  
            Covid19InfoRecord db = new Covid19InfoRecord(PublishCovid19InfoPage.this);
            db.publish(
                inputTitle.getText().toString().trim(),
                date,
                inputContent.getText().toString().trim()
            );
        });
    }
}
