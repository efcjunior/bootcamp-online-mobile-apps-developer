package com.codingworld.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if(intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())){
            Toast.makeText(context, "Test broadcast 1", Toast.LENGTH_SHORT).show();
        }else if (intent.ACTION_BATTERY_LOW.equals(intent.getAction())){
            Toast.makeText(context, "Test broadcast 2", Toast.LENGTH_SHORT).show();
        }
    }
}
