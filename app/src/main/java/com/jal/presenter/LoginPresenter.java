package com.jal.presenter;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.jal.bean.LoginInfo;
import com.jal.contract.LoginContract;
import com.jal.http.Http;
import com.jal.interfaces.OnDownListener;

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
                            break;
                        case -1:
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

//        if (user.equals("123") && pwd.equals("123456")) {
////            view.showResults(context.getResources().getString(R.string.login_succ));
//            context.startActivity(new Intent(context, MainActivity.class));
//            view.stopLoading();
//        }else {
//            view.showError(context.getResources().getString(R.string.login_failed));
//            view.stopLoading();
//            return;
//        }
    }

    @Override
    public void forgetPwd() {

    }


}
