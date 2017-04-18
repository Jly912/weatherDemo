package com.jal.contract;

import com.jal.base.BasePresenter;
import com.jal.base.BaseView;
import com.jal.bean.WeatherInfoBean;

/**
 * Created by SEELE on 2017/4/17.
 */

public interface LifeContract {

    interface View extends BaseView<Presenter> {
        void showError();

        void showLoading();

        void stopLoading();

        void showResults(WeatherInfoBean weatherInfoBean);

    }

    interface Presenter extends BasePresenter {
        void loadDatas();

        void refresh();
    }

}
