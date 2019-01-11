package com.notebook.cvxt001122.unique;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class OnSubmitDayReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if("android.intent.action.BOOT_COMPLETED".equals(intent.getAction())){
            String bookName = intent.getStringExtra("bookname");
            Intent intent1 = new Intent(context, HandleNotificationService.class);
            intent1.putExtra("bookname", bookName);
            context.startService(intent1);
        }
        else {
            String bookName = intent.getStringExtra("bookname");
            Intent intent1 = new Intent(context, HandleNotificationService.class);
            intent1.putExtra("bookname", bookName);
            context.startService(intent1);
        }
    }
}