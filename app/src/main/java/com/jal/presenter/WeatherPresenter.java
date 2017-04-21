package com.jal.presenter;

import android.content.Context;

import com.jal.bean.WeatherInfoBean;
import com.jal.contract.WeatherContract;
import com.jal.http.Http;
import com.jal.interfaces.OnDownListener;

/**
 * Created by SEELE on 2017/4/19.
 */

public class WeatherPresenter implements WeatherContract.Presenter {

    private WeatherContract.View view;
    private Context context;

    private String city = "深圳";
    private WeatherInfoBean data;

    public WeatherPresenter(Context context, WeatherContract.View view) {
        this.context = context;
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void loadPost() {
        view.showLoading();
        Http.getWeatherInfo(city, new OnDownListener() {
            @Override
            public void downSucc(Object object) {
                if (object != null) {
                    data = (WeatherInfoBean) object;
                    view.showResult(data);
                }
                view.stopLoading();
            }

            @Override
            public void downFilded() {
                view.showError();
                view.stopLoading();
                return;
            }
        });

    }

    @Override
    public void refresh() {
        loadPost();
    }

    @Override
    public void change(boolean showStyle) {
        if (showStyle) {

            view.showChart(data);
        } else {
            view.showLine(data);
        }
    }

    @Override
    public void loadPost(String city) {
        this.city=city;
        Http.getWeatherInfo(city, new OnDownListener() {
            @Override
            public void downSucc(Object object) {
                if (object != null) {
                    data = (WeatherInfoBean) object;
                    if(data.getResult()!=null){
                        view.showResult(data);
                    }else {
                        view.showErrorCity();
                    }

                }
                view.stopLoading();
            }

            @Override
            public void downFilded() {
                view.showError();
                view.stopLoading();
                return;
            }
        });
    }


}
