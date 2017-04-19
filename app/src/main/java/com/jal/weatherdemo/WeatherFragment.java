package com.jal.weatherdemo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jal.base.BaseFragment;
import com.jal.bean.WeatherInfoBean;
import com.jal.contract.WeatherContract;
import com.jal.util.NetworkUtil;
import com.jal.util.ShareUtil;
import com.jal.util.TTSManager;
import com.jal.widget.WeatherChartView;
import com.jal.widget.WeatherDetailView;
import com.zaaach.citypicker.CityPickerActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.Bind;

import static android.app.Activity.RESULT_OK;

/**
 * Created by SEELE on 2017/4/17.
 */

public class WeatherFragment extends BaseFragment implements WeatherContract.View {


    @Bind(R.id.bannner)
    ImageView bannner;
    @Bind(R.id.tv_city_name)
    TextView tvCityName;
    @Bind(R.id.tv_weather_string)
    TextView tvWeatherString;
    @Bind(R.id.tv_weather_aqi)
    TextView tvWeatherAqi;
    @Bind(R.id.tv_temp)
    TextView tvTemp;
    @Bind(R.id.tv_update_time)
    TextView tvUpdateTime;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.actionbar)
    AppBarLayout actionbar;

    @Bind(R.id.tv_week)
    TextView tvWeek;

    @Bind(R.id.tv_wind)
    TextView tvWind;

    @Bind(R.id.tv_moon)
    TextView tvMoon;

    @Bind(R.id.tv_date)
    TextView tvDate;
    @Bind(R.id.contentLayout)
    LinearLayout contentLayout;

    @Bind(R.id.swipeRefresh)
    SwipeRefreshLayout refreshLayout;

    private WeatherContract.Presenter presenter;

    private boolean showWeatherChart = true;

    private WeatherInfoBean infoBean;

    private static final int REQUEST_CODE_PICK_CITY = 233;

    public WeatherFragment() {
    }

    public static WeatherFragment getInstance() {
        return new WeatherFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_weather;
    }

    @Override
    protected void initView(View view) {
        presenter.loadPost();
        toolbar.setTitle("天气");

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.refresh();
            }
        });
        toolbar.inflateMenu(R.menu.menu_weather);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.loadPost();
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), getContext().getResources().getString(R.string.load_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void stopLoading() {
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void showResult(WeatherInfoBean weatherInfoBean) {
        Log.d("print", "------------" + weatherInfoBean);
        if (weatherInfoBean != null) {
            infoBean=weatherInfoBean;

            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    int id = item.getItemId();
                    if (id == R.id.menu_share) {
                        String shareMessage = WeatherUtil.getShareMessage(infoBean);
                        ShareUtil.shareText(getContext(),shareMessage);
                        return true;
                    } else if (id == R.id.menu_tts) {//语音播报
                        String shareMessage = WeatherUtil.getShareMessage(infoBean);
                        if (shareMessage.equals("") || shareMessage == null) {
                            Toast.makeText(getContext(), "正在初始化！", Toast.LENGTH_SHORT).show();
                        } else {
                            Log.e("print", "--------语音-----" + shareMessage);
                            TTSManager.getInstance(getActivity()).speak(shareMessage, null);
                        }
                        return true;
                    } else if (id == R.id.menu_more) {
                        startActivityForResult(new Intent(getActivity(), CityPickerActivity.class),
                                REQUEST_CODE_PICK_CITY);
                        return true;
                    }
                    return false;
                }
            });

            if (showWeatherChart) {
                showChart(weatherInfoBean);
            } else {
                showLine(weatherInfoBean);
            }

            contentLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    showWeatherChart = !showWeatherChart;
                    presenter.change(showWeatherChart);
                    Log.d("print", "点击了" + showWeatherChart);
                }
            });

            WeatherInfoBean.ResultBean.DataBean.RealtimeBean realtime = weatherInfoBean.getResult().getData().getRealtime();

            WeatherInfoBean.ResultBean.DataBean.Pm25BeanX pm25 = weatherInfoBean.getResult().getData().getPm25();

            tvCityName.setText(realtime.getCity_name());
            WeatherInfoBean.ResultBean.DataBean.RealtimeBean.WeatherBean weather = realtime.getWeather();
            String info = weather.getInfo();
            tvWeatherString.setText(info);

            tvTemp.setText(weather.getTemperature() + "℃");

            tvWeatherAqi.setText(pm25.getPm25().getQuality());

            int dataUptime = realtime.getDataUptime();
            //时间戳转化为Sting或Date
            String s = TimeStamp2Date(dataUptime + "", "HH:mm");
            tvUpdateTime.setText("截止" + s);

            int week = realtime.getWeek();
            String wk = "";
            switch (week) {
                case 1:
                    wk = "周一";
                    break;
                case 2:
                    wk = "周二";
                    break;
                case 3:
                    wk = "周三";
                    break;
                case 4:
                    wk = "周四";
                    break;
                case 5:
                    wk = "周五";
                    break;
                case 6:
                    wk = "周六";
                    break;
                case 7:
                    wk = "周日";
                    break;

            }
            tvWeek.setText(wk);

            String wind = realtime.getWind().getDirect() + realtime.getWind().getPower();
            tvWind.setText(wind);

            String date = realtime.getDate();
            tvDate.setText(date);

            String moon = realtime.getMoon();
            tvMoon.setText(moon);
        }
    }

    @Override
    public void showChart(WeatherInfoBean weatherInfoBean) {
        contentLayout.setPadding(0, SizeUtil.dp2px(getContext(), 16), 0, SizeUtil.dp2px(getContext(), 16));
        contentLayout.removeAllViews();
        contentLayout.addView(getChartView(weatherInfoBean));
    }

    @Override
    public void showLine(WeatherInfoBean weatherInfoBean) {
        contentLayout.removeAllViews();
        contentLayout.addView(getDetailView(weatherInfoBean));
    }

    @Override
    public void setPresenter(WeatherContract.Presenter presenter) {
        if (presenter != null) {
            this.presenter = presenter;
        }
    }

    public static String TimeStamp2Date(String timestampString, String formats) {
        if (TextUtils.isEmpty(formats))
            formats = "yyyy-MM-dd HH:mm:ss";
        Long timestamp = (Long.parseLong(timestampString) * 1000);
        long l = System.currentTimeMillis();
        Log.d("print","curr"+l+"-------"+timestamp);
        String date = new SimpleDateFormat(formats, Locale.CHINA).format(new Date(timestamp));
        return date;
    }

    private WeatherChartView getChartView(WeatherInfoBean weather5) {
        WeatherChartView chartView = new WeatherChartView(getContext());
        chartView.setWeather(weather5);
        return chartView;
    }

    private WeatherDetailView getDetailView(WeatherInfoBean weather5) {
        WeatherDetailView detailView = new WeatherDetailView(getContext());
        detailView.setWeather5(weather5);
        return detailView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK) {
            if (data != null) {
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                boolean networkAvailable = NetworkUtil.isNetworkConnected(getContext());
                if(networkAvailable){
//                    (city);
                    presenter.loadPost(city);
                }else {
                    Toast.makeText(getContext(),"请检查网络是否正常！",Toast.LENGTH_SHORT).show();
                }

            }
        }
    }
}
