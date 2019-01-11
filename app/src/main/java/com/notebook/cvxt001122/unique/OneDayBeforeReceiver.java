package com.notebook.cvxt001122.unique;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class OneDayBeforeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())) {
            Log.i("TAG", "receiver starts");
            String bookName = intent.getStringExtra("bookname");
            Log.i("TAG","bookname :- "+bookName);
            Intent intent1 = new Intent(context, HandleNotificationService.class);
            intent1.putExtra("bookname", bookName);
            context.startService(intent1);
        }
        else {
            Log.i("TAG", "receiver starts");
            String bookName = intent.getStringExtra("bookname");
            Log.i("TAG","bookname :- "+bookName);
            Intent intent1 = new Intent(context, HandleNotificationService.class);
            intent1.putExtra("bookname", bookName);
            context.startService(intent1);
        }
    }
}
