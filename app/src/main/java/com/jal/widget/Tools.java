package com.jal.widget;

import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;

/**
 * Created by SEELE on 2017/4/17.
 */

public class Tools {

    public static Animation shakeAnimation(int times){
        Animation animation=new TranslateAnimation(0,6,0,6);
        animation.setInterpolator(new CycleInterpolator(times));
        animation.setDuration(1000);
        return animation;
    }
}
