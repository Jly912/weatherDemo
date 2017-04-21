package com.jal.weatherdemo;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jal.base.BaseFragment;
import com.jal.bean.LoginInfo;
import com.jal.contract.LoginContract;
import com.jal.util.SharedUtil;
import com.jal.widget.EditTextWithDel;
import com.jal.widget.Tools;

import java.util.HashSet;
import java.util.Iterator;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by SEELE on 2017/4/17.
 */

public class LoginFragment extends BaseFragment implements LoginContract.View {

    @Bind(R.id.et_user)
    EditTextWithDel etUser;
    @Bind(R.id.et_pwd)
    EditTextWithDel etPwd;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.tv_forget)
    TextView tvForget;
    @Bind(R.id.login_pb)
    ProgressBar loginPb;
    @Bind(R.id.rl_name)
    RelativeLayout rlName;
    @Bind(R.id.rl_pwd)
    RelativeLayout rlPwd;
    @Bind(R.id.iv_login_user)
    ImageView ivLoginUser;
    @Bind(R.id.iv_pwd)
    ImageView ivPwd;

    private LoginContract.Presenter presenter;

    public LoginFragment() {
    }

    public static LoginFragment getInstance() {
        return new LoginFragment();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    protected void initView(View view) {


        etUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
//                String user = etUser.getText().toString().trim();
            }
        });

        etPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                rlPwd.setBackground(getResources().getDrawable(R.drawable.shape_bg_bored_color_black));
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        initLogin();
    }

    private void initLogin() {
        String username = SharedUtil.getString("username");
        String password = SharedUtil.getString("password");
        etUser.setText(username);
        etUser.setText(password);
    }

    @OnClick({R.id.btn_login, R.id.tv_forget})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String user = etUser.getText().toString().trim();
                String pwd = etPwd.getText().toString().trim();
                if (TextUtils.isEmpty(user)) {
                    rlName.setBackground(getResources().getDrawable(R.drawable.shape_bg_bored_cutmaincolor));
                    ivLoginUser.setAnimation(Tools.shakeAnimation(2));
                    showSnackBar(view, "请输入手机号码！");
                    return;
                }

                if (TextUtils.isEmpty(pwd)) {
                    rlPwd.setBackground(getResources().getDrawable(R.drawable.shape_bg_bored_cutmaincolor));
                    ivPwd.setAnimation(Tools.shakeAnimation(2));
                    showSnackBar(view, "请输入密码！");
                    return;
                }

                showLoading();
                presenter.startLogin(user, pwd);
                break;
            case R.id.tv_forget:
                presenter.forgetPwd();
                break;
        }
    }

    private void showSnackBar(View view, String msg) {
        Snackbar.make(view, msg, Snackbar.LENGTH_SHORT).show();
    }


    @Override
    public void showError(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        loginPb.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopLoading() {
        loginPb.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showResults(LoginInfo loginInfo) {

        Log.e("print","show--"+loginInfo);
        String user = etUser.getText().toString().trim();
        String pwd = etPwd.getText().toString().trim();

        HashSet<String> set=new HashSet<>();

        for (int i = 0; i < loginInfo.getCity().size(); i++) {
            String city = loginInfo.getCity().get(i);
            set.add(city);
        }

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            Log.d("print","next"+next);
        }


        Log.e("print","show-user-"+user+"--"+pwd);

        Toast.makeText(getContext(), getContext().getResources().getString(R.string.login_succ), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getContext(), MainActivity.class);
        SharedUtil.putString("username", loginInfo.getUsername());
        SharedUtil.putString("pwd", pwd);
        SharedUtil.putSet("city", set);

//        intent.putExtra("user", loginInfo);
        getContext().startActivity(intent);
    }

    @Override
    public void setPresenter(LoginContract.Presenter presenter) {
        if (presenter != null) {
            this.presenter = presenter;
        }
    }

}
