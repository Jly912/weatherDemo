package com.jal.weatherdemo;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

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
    @Bind(R.id.iv_pwd_2)
    ImageView ivPwd2;
    @Bind(R.id.et_pwd_ensure)
    EditTextWithDel etPwdEnsure;
    @Bind(R.id.rl_ensure_pwd)
    RelativeLayout rlEnsurePwd;

    @Bind(R.id.pb)
    ProgressBar pb;

    private TimerCount timerCount;
    private RegisterContract.Presenter presenter;

    public RegisterFragment() {
    }

    public static RegisterFragment getInstance() {
        return new RegisterFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_register;
    }

    @Override
    protected void initView(View view) {
        timerCount = new TimerCount(60000, 1000, btnGetCode);
    }

    @OnClick({R.id.btn_get_code, R.id.btn_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_get_code:
                showError(getCode());
                timerCount.start();
                break;
            case R.id.btn_next:
                String username = etUser.getText().toString().trim();
                String pwd = etPwd.getText().toString().trim();
                String trim = etCode.getText().toString().trim();
                String ensure = etPwdEnsure.getText().toString().trim();
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(pwd) || TextUtils.isEmpty(trim)) {
                    showError("输入框数据不能为空！");
                    return;
                }
                if (trim.equals(getCode())) {
                    if (ensure.equals(pwd)) {
                        presenter.startRegist(username, pwd);
                    }else {
                        showError("密码不一致！");
                    }
                } else {
                    showError("验证码错误！");
                }
                break;
        }
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopLoading() {
        pb.setVisibility(View.GONE);
    }

    @Override
    public void showResults(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void clear() {
        etPwdEnsure.setText("");
        etPwd.setText("");
        etCode.setText("");
        etUser.setText("");
        btnGetCode.setText(getContext().getResources().getString(R.string.get_code));
        timerCount.cancel();
    }

    @Override
    public void setPresenter(RegisterContract.Presenter presenter) {
        if (presenter != null) {
            this.presenter = presenter;
        }
    }

    public String getCode() {

        return "1234";
    }

}
