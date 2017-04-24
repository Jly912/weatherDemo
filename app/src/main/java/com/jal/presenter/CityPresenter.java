package com.jal.presenter;

import android.content.Context;

import com.jal.bean.LoginInfo;
import com.jal.contract.MyCityContract;
import com.jal.http.Http;
import com.jal.interfaces.OnDownListener;
import com.jal.util.SharedUtil;

import java.util.List;

/**
 * Created by SEELE on 2017/4/24.
 */

public class CityPresenter implements MyCityContract.Presenter {

    private Context context;
    private MyCityContract.View view;

    public CityPresenter(Context context, MyCityContract.View view) {
        this.context = context;
        this.view = view;
        this.view.setPresenter(this);

    }

    @Override
    public void loadatas() {
        view.showLoading();
        String username = SharedUtil.getString("username");
        String pwd = SharedUtil.getString("pwd");
        Http.getLogin(username, pwd, new OnDownListener() {
            @Override
            public void downSucc(Object object) {
                if(object!=null){
                    LoginInfo loginInfo= (LoginInfo) object;
                    List<String> city = loginInfo.getCity();
                    view.showResult(city);
                    view.stopLoading();
                }
            }

            @Override
            public void downFilded() {
                view.showError();
                view.stopLoading();
            }
        });
    }

    @Override
    public void refresh() {
        loadatas();
    }
}
