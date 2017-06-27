package com.example.emre.androidnotificationonbackground;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by emre on 23.06.2017.
 */

public class MyService extends Service {
    int x = 100000;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new CountDownTimer(x, 15000) {

            public void onTick(long millisUntilFinished) {

                notifBuild();

            }

            public void onFinish() {

            }
        }.start();

        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {
        // STOP YOUR TASKS
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void notifBuild(){

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.cross)
                        .setContentTitle("My notification")
                        .setContentText("Hello World!");

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, mBuilder.build());

    }


}