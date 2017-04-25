package com.jal.presenter;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.jal.bean.LoginInfo;
import com.jal.contract.LoginContract;
import com.jal.http.Http;
import com.jal.interfaces.OnDownListener;
import com.jal.util.SharedUtil;

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
    public void startLogin(String user, final String pwd) {

        Log.d("print","url"+"user"+user+"-----"+pwd);
        Http.getLogin(user, pwd, new OnDownListener() {
            @Override
            public void downSucc(Object object) {
                if(object!=null){
                    LoginInfo info= (LoginInfo) object;
                    Log.e("print","info"+info);
                    String username = info.getUsername();
                    switch (info.getCode()){
                        case 0:
                            break;
                        case 1:
                            //登录成功
                            view.showResults(info);
                            SharedUtil.putString("username", info.getUsername());
                            SharedUtil.putString("pwd", pwd);
                            SharedUtil.putString("cityNum",info.getCity().size()+"");
                            break;
                        case -1:
                            view.showError("密码错误！");
                            view.stopLoading();
                            break;
                        case 2:
                            break;
                        case 3:
                            //用户不存在
                            view.showError("用户不存在！");
                            view.stopLoading();
                            break;
                    }
                }
            }

            @Override
            public void downFilded() {
                view.showError("登录失败！");
                view.stopLoading();
                return;
            }
        });


    }

    @Override
    public void forgetPwd() {

    }


}
