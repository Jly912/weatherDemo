package com.jal.http;

import com.google.gson.Gson;
import com.jal.bean.WeatherInfoBean;
import com.jal.interfaces.OnDownListener;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by SEELE on 2017/4/17.
 */

public class Http {

    public static void getWeatherInfo(String city, final OnDownListener listener){
        OkGo.get(String.format(Api.JUHE_WEATHER,city))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        if(s!=null){
                            WeatherInfoBean weatherInfoBean = new Gson().fromJson(s, WeatherInfoBean.class);
                            listener.downSucc(weatherInfoBean);
                        }else {
                            listener.downFilded();
                        }
                    }
                });

    }

}
