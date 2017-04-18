package com.jal.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jal.weatherdemo.LoginFragment;
import com.jal.weatherdemo.RegisterFragment;

/**
 * Created by SEELE on 2017/4/17.
 */

public class LoginPagerAdapter extends FragmentPagerAdapter {

    private String[] data = {"登录", "注册"};
    private LoginFragment loginFragment;
    private RegisterFragment registerFragment;

    public LoginPagerAdapter(FragmentManager fm,LoginFragment loginFragment,RegisterFragment registerFragment) {
        super(fm);
        this.loginFragment=loginFragment;
        this.registerFragment=registerFragment;

    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return loginFragment;
        }
        return registerFragment;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return data[position];
    }
}
