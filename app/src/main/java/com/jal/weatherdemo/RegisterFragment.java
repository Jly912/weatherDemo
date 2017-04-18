package com.jal.weatherdemo;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.jal.base.BaseFragment;
import com.jal.bean.TimerCount;
import com.jal.contract.RegisterContract;
import com.jal.widget.EditTextWithDel;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by SEELE on 2017/4/17.
 */

public class RegisterFragment extends BaseFragment implements RegisterContract.View {
    @Bind(R.id.iv_register_user)
    ImageView ivRegisterUser;
    @Bind(R.id.et_user)
    EditTextWithDel etUser;
    @Bind(R.id.rl_name)
    RelativeLayout rlName;
    @Bind(R.id.iv_register_pwd)
    ImageView ivRegisterPwd;
    @Bind(R.id.et_code)
    EditTextWithDel etCode;
    @Bind(R.id.rl_code)
    RelativeLayout rlCode;
    @Bind(R.id.btn_get_code)
    Button btnGetCode;
    @Bind(R.id.iv_pwd)
    ImageView ivPwd;
    @Bind(R.id.et_pwd)
    EditTextWithDel etPwd;
    @Bind(R.id.rl_pwd)
    RelativeLayout rlPwd;
    @Bind(R.id.btn_next)
    Button btnNext;
    @Bind(R.id.ll_register_content)
    LinearLayout llRegisterContent;
    @Bind(R.id.ll_code)
    LinearLayout llCode;

    private TimerCount timerCount;
    private RegisterContract.Presenter presenter;

    public RegisterFragment(){
    }

    public static RegisterFragment getInstance(){
        return new RegisterFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register;
    }


    @OnClick({R.id.btn_get_code, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_get_code:
                break;
            case R.id.btn_next:
                break;
        }
    }

    @Override
    public void showError(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void stopLoading() {

    }

    @Override
    public void showResults(String msg) {

    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        if(presenter!=null){
            this.presenter=presenter;
        }
    }
}
