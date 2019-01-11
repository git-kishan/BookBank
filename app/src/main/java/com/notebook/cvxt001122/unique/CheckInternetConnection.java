package com.notebook.cvxt001122.unique;

import android.content.Context;
import android.net.ConnectivityManager;

import java.net.InetAddress;

import androidx.core.net.ConnectivityManagerCompat;

public class CheckInternetConnection {

    private Context context;
    public CheckInternetConnection(Context context){
        this.context=context;
    }

    public boolean isInternetAvailable() {
        ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo()!=null;
    }

}
