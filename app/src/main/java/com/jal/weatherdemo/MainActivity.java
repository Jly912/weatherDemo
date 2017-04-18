package com.jal.weatherdemo;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jal.base.BaseActivity;
import com.jal.presenter.LifePresenter;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {


    @Bind(R.id.fl_zw)
    FrameLayout flZw;
    @Bind(R.id.rb_home)
    RadioButton rbHome;
    @Bind(R.id.rb_life)
    RadioButton rbLife;
    @Bind(R.id.rb_mine)
    RadioButton rbMine;
    @Bind(R.id.rg)
    RadioGroup rg;
    @Bind(R.id.activity_main)
    LinearLayout activityMain;

    private WeatherFragment weatherFragment = WeatherFragment.getInstance();
    private MineFragment mineFragment = MineFragment.getInstance();
    private LifeFragment lifeFragment = LifeFragment.getInstance();

    private LifePresenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        rg.getChildAt(0).performClick();
        rg.setOnCheckedChangeListener(this);

        presenter=new LifePresenter(this,lifeFragment,"深圳");
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                showFragment(R.id.fl_zw, weatherFragment);
                break;
            case R.id.rb_life:
                showFragment(R.id.fl_zw, lifeFragment);
                break;
            case R.id.rb_mine:
                showFragment(R.id.fl_zw, mineFragment);
                break;
        }
    }

    @Override
    public boolean isOpenStatus() {
        return false;
    }
}
