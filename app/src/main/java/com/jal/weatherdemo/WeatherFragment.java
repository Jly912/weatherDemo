package com.jal.weatherdemo;

import com.jal.base.BaseFragment;

/**
 * Created by SEELE on 2017/4/17.
 */

public class WeatherFragment extends BaseFragment {


    public WeatherFragment() {
    }

    public static WeatherFragment getInstance() {
        return new WeatherFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_weather;
    }


}
