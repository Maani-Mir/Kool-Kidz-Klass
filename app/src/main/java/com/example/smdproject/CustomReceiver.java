package com.example.smdproject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    private static final String ACTION_CUSTOM_BROADCAST = BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");

        String intentAction = intent.getAction();

        if(intentAction != null) {
            String toastMessage = "unknown intent messsage/action";
            switch (intentAction) {
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power Connected";
                    break;

                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Power Disconnected";
                    break;

                case Intent.ACTION_HEADSET_PLUG:
                    int state = intent.getIntExtra("state", -1);

                    switch(state) {
                        case 0:
                            toastMessage = "Headset is not plugged";
                        case 1:
                            toastMessage = "Headset is plugged";
                        default:
                            toastMessage = "No idea what the state it is in";
                    }

                case ACTION_CUSTOM_BROADCAST:
                    toastMessage = "You're Special!";
                    break;
            }

            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();

        }

    }

}
