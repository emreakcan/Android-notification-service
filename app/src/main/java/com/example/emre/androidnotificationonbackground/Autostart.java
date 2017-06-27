package com.example.emre.androidnotificationonbackground;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by emre on 27.06.2017.
 */

public class Autostart extends BroadcastReceiver {

    public void onReceive(Context context, Intent arg1) {
        Intent intent = new Intent(context,MyService.class);
        context.startService(intent);
    }

}