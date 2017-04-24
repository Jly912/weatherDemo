package com.jal.weatherdemo;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.jal.adapter.LoginPagerAdapter;
import com.jal.base.BaseActivity;
import com.jal.presenter.LoginPresenter;

import butterknife.Bind;

/**
 * Created by SEELE on 2017/4/13.
 */

public class LoginActivity extends BaseActivity {

    @Bind(R.id.login_tab)
    TabLayout loginTab;
    @Bind(R.id.login_vp)
    ViewPager loginVp;

    private LoginPresenter presenter;
    private LoginFragment loginFragment = LoginFragment.getInstance();
    private RegisterFragment registerFragment = RegisterFragment.getInstance();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
        setupViewPager();
        presenter = new LoginPresenter(this, loginFragment);
    }

    private void setupViewPager() {

        setupViewPager(loginVp);
        loginTab.setupWithViewPager(loginVp);
        loginTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                loginVp.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


    private void setupViewPager(ViewPager viewPager) {
        LoginPagerAdapter adapter = new LoginPagerAdapter(getSupportFragmentManager(), loginFragment, registerFragment);
        viewPager.setAdapter(adapter);

    }

    @Override
    public boolean isOpenStatus() {
        return false;
    }

}
