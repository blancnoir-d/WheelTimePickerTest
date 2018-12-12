package com.example.saeha.timepickertest;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Calendar;

import antistatic.spinnerwheel.AbstractWheel;
import antistatic.spinnerwheel.adapters.ArrayWheelAdapter;
import antistatic.spinnerwheel.adapters.NumericWheelAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView ivSet, ivCancel;
    public static String choosenTime = "";
    private AbstractWheel hours, mins, ampm;

    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeWidgets();
    }


    private void initializeWidgets()
    {

        hours = (AbstractWheel) findViewById(R.id.hour);
        NumericWheelAdapter hourAdapter = new NumericWheelAdapter(this, 0, 12);
        hourAdapter.setTextColor(Color.parseColor("#4c4c4c"));
        hours.setViewAdapter(hourAdapter);
        hours.setCyclic(false);
        mins = (AbstractWheel)findViewById(R.id.mins);
        mins.setViewAdapter(new NumericWheelAdapter(this, 0, 59, "%02d"));
        mins.setCyclic(false);
        ampm = (AbstractWheel)findViewById(R.id.amorpm);
        String[] data = new String[] { "AM", "PM" };
        ampm.setViewAdapter(new ArrayWheelAdapter<String>(this, data));
        ampm.setCyclic(false);

        next = (Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,WheelTest.class);
                startActivity(intent);
            }
        });

        initializeTimeWheel();

    }

    private void initializeTimeWheel()
    {
        Calendar c = Calendar.getInstance();
        int curHours = c.get(Calendar.HOUR);
        int curMinutes = c.get(Calendar.MINUTE);
        hours.setCurrentItem(curHours);
        mins.setCurrentItem(curMinutes);
        ampm.setCurrentItem(c.get(Calendar.AM_PM));
    }


    @Override
    public void onClick(View v) {
//        switch (v.getId())
//        {
//            case R.id.imageView2:
//                break;
//            case R.id.imageView1:
//                String am_or_pm = "";
//                int hour = hours.getCurrentItem(); int min = mins.getCurrentItem();
//                int AM_OR_PM = ampm.getCurrentItem();
//                switch(AM_OR_PM)
//                {
//                    case 0: am_or_pm = "AM"; break;
//                    case 1: am_or_pm = "PM"; break;
//                }
//                String hours, mins;
//                if(hour < 10)
//                    hours = "0"+hour;
//                else
//                    hours = String.valueOf(hour);
//                if(min < 10)
//                    mins = "0"+min;
//                else
//                    mins = String.valueOf(min);
//                choosenTime = hours+":"+mins+" "+am_or_pm;
//                break;
//        }
    }



}
