package com.jal.weatherdemo;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jal.base.BaseActivity;
import com.jal.bean.StartInfo;
import com.jal.http.Http;
import com.jal.interfaces.OnDownListener;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by SEELE on 2017/4/20.
 */

public class StarDetailActivity extends BaseActivity {
    @Bind(R.id.tv_title)
    TextView tvTitle;
    @Bind(R.id.iv_sta)
    ImageView ivSta;
    @Bind(R.id.tv_name)
    TextView tvName;
    @Bind(R.id.tv_all)
    TextView tvAll;
    @Bind(R.id.tv_qFriend)
    TextView tvQFriend;
    @Bind(R.id.tv_health)
    TextView tvHealth;
    @Bind(R.id.tv_money)
    TextView tvMoney;
    @Bind(R.id.tv_love)
    TextView tvLove;
    @Bind(R.id.tv_work)
    TextView tvWork;
    @Bind(R.id.tv_num)
    TextView tvNum;
    @Bind(R.id.tv_color)
    TextView tvColor;
    @Bind(R.id.tv_summary)
    TextView tvSummary;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_star_detail;
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int index = intent.getIntExtra("index", -1);

        tvTitle.setText(name);
        tvName.setText(name);

        Glide.with(this)
                .load(index)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(ivSta);

        Http.getStarInfo(name, new OnDownListener() {
            @Override
            public void downSucc(Object object) {
                if (object != null) {
                    StartInfo info = (StartInfo) object;
                    tvAll.setText("综合运势：" + info.getResult1().getAll());
                    tvQFriend.setText("速配Q友：" + info.getResult1().getQFriend());
                    tvHealth.setText("健康指数：" + info.getResult1().getHealth());
                    tvLove.setText("爱情指数：" + info.getResult1().getLove());
                    tvMoney.setText("金钱运势：" + info.getResult1().getMoney());
                    tvWork.setText("工作运势：" + info.getResult1().getWork());
                    tvColor.setText("幸运颜色：" + info.getResult1().getColor());
                    tvNum.setText("幸运数字：" + info.getResult1().getNumber());
                    tvSummary.setText("    "+info.getResult1().getSummary());
                }
            }

            @Override
            public void downFilded() {

            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public boolean isOpenStatus() {
        return false;
    }
}
