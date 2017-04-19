package com.jal.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jal.bean.WeatherBean;
import com.jal.bean.WeatherInfoBean;
import com.jal.util.ReadFromAssets;
import com.jal.weatherdemo.R;
import com.jal.weatherdemo.SizeUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SEELE on 2017/2/8.
 */

public class WeatherChartView extends LinearLayout {

    private List<WeatherInfoBean.ResultBean.DataBean.WeatherBeanX> data = new ArrayList<>();

    private Map<String, WeatherBean> weatherBeanMap = new HashMap<>();

    LayoutParams cellParams, rowParams, chartParams;

    public WeatherChartView(Context context) {
        this(context, null);
    }

    public WeatherChartView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WeatherChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.setOrientation(VERTICAL);
        cellParams = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1);
        rowParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        chartParams = new LayoutParams(LayoutParams.MATCH_PARENT, SizeUtil.dp2px(context, 200));
        init();
    }

    public void setWeather(WeatherInfoBean heWeather5) {
        data.clear();
        data.addAll(heWeather5.getResult().getData().getWeather());
        drawWeather();
    }


    private void init() {
        weatherBeanMap = ReadFromAssets.getMap();
    }


    public void drawWeather() {
        removeAllViews();
        LinearLayout date = new LinearLayout(getContext());
        date.setLayoutParams(rowParams);
        date.setOrientation(HORIZONTAL);
        date.removeAllViews();

        LinearLayout icon = new LinearLayout(getContext());
        icon.setOrientation(HORIZONTAL);
        icon.setLayoutParams(rowParams);
        icon.removeAllViews();

        LinearLayout weatherStr = new LinearLayout(getContext());
        weatherStr.setOrientation(HORIZONTAL);
        weatherStr.setLayoutParams(rowParams);
        weatherStr.removeAllViews();

        List<Integer> minTemp = new ArrayList<>();
        List<Integer> maxTemp = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            TextView tvDate = new TextView(getContext());
            tvDate.setGravity(Gravity.CENTER);
            tvDate.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);

            TextView tvWeather = new TextView(getContext());
            tvWeather.setGravity(Gravity.CENTER);
            tvWeather.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);

            final ImageView ivIcon = new ImageView(getContext());

            ivIcon.setAdjustViewBounds(true);
            ivIcon.setScaleType(ImageView.ScaleType.FIT_CENTER);


            int padding = SizeUtil.dp2px(getContext(), 10);
            ivIcon.setPadding(padding, padding, padding, padding);
            if (i == 0) {
                tvDate.setText(R.string.today);
            } else if (i == 1) {
                tvDate.setText(R.string.tomorrow);
            } else {
                String week = data.get(i).getWeek();
                tvDate.setText("周" + week);
            }

            String weather = data.get(i).getInfo().getDay().get(1);
            Log.d("print", "天气----" + weather);
            tvWeather.setText(weather);
            WeatherBean weatherBean = weatherBeanMap.get(weather);
            Log.d("print", "------" + weatherBean);


            Glide.with(getContext())
                    .load(weatherBean.getIcon())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .dontTransform()
                    .into(ivIcon);

            WeatherInfoBean.ResultBean.DataBean.WeatherBeanX.InfoBeanX info = data.get(i).getInfo();
            Log.d("print", "info" + info);
            String max = data.get(i).getInfo().getDay().get(2);
            String min = data.get(i).getInfo().getNight().get(2);
            maxTemp.add(Integer.valueOf(max));
            minTemp.add(Integer.valueOf(min));

            weatherStr.addView(tvWeather, cellParams);
            date.addView(tvDate, cellParams);
            icon.addView(ivIcon, cellParams);
        }

        Log.d("print", "minTemp" + minTemp);
        Log.d("print", "maxTemp" + maxTemp);


        addView(date);
        addView(weatherStr);
        addView(icon);

        ChartView chartView = new ChartView(getContext());
        chartView.setData(minTemp, maxTemp);
        chartView.setPadding(0, SizeUtil.dp2px(getContext(), 16), 0, SizeUtil.dp2px(getContext(), 16));
        addView(chartView, chartParams);
    }
}
