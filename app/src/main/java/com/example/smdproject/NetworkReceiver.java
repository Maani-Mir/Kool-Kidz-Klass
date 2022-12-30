package com.example.smdproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NetworkReceiver extends BroadcastReceiver {

    public static String status;

    //@SuppressLint("UnsafeProtectedBroadcastReceiver")
    @Override
    public void onReceive(Context context, Intent intent) {
        //status = intent.getAction();
        status = NetworkState.getConnectivityStatusString(context);
        //Toast.makeText(context, status, Toast.LENGTH_LONG).show();
        if(status == "Wifi enabled"){
            //your code when wifi enable
        }
        else if(status =="Mobile data enabled"){
            //your code when TYPE_MOBILE network enable
        }
        else if(status =="Not connected to Internet"){
            //your code when no network connected
        }
    }

}
