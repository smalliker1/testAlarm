package com.example.atlant.budzik;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class tab1 extends AppCompatActivity {
    int time;
    int hour = 111;
    int minute = 111;
    Button cycle1, cycle2, cycle3, cycle4;
    int firstCycles, secondCycles, thirdCycles, fourhtCycles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab1);

        cycle1 = findViewById(R.id.cycle1);
        cycle2 = findViewById(R.id.cycle2);
        cycle3 = findViewById(R.id.cycle3);
        cycle4 = findViewById(R.id.cycle4);

    Intent intent = getIntent();
    time = intent.getIntExtra(MainActivity.EXTRA_TIME, 0);

    timeWakeAp(time);

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
    }
    void makeButtonTime(int firstCycles,int secondCycles,int thirdCycles,int fourhtCycles) {
    cycle1.setText(conversTimeToString(firstCycles));
    cycle2.setText(conversTimeToString(secondCycles));
    cycle3.setText(conversTimeToString(thirdCycles));
    cycle4.setText(conversTimeToString(fourhtCycles));
    }

    void timeWakeAp(int timeToCalculate ) {

        int firstCycles = timeToCalculate - 16_200; // 4:30
        int secondCycles = timeToCalculate -  21_600; //6:00
        int thirdCycles = timeToCalculate -  27_000; // 7:30
        int fourhtCycles = timeToCalculate -  32_400; // 9:00
    makeButtonTime(firstCycles,secondCycles,thirdCycles,fourhtCycles);
    }
    String conversTimeToString(int time) {
        if (time < 0) {
            time = time + 86400;
        }
        int a = time / 60;
        String Hour = "" + (a / 60);
        String Minutes = "" + (a % 60);
        if (Hour.length() < 2) { Hour = "0" + Hour ; }
        if (Minutes.equals("0")) { Minutes = "00"; }
        return Hour + ":" + Minutes;
    }
    void conversTime (int time) {
        if (time > 86400) { time = time - 86400; }

        int a = time / 60;
        hour = (a / 60);
        minute = (a % 60);

    }

}


