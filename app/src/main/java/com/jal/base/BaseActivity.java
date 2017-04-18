package com.jal.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.jal.weatherdemo.R;

import butterknife.ButterKnife;

/**
 * Created by SEELE on 2017/4/13.
 */

public abstract class BaseActivity extends AppCompatActivity {

    private FragmentManager manager;

    private BaseFragment fragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        manager=getSupportFragmentManager();


        if (isOpenStatus()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.TRANSPARENT);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }

            int statusHeight = getStatusHeight(this);
            if (statusHeight != -1) {

                View view = findViewById(R.id.actionbar);
                if (view != null) {
                    view.setPadding(0, statusHeight, 0, 0);
                }
            }

        }

        init();

    }

    protected void init() {
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return super.onKeyUp(keyCode, event);
    }

    protected abstract int getLayoutId();


    public boolean isOpenStatus() {
        return true;
    }

    /**
     * 获得通知栏的高度
     *
     * @return
     */
    private int getStatusHeight(Context context) {
        int resid = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resid > 0) {
            return context.getResources().getDimensionPixelSize(resid);
        }
        return -1;
    }

    /**
     * 展示Fragment
     */
    protected void showFragment(int resid, BaseFragment fragment) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();

        //隐藏正在暂时的Fragment
        if ( this.fragment != null) {
            fragmentTransaction.hide( this.fragment);
        }

        //展示需要显示的Fragment对象
        Fragment mFragment = manager.findFragmentByTag(fragment.getClass().getName());
        if (mFragment != null) {
            fragmentTransaction.show(mFragment);
            this.fragment = (BaseFragment) mFragment;
        } else {
            fragmentTransaction.add(resid, fragment, fragment.getClass().getName());
            this.fragment = fragment;
        }

        fragmentTransaction.commit();
    }

}
