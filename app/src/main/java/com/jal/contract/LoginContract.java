package com.jal.contract;

import com.jal.base.BasePresenter;
import com.jal.base.BaseView;

/**
 * Created by SEELE on 2017/4/17.
 */

public interface LoginContract {

    interface View extends BaseView<Presenter> {
        void showError(String msg);

        void showLoading();

        void stopLoading();

        void showResults(String msg);

    }

    interface Presenter extends BasePresenter {

        void startLogin(String user,String pwd);


        void forgetPwd();

    }

}
