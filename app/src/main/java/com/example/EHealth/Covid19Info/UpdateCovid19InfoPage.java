package com.example.EHealth.Covid19Info;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.EHealth.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import Model.Covid19InfoRecord;

public class UpdateCovid19InfoPage extends AppCompatActivity {

    // variables for edit text, button, strings and dbhandler
    private EditText inputTitle, inputContent;
    private Button updateButton, deleteButton;
    private Covid19InfoRecord db;
    int id;
    String title, date, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_covid19_info_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // initializing variables
        inputTitle = findViewById(R.id.inputTitle);
        inputContent = findViewById(R.id.inputContent);
        updateButton = findViewById(R.id.updateButton);
        deleteButton = findViewById(R.id.deleteButton);

        // dbhandler
        db = new Covid19InfoRecord(UpdateCovid19InfoPage.this);

        // receive data which passed by adapter
        id = getIntent().getIntExtra("id", 999);
        title = getIntent().getStringExtra("title");
        content = getIntent().getStringExtra("content");

        // display data
        inputTitle.setText(title);
        inputContent.setText(content);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // get date today
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Calendar obj = Calendar.getInstance();
                String date = formatter.format(obj.getTime());
                  
                // inside this method we are calling an update course 
                // method and passing all our edit text values.
                db.updateCovidInfo(id, inputTitle.getText().toString(), date, inputContent.getText().toString());
                  
                // launching our main activity.
                Intent i = new Intent(UpdateCovid19InfoPage.this, ManageCovid19InfoPage.class);
                startActivity(i);
            }
        });
        
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // inside this method we are calling an update course 
                // method and passing all our edit text values.
                db.deleteCovidInfo(id);
                  
                // launching our main activity.
                Intent i = new Intent(UpdateCovid19InfoPage.this, ManageCovid19InfoPage.class);
                startActivity(i);
            }
        });
    }
}