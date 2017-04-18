package com.jal.bean;

import android.os.CountDownTimer;
import android.widget.Button;

import com.jal.weatherdemo.R;


/**
 * Created by SEELE on 2017/4/14.
 */

public class TimerCount extends CountDownTimer {

    private Button btn;

    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public TimerCount(long millisInFuture, long countDownInterval, Button btn) {
        super(millisInFuture, countDownInterval);//参数依次为总时长,和计时的时间间隔
        this.btn=btn;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        //计时过程显示
        btn.setClickable(false);
        btn.setText(millisUntilFinished / 1000 + "秒");
    }

    @Override
    public void onFinish() {
        //计时完毕时触发
        btn.setText(R.string.get_code);
        btn.setClickable(true);
    }
}
