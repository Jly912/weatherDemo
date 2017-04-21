package com.jal.http;

import android.util.Log;

import com.google.gson.Gson;
import com.jal.bean.LoginInfo;
import com.jal.bean.StartInfo;
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

    public static void getWeatherInfo(String city, final OnDownListener listener) {
        OkGo.get(String.format(Api.JUHE_WEATHER, city))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        if (s != null) {
                            WeatherInfoBean weatherInfoBean = new Gson().fromJson(s, WeatherInfoBean.class);
                            listener.downSucc(weatherInfoBean);
                        } else {
                            listener.downFilded();
                        }
                    }
                });

    }

    public static void getStarInfo(String name, final OnDownListener listener) {
        OkGo.get(String.format(Api.STAR_INFO, name))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        if (s != null) {
                            StartInfo startInfo = new Gson().fromJson(s, StartInfo.class);
                            listener.downSucc(startInfo);
                        } else {
                            listener.downFilded();
                        }
                    }
                });
    }

    public static void getLogin(String name, String pwd, final OnDownListener listener) {

        String url=String.format(Api.LOGIN, name, pwd,"login");
        Log.d("print","params"+name+pwd+"url"+url);
        OkGo.get(url)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        if (s != null) {
                            LoginInfo loginInfo = new Gson().fromJson(s, LoginInfo.class);
                            listener.downSucc(loginInfo);
                        } else {
                            listener.downFilded();
                        }
                    }
                });

    }

}
