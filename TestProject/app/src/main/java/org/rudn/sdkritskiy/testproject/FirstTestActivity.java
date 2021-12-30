package org.rudn.sdkritskiy.testproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class FirstTestActivity extends AppCompatActivity{

    TextView welcometxt;
    TextView timetxt;
    Button welcomebtn;
    Button timebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_test);
        if(savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction().add(R.id.mainActivity, TestFragment.class, null).commit();
        }

        welcometxt = findViewById(R.id.welcometxt);
        timetxt = findViewById(R.id.timetxt);

        welcomebtn = findViewById(R.id.welcomebtn);
        timebtn = findViewById(R.id.timebtn);

        welcomebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                welcometxt.setText("Why did you do that?");
            }
        });

        timebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowTime();
            }
        });
    }

    public void ShowTime()
    {
        Calendar calendar = Calendar.getInstance();
        DateFormat currentTimeFormat = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
        timetxt.setText("Current time: " + currentTimeFormat.format(calendar.getTime()));
    }
}