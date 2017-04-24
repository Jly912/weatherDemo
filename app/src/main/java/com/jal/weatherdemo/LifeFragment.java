package com.jal.weatherdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.jal.base.BaseFragment;
import com.jal.bean.WeatherInfoBean;
import com.jal.contract.LifeContract;

import java.util.List;

import butterknife.Bind;

/**
 * Created by SEELE on 2017/4/17.
 */

public class LifeFragment extends BaseFragment implements LifeContract.View {

    @Bind(R.id.tv_clothe)
    TextView tvClothe;
    @Bind(R.id.tv_clothe_suggestion)
    TextView tvClotheSuggestion;

    @Bind(R.id.tv_sick)
    TextView tvSick;
    @Bind(R.id.tv_sick_suggestion)
    TextView tvSickSuggestion;

    @Bind(R.id.tv_kt)
    TextView tvKt;
    @Bind(R.id.tv_kt_suggestion)
    TextView tvKtSuggestion;

    @Bind(R.id.tv_car)
    TextView tvCar;
    @Bind(R.id.tv_car_suggestion)
    TextView tvCarSuggestion;

    @Bind(R.id.tv_sport)
    TextView tvSport;
    @Bind(R.id.tv_sport_suggestion)
    TextView tvSportSuggestion;

    @Bind(R.id.tv_zwx)
    TextView tvZwx;
    @Bind(R.id.tv_zwx_suggestion)
    TextView tvZwxSuggestion;

    @Bind(R.id.tv_pm)
    TextView tvPm;
    @Bind(R.id.tv_pm_suggestion)
    TextView tvPmSuggestion;

    @Bind(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;

    private LifeContract.Presenter presenter;

    public LifeFragment() {
    }

    public static LifeFragment getInstance() {
        return new LifeFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_life;
    }

    @Override
    protected void initView(View view) {
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.refresh();
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        presenter.loadDatas();
    }


    @Override
    public void showError() {
        Toast.makeText(getContext(), "加载失败！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        swipeRefresh.setRefreshing(true);
    }

    @Override
    public void stopLoading() {
        swipeRefresh.setRefreshing(false);
    }

    @Override
    public void showResults(WeatherInfoBean weatherInfoBean) {
        WeatherInfoBean.ResultBean.DataBean data = weatherInfoBean.getResult().getData();
        WeatherInfoBean.ResultBean.DataBean.LifeBean life = data.getLife();
        WeatherInfoBean.ResultBean.DataBean.LifeBean.InfoBean info = life.getInfo();
        WeatherInfoBean.ResultBean.DataBean.Pm25BeanX pm25 = data.getPm25();
        List<String> chuanyi = info.getChuanyi();
        List<String> ganmao = info.getGanmao();
        List<String> kongtiao = info.getKongtiao();
        List<String> xiche = info.getXiche();
        List<String> yundong = info.getYundong();
        List<String> ziwaixian = info.getZiwaixian();
        WeatherInfoBean.ResultBean.DataBean.Pm25BeanX.Pm25Bean pm251 = pm25.getPm25();
        String des = pm251.getDes();
        String quality = pm251.getQuality();

        tvClothe.setText(chuanyi.get(0));
        tvClotheSuggestion.setText(chuanyi.get(1));

        tvSick.setText(ganmao.get(0));
        tvSickSuggestion.setText(ganmao.get(1));

        tvKt.setText(kongtiao.get(0));
        tvKtSuggestion.setText(kongtiao.get(1));

        tvCar.setText(xiche.get(0));
        tvCarSuggestion.setText(xiche.get(1));

        tvSport.setText(yundong.get(0));
        tvSportSuggestion.setText(yundong.get(1));

        tvZwx.setText(ziwaixian.get(0));
        tvZwxSuggestion.setText(ziwaixian.get(1));

        tvPm.setText(quality);
        tvPmSuggestion.setText(des);


    }

    @Override
    public void setPresenter(LifeContract.Presenter presenter) {
        if (presenter != null) {
            this.presenter = presenter;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
    }
}
