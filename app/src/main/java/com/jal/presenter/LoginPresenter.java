package com.jal.presenter;

import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;
import com.jal.contract.LoginContract;
import com.jal.weatherdemo.MainActivity;
import com.jal.weatherdemo.R;

/**
 * Created by SEELE on 2017/4/17.
 */

public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;

    private Context context;

    private Gson gson = new Gson();

    public LoginPresenter(Context context, LoginContract.View view) {
        this.context = context;
        this.view = view;
        this.view.setPresenter(this);
    }


    @Override
    public void startLogin(String user, String pwd) {

        if (user.equals("123") && pwd.equals("123456")) {
            view.showResults(context.getResources().getString(R.string.login_succ));
            context.startActivity(new Intent(context, MainActivity.class));
            view.stopLoading();
        }else {
            view.showError(context.getResources().getString(R.string.login_failed));
            view.stopLoading();
            return;
        }
    }

    @Override
    public void forgetPwd() {

    }


}
