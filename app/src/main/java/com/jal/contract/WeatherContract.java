package com.jal.contract;

import com.jal.base.BasePresenter;
import com.jal.base.BaseView;
import com.jal.bean.WeatherInfoBean;

/**
 * Created by SEELE on 2017/4/19.
 */

public interface WeatherContract {

    interface View extends BaseView<Presenter> {
        void showError();

        void showLoading();

        void stopLoading();

        void showResult(WeatherInfoBean weatherInfoBean);

        void showChart(WeatherInfoBean weatherInfoBean);

        void showLine(WeatherInfoBean weatherInfoBean);

    }


    interface Presenter extends BasePresenter {
        void loadPost();

        void refresh();

        void change(boolean showStyle);

        void loadPost(String city);

    }
}
