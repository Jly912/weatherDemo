package com.jal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jal.bean.WeatherBean;
import com.jal.bean.WeatherInfoBean;
import com.jal.util.ReadFromAssets;
import com.jal.weatherdemo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SEELE on 2017/2/8.
 */

public class WeatherDetailView extends LinearLayout {

    private WeatherInfoBean weatherInfoBean;

    private List<WeatherInfoBean.ResultBean.DataBean.WeatherBeanX> dailyForecastList = new ArrayList<>();
    LayoutParams rowParams;

    private Map<String, WeatherBean> weatherBeanMap = new HashMap<>();


    public WeatherDetailView(Context context) {
        this(context, null);
    }

    public WeatherDetailView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WeatherDetailView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setOrientation(VERTICAL);
        rowParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        init();
    }

    private void init() {
        weatherBeanMap=ReadFromAssets.getMap();
    }

    private void drawInfo() {
        removeAllViews();
        for (int i = 0; i < dailyForecastList.size(); i++) {
            View view = View.inflate(getContext(), R.layout.item_daily_weather, null);
            TextView tvTemp = (TextView) view.findViewById(R.id.tv_day_temp);
            TextView tvWeek = (TextView) view.findViewById(R.id.tv_day_week);
            TextView tvInfo = (TextView) view.findViewById(R.id.tv_day_info);
            TextView tvSunrise= (TextView) view.findViewById(R.id.tv_sunrise);
            TextView tvDawn= (TextView) view.findViewById(R.id.tv_dawn);
            final ImageView ivWeek = (ImageView) view.findViewById(R.id.iv_day_weather);

            if (i == 0) {
                tvWeek.setText("今天");
            } else if (i == 1) {
                tvWeek.setText("明天");
            } else {
                tvWeek.setText("周"+dailyForecastList.get(i).getWeek());
            }

            WeatherInfoBean.ResultBean.DataBean.WeatherBeanX.InfoBeanX info = dailyForecastList.get(i).getInfo();
            List<String> day = info.getDay();
            String weather = day.get(1);
            String highTemp = day.get(2);
            String windDerct = day.get(3);
            String windPower = day.get(4);
            String sunriseTime = day.get(5);

            List<String> night = info.getNight();
            String lowTemp = night.get(2);
            String dawnTime = night.get(5);

            tvTemp.setText(String.format(("%s℃ - %s℃"), lowTemp, highTemp));
            tvInfo.setText(String.format("%s，%s ,%s ", weather,windDerct.equals("")?"无持续风向":windDerct,windPower));
            tvSunrise.setText("日出："+sunriseTime);
            tvDawn.setText("日落："+dawnTime);

            if(weather.indexOf("到")!=-1){
                Log.d("print","含有到"+weather);
                String[] s = weather.split("到");
                Log.d("print",weather+"-----"+s.length+"==========");
                weather = s[s.length - 1];
            }else {
                Log.d("print","不含到"+weather);
            }

            WeatherBean weatherBean = weatherBeanMap.get(weather);
            Glide.with(getContext())
                    .load(weatherBean.getIcon())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(ivWeek);

            addView(view, rowParams);
        }
    }

    public void setWeather5(WeatherInfoBean weather) {
        dailyForecastList.clear();
        this.weatherInfoBean = weather;
        List<WeatherInfoBean.ResultBean.DataBean.WeatherBeanX> weather1 = weather.getResult().getData().getWeather();
        dailyForecastList.addAll(weather1);
        drawInfo();
    }
}
