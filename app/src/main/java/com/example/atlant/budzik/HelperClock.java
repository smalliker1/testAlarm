package com.example.atlant.budzik;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Vibrator;

public class HelperClock {
    private static PendingIntent p;
    private static AlarmManager a;
    private static Boolean s;
    private static Ringtone ringtone;
    private static Vibrator vibrate;


    public static PendingIntent getP() {
        return p;
    }

    public static void setP(PendingIntent p) {
        HelperClock.p = p;
    }

    public static AlarmManager getA() {
        return a;
    }

    public static void setA(AlarmManager a) {
        HelperClock.a = a;
    }

    public static Boolean getS() {
        return s;
    }

    public static void setS(Boolean s) {
        HelperClock.s = s;
    }

    public static Ringtone getRingtone() {
        return ringtone;
    }

    public static void setRingtone(Ringtone ringtone) {
        HelperClock.ringtone = ringtone;
    }

    public static Vibrator getVibrate() {
        return vibrate;
    }

    public static void setVibrate(Vibrator vibrate) {
        HelperClock.vibrate = vibrate;
    }
}