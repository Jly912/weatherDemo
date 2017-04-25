package com.jal.weatherdemo;

import android.view.View;
import android.widget.TextView;

import com.jal.base.BaseActivity;
import com.jal.util.ShareUtil;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by SEELE on 2017/4/25.
 */

public class AboutActivity extends BaseActivity {
    @Bind(R.id.tv_describer)
    TextView tvDescriber;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_about;
    }


    @OnClick({R.id.iv_back, R.id.ivWarn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.ivWarn:
                ShareUtil.shareText(this,tvDescriber.getText().toString().trim());
                break;
        }
    }

    @Override
    public boolean isOpenStatus() {
        return false;
    }
}
