package com.jal.presenter;

import android.content.Context;

import com.jal.bean.WeatherInfoBean;
import com.jal.contract.LifeContract;
import com.jal.http.Http;
import com.jal.interfaces.OnDownListener;

/**
 * Created by SEELE on 2017/4/17.
 */

public class LifePresenter implements LifeContract.Presenter {

    private LifeContract.View view;
    private Context context;
    private String city;

    public LifePresenter(Context context, LifeContract.View view, String city) {
        this.context = context;
        this.view = view;
        this.city = city;
        this.view.setPresenter(this);
    }

    @Override
    public void loadDatas() {
        view.showLoading();
        Http.getWeatherInfo(city, new OnDownListener() {
            @Override
            public void downSucc(Object object) {
                if (object != null) {
                    WeatherInfoBean weatherInfoBean = (WeatherInfoBean) object;
                    view.showResults(weatherInfoBean);
                    view.stopLoading();
                }
            }

            @Override
            public void downFilded() {
                view.showError();
                view.stopLoading();
            }
        });
    }

    @Override
    public void refresh() {
        loadDatas();
    }
}
