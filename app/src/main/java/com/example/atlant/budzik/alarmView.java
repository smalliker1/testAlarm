package com.example.atlant.budzik;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.Ringtone;
import android.os.Build;
import android.os.Vibrator;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class alarmView extends AppCompatActivity {
    Button stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_view);
        stop = findViewById(R.id.stop);

        stop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Alarm.class);

                Ringtone ringtone = HelperClock.getRingtone();
                Vibrator vibratate =  HelperClock.getVibrate();
                ringtone.stop();
                vibratate.cancel();
                MainActivity.getmInstanceActivity().setAlarmText("ALARM OFF");
                HelperClock.getA().cancel(HelperClock.getP());
                finish();

            }
        });
    }
}
