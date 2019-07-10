package com.example.atlant.budzik;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    public static String EXTRA_TIME = "com.example.Budzik.EXTRA_TIME";
    public static String ALARM_MANAGER = "com.example.Budzik.ALARM_MANAGER";
    public static String STOP_MANAGER = "com.example.Budzik.STOP_MANAGER";
    private Button sleepAt;
    private Button sleepNow, cancel;
    private Button calculate;
    private Button test;
    public TextView infoTime;
    private int  mHour,  mMinute;

    PendingIntent pendingIntent;
    Intent i;
    AlarmManager alarmManager;
    final Calendar c = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Hello");

        test = findViewById(R.id.test);
        infoTime = findViewById(R.id.infoTime);
        cancel = findViewById(R.id.cancel);

//      Clok
        sleepAt = findViewById(R.id.setTime);
        sleepAt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
        // new Activity
        calculate =  findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
        sleepNow =  findViewById(R.id.sleepNow);
        sleepNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),timeToSleep.class);
                startActivity(intent);
            }
        });
    }

    private void openActivity() {
        Intent intent = new Intent(getApplicationContext(),tab1.class);
        intent.putExtra(EXTRA_TIME,packageTime());

                startActivity(intent);
    }
    private int packageTime () {
        int a = ((mHour * 60) + mMinute);

        return a * 60;
    }



    void openDialog() {


        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);


        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                mHour = hourOfDay;
                mMinute = minute;
                buildAlarm(mHour,mMinute);
            }
            },mHour,mMinute,true);
                timePickerDialog.show();


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarmText("ALARM OFF");
                alarmManager.cancel(pendingIntent);
                Toast.makeText(MainActivity.this, "ALARM OFF", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private static MainActivity mInstanceActivity;
    public static MainActivity getmInstanceActivity() {
        return mInstanceActivity;
    }

    public  void setAlarmText(String text) {
        infoTime.setText("text");
    }

    public void buildAlarm(int hour,int minute) {
        if(minute == 111 & hour == 111){
            Toast.makeText(getApplicationContext(), "(Exaption)Alarm isn't buld ", Toast.LENGTH_LONG).show();
        } else {
            i = new Intent(MainActivity.this, Alarm.class);
            alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, i, 0);
            c.set(Calendar.HOUR_OF_DAY, hour);
            c.set(Calendar.MINUTE, minute);
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), 10000, pendingIntent);
            HelperClock.setP(pendingIntent);
            HelperClock.setA(alarmManager);

            Toast.makeText(getApplicationContext(), "Установлен ", Toast.LENGTH_LONG).show();
            infoTime.setText("ALARM ring on " + mHour + ":" + mMinute);
        }
    }

}
