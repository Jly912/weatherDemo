package com.jal.weatherdemo;

import com.jal.bean.WeatherInfoBean;

import java.util.List;

import static com.jal.weatherdemo.WeatherFragment.TimeStamp2Date;

/**
 * Created by SEELE on 2017/4/19.
 */

public class WeatherUtil {
    public static String getShareMessage(WeatherInfoBean weather) {

        WeatherInfoBean.ResultBean.DataBean.RealtimeBean realtime = weather.getResult().getData().getRealtime();
        String city_name = realtime.getCity_name();
        String weatherInfo = realtime.getWeather().getInfo();
        String direct = realtime.getWind().getDirect();
        String temperature = realtime.getWeather().getTemperature();

        String pm25 = weather.getResult().getData().getPm25().getPm25().getPm25();
        String quality = weather.getResult().getData().getPm25().getPm25().getQuality();

        int dataUptime = weather.getResult().getData().getRealtime().getDataUptime();
        //时间戳转化为Sting或Date
        String s = TimeStamp2Date(dataUptime + "", "yyyy-MM-dd HH:mm");

        WeatherInfoBean.ResultBean.DataBean.WeatherBeanX weatherBeanX = weather.getResult().getData().getWeather().get(0);
        int dayT = Integer.valueOf(weatherBeanX.getInfo().getDay().get(2));
        int nightT = Integer.valueOf(weatherBeanX.getInfo().getNight().get(2));
        String max="";
        String min="";
        if(dayT>nightT){
            max=max+dayT;
            min=min+nightT;
        }else {
            min=min+dayT;
            max=max+nightT;
        }



        List<String> day = weather.getResult().getData().getWeather().get(0).getInfo().getDay();
        String dir = day.get(3);

        WeatherInfoBean.ResultBean.DataBean.WeatherBeanX tommorrow = weather.getResult().getData().getWeather().get(1);
        List<String> day1 = tommorrow.getInfo().getDay();
        List<String> night = tommorrow.getInfo().getNight();
        String dir1 = day1.get(3);
        String src = night.get(3);


        String tTemp = day1.get(2);
        String tNight = night.get(2);
        String max1="";
        String min2="";
        if(Integer.valueOf(tTemp)>Integer.valueOf(tNight)){
            max1=tTemp;
            min2=tNight;
        }else {
            min2=tTemp;
            max1=tNight;
        }

        StringBuffer message = new StringBuffer();
        message.append(city_name);
        message.append("天气：");
        message.append("\r\n");
        message.append(s);
        message.append(" 发布：");
        message.append("\r\n");
        message.append(weatherInfo);
        message.append("，");
        message.append(temperature + "℃");
        message.append("。");
        message.append("\r\n");
        message.append("PM2.5：").append(pm25);
        message.append("，");
        message.append(quality);
        message.append("。");
        message.append("\r\n");
        message.append("今天：");
        message.append(min + "℃-");
        message.append(max + "℃");
        message.append("，");
        message.append(weather.getResult().getData().getWeather().get(0).getInfo().getDay().get(1));
        message.append("，");
        message.append(dir.equals("") ? "无持续风向" : dir);
        message.append("，");
        message.append(day.get(4));
        message.append("级。");
        message.append("\r\n");
        message.append("明天：");
        message.append(min2 + "℃-");
        message.append(max1 + "℃");
        message.append("，");
        message.append(day1.get(1));
        message.append("，");
        message.append(dir1.equals("") ? "无持续风向" : dir1);
        message.append("，");
        message.append(src);
        message.append("级。");

        return message.toString();
    }

}
