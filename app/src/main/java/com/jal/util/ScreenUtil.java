package com.jal.util;

import android.content.Context;

/**
 * Created by SEELE on 2017/4/14.
 */

public class ScreenUtil {
    /**
     * 获得通知栏的高度
     * @return
     */
    public static int getStatusHeight(Context context){
        int resid = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if(resid > 0){
            return context.getResources().getDimensionPixelSize(resid);
        }
        return -1;
    }
}
