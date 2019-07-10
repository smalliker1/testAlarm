package com.example.atlant.budzik;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

public class Alarm extends BroadcastReceiver {



    @Override
    public void onReceive(Context context, Intent intent) {

        AlarmManager oldA = HelperClock.getA();
        PendingIntent oldPI = HelperClock.getP();

        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
        Vibrator v = (Vibrator) context.getSystemService(context.VIBRATOR_SERVICE);
        HelperClock.setRingtone(ringtone);
        HelperClock.setVibrate(v);
        Intent i = new Intent(context,alarmView.class);


            v.vibrate(10 * 1000);
            Toast.makeText(context, "Alarm! Wake up! Wake up!", Toast.LENGTH_LONG).show();
            if (alarmUri == null)
            {
                alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            }

            ringtone.play();
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);

        }


    }

