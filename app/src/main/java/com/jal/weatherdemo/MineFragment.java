package com.jal.weatherdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jal.base.BaseFragment;
import com.jal.bean.LoginInfo;
import com.jal.http.Http;
import com.jal.interfaces.OnDownListener;
import com.jal.util.SharedUtil;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by SEELE on 2017/4/17.
 */

public class MineFragment extends BaseFragment {

    @Bind(R.id.iv_head)
    CircleImageView ivHead;
    @Bind(R.id.tv_nick)
    TextView tvNick;
    @Bind(R.id.tv_account)
    TextView tvAccount;
    @Bind(R.id.tv_num)
    TextView tvNum;

    private MainActivity activity;

    private ArrayList<String> citys = new ArrayList<>();

    public MineFragment() {
    }

    public static MineFragment getInstance() {
        return new MineFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(View view) {

        String user = SharedUtil.getString("username");
        String pwd = SharedUtil.getString("pwd");
        String size = SharedUtil.getString("city");
        Log.e("print", "username" + user);
        tvNick.setText(user);
        tvAccount.setText(pwd);

        activity = (MainActivity) getActivity();
        LoginInfo info = activity.getInfo();
        citys = (ArrayList<String>) info.getCity();
        tvNum.setText(size);

    }

    @OnClick({R.id.ll_city, R.id.ll_setting, R.id.ll_start, R.id.ll_about})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_city:
                //城市管理
                Intent intent = new Intent(getActivity(), MyCityActivity.class);
                intent.putExtra("city", citys);
                getContext().startActivity(intent);
                break;
            case R.id.ll_setting:
                break;
            case R.id.ll_start:
                getContext().startActivity(new Intent(getContext(), StarSelectActivity.class));
                break;
            case R.id.ll_about:
                getContext().startActivity(new Intent(getContext(),AboutActivity.class));
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        Log.d("print", "mine---------onresume");
        Http.getLogin(SharedUtil.getString("username"), SharedUtil.getString("pwd"), new OnDownListener() {
            @Override
            public void downSucc(Object object) {
                if (object != null) {
                    LoginInfo loginInf = (LoginInfo) object;
                    tvNum.setText(loginInf.getCity().size() + "");
                }
            }

            @Override
            public void downFilded() {

            }
        });

        super.onResume();
    }
}
