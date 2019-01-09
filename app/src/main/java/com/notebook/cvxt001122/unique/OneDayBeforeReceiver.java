package com.notebook.cvxt001122.unique;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class OneDayBeforeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            String bookName = intent.getStringExtra("bookname");
            Intent intent1 = new Intent(context, HandleNotificationService.class);
            intent1.putExtra("bookname", bookName);
            context.startService(intent1);
        }
    }
}
