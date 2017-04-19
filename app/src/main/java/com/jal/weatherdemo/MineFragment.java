package com.jal.weatherdemo;

import android.view.View;
import android.widget.TextView;

import com.jal.base.BaseFragment;

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

    public MineFragment() {
    }

    public static MineFragment getInstance() {
        return new MineFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }


    @OnClick({R.id.ll_city, R.id.ll_setting, R.id.ll_start, R.id.ll_about})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_city:
                break;
            case R.id.ll_setting:
                break;
            case R.id.ll_start:
                break;
            case R.id.ll_about:
                break;
        }
    }
}
