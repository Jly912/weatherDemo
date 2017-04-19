package com.jal.util;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jal.app.AppContext;
import com.jal.bean.WeatherBean;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SEELE on 2017/4/19.
 */

public class ReadFromAssets {

    private static Context context=AppContext.getContext();
    private static Gson gson = new Gson();
    private static Map<String, WeatherBean> weatherBeanMap = new HashMap<>();

    public static Map getMap() {
        init();
        Log.d("print","readfrom"+weatherBeanMap);
        return weatherBeanMap;
    }

    private static void init() {
        List<WeatherBean> data = gson.fromJson(readFromAssets(), new TypeToken<List<WeatherBean>>() {
        }.getType());
        Log.d("print","init"+data);
        for (WeatherBean weatherBean : data) {
            weatherBeanMap.put(weatherBean.getCname(), weatherBean);
        }
        Log.d("print","init---"+weatherBeanMap);

    }

    private static String readFromAssets() {
        InputStream in = null;
        try {
            in = context.getAssets().open("weather1.json");
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            return new String(buffer, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
