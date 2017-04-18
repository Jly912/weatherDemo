package com.jal.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jal.weatherdemo.R;

import butterknife.ButterKnife;

/**
 * Created by SEELE on 2017/4/13.
 */

public abstract class BaseFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);

        //查找actionbar控件设置paddingtop
        BaseActivity activity = (BaseActivity) getActivity();
        //判断activity是否开启沉浸式通知栏
        if (activity.isOpenStatus()) {
            View actionbarview = view.findViewById(R.id.actionbar);
            if (actionbarview != null) {
                int height = getStatusHeight(getActivity());
                actionbarview.setPadding(0, height, 0, 0);
            }
        }
        initView(view);
    }

    protected void initView(View view) {
    }

    protected abstract int getLayoutId();

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

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
