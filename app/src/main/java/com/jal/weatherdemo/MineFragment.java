package com.jal.weatherdemo;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jal.base.BaseFragment;
import com.jal.util.SharedUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

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
        HashSet<String> city = (HashSet<String>) SharedUtil.getSet("city");
        Log.e("print", "username" + user);
        tvNick.setText(user);
        tvAccount.setText(pwd);
        Iterator<String> iterator = city.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            citys.add(next);
            Log.d("print","ciiiii"+next);
        }

        tvNum.setText(citys.size()+"");

    }

    @OnClick({R.id.ll_city, R.id.ll_setting, R.id.ll_start, R.id.ll_about})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_city:
                break;
            case R.id.ll_setting:
                break;
            case R.id.ll_start:
                getContext().startActivity(new Intent(getContext(), StarSelectActivity.class));
                break;
            case R.id.ll_about:
                break;
        }
    }
}
