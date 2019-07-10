package com.example.atlant.budzik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class timeToSleep extends AppCompatActivity {

    int hour = 111;
    int minute = 111;
    Button cycle1, cycle2, cycle3, cycle4, cycle5, cycle6;
    int firstCycles, secondCycles, thirdCycles, fourhtCycles, fifsthCycles, sixthCycles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_to_sleep);

        cycle1 = findViewById(R.id.cycle1);
        cycle2 = findViewById(R.id.cycle2);
        cycle3 = findViewById(R.id.cycle3);
        cycle4 = findViewById(R.id.cycle4);
        cycle5 = findViewById(R.id.cycle5);
        cycle6 = findViewById(R.id.cycle6);

        setSleepNow();

        cycle1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               conversTime(firstCycles);
               MainActivity.getmInstanceActivity().buildAlarm(hour,minute);
            }
        });
        cycle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conversTime(secondCycles);
                MainActivity.getmInstanceActivity().buildAlarm(hour,minute);
            }
        });
        cycle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conversTime(thirdCycles);
                MainActivity.getmInstanceActivity().buildAlarm(hour,minute);
            }
        });
        cycle4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conversTime(fourhtCycles);
                MainActivity.getmInstanceActivity().buildAlarm(hour,minute);
            }
        });
        cycle5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conversTime(fifsthCycles);
                MainActivity.getmInstanceActivity().buildAlarm(hour,minute);
            }
        });
        cycle6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conversTime(sixthCycles);
                MainActivity.getmInstanceActivity().buildAlarm(hour,minute);
            }
        });
    }



    void makeButtonTime(int firstCycles,int secondCycles,int
            thirdCycles,int fourhtCycles,int fifsthCycles,int sixthCycles) {
        cycle1.setText(conversTimeToString(firstCycles));
        cycle2.setText(conversTimeToString(secondCycles));
        cycle3.setText(conversTimeToString(thirdCycles));
        cycle4.setText(conversTimeToString(fourhtCycles));
        cycle5.setText(conversTimeToString(fifsthCycles));
        cycle6.setText(conversTimeToString(sixthCycles));
    }

    String conversTimeToString(int time) {
        if (time > 86400) { time = time - 86400; }

        int a = time / 60;
        String hour = "" + (a / 60);
        String minutes = "" + (a % 60);

        if (hour.length() < 2) { hour = "0" + hour ; }
        if (minutes.equals("0"))  { minutes = "00"; }
        return hour + ":" + minutes;
    }
    void conversTime (int time) {
        if (time > 86400) { time = time - 86400; }

        int a = time / 60;
         hour = (a / 60);
         minute = (a % 60);

    }
    void setSleepNow(){
        final Calendar cTime  = Calendar.getInstance();
        int mHour = cTime.get(Calendar.HOUR_OF_DAY);
        int mMinute = cTime.get(Calendar.MINUTE);
        // current time in seconds
        int currentTime = ((mHour * 60) + mMinute) * 60;

        int timeToFallAsleep = currentTime + 840; // 00:14
        timeToSleep(timeToFallAsleep);
    }


    void timeToSleep(int timeToCalculate) {
         firstCycles = timeToCalculate + 5_400; // 1:30
         secondCycles = timeToCalculate + 10_800; // 3:00
         thirdCycles = timeToCalculate + 16_200; // 4:30
         fourhtCycles = timeToCalculate +  21_600; //6:00
         fifsthCycles = timeToCalculate +  27_000; // 7:30
         sixthCycles = timeToCalculate +  32_400; // 9:00
        makeButtonTime(firstCycles,secondCycles,thirdCycles,fourhtCycles,fifsthCycles,sixthCycles);
    }
}
