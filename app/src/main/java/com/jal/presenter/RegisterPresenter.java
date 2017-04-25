package com.jal.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.jal.contract.RegisterContract;
import com.jal.http.Http;
import com.jal.interfaces.OnDownListener;
import com.jal.weatherdemo.LoginActivity;

/**
 * Created by SEELE on 2017/4/17.
 */

public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterContract.View view;

    private Gson gson=new Gson();

    private Context context;

    public RegisterPresenter(Context context,RegisterContract.View view){
        this.context=context;
        this.view=view;
        this.view.setPresenter(this);
    }

    @Override
    public void startRegist(String user,String pwd) {
        Http.registerUser(user, pwd, new OnDownListener() {
            @Override
            public void downSucc(Object object) {
                if (object!=null){
                    int code= (int) object;
                    switch (code){
                        case 0:
                            view.showResults("注册成功！");
                            view.stopLoading();
                            LoginActivity activity= (LoginActivity) context;
                            activity.setLogin();
                            view.clear();
                            break;
                        case 4:
                            view.showResults("用户名已存在！");
                            view.stopLoading();
                            break;
                    }
                }
            }

            @Override
            public void downFilded() {
                view.showError("注册失败！");
                view.stopLoading();
            }
        });
    }

}
