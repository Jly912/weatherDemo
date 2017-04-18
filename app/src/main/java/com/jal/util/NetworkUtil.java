package com.jal.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by SEELE on 2017/4/14.
 */

public class NetworkUtil {
    //检查是否联网
    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
        }
        return false;
    }

    //检查wifi是否连接
    public static boolean isWifiConnected(Context context) {
        if (context != null) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null) {
                if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                    return info.isAvailable();
                }
            }
        }
        return false;
    }

    //检查移动网络是否连接
    public static boolean isMobileDataConnected(Context context) {
        if (context != null) {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = manager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                    return true;
                }
            }
        }

        return false;
    }
}
