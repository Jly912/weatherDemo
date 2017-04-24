package com.jal.contract;

import com.jal.base.BasePresenter;
import com.jal.base.BaseView;

import java.util.List;

/**
 * Created by SEELE on 2017/4/24.
 */

public interface MyCityContract {

    interface View extends BaseView<Presenter>{
        void  showLoading();

        void stopLoading();

        void showResult(List<String> city);

        void showError();
    }

    interface  Presenter extends BasePresenter{
        void loadatas();

        void refresh();
    }

}
