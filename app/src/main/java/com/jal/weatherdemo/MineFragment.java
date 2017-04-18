package com.jal.weatherdemo;

import com.jal.base.BaseFragment;

/**
 * Created by SEELE on 2017/4/17.
 */

public class MineFragment extends BaseFragment {

    public MineFragment() {
    }

    public static MineFragment getInstance() {
        return new MineFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }
}
