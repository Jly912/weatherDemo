package com.jal.contract;

import com.jal.base.BasePresenter;
import com.jal.base.BaseView;

/**
 * Created by SEELE on 2017/4/17.
 */

public interface RegisterContract {

    interface View extends BaseView<Presenter> {
        void showError(String msg);

        void showLoading();

        void stopLoading();

        void showResults(String msg);

        void clear();
    }

    interface Presenter extends BasePresenter {
        void startRegist(String username,String pwd);

    }

}
