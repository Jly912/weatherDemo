package com.jal.weatherdemo;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.jal.adapter.StarRyAdapter;
import com.jal.base.BaseActivity;
import com.jal.interfaces.OnRyClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by SEELE on 2017/4/20.
 */

public class StarSelectActivity extends BaseActivity {

    @Bind(R.id.ry_star)
    RecyclerView ryStar;

    @Bind(R.id.back)
    ImageView ivBack;

    private StarRyAdapter adapter;
    private List<String> names = new ArrayList<>();
    private List<String> stars = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_star;
    }

    @Override
    protected void init() {

        String[] starnames = getResources().getStringArray(R.array.star_name);
        for (int i = 0; i < starnames.length; i++) {
            stars.add(starnames[i]);
        }


        String[] stringArray = getResources().getStringArray(R.array.stars);
        for (int i = 0; i < stringArray.length; i++) {
            names.add(stringArray[i]);
        }

        ryStar.setLayoutManager(new LinearLayoutManager(this));
        int[] ids = {R.mipmap.start_sheep, R.mipmap.start_cow, R.mipmap.start_double, R.mipmap.start_cancer, R.mipmap.start_leo,
                R.mipmap.start_virgo, R.mipmap.start_libra, R.mipmap.start_scorpio, R.mipmap.start_hand, R.mipmap.start_capricorn,
                R.mipmap.start_auqarius, R.mipmap.start_fish};

        final int[] id2 = {R.mipmap.s1, R.mipmap.s2, R.mipmap.s3, R.mipmap.s4, R.mipmap.s5,
                R.mipmap.s6, R.mipmap.s7, R.mipmap.s8, R.mipmap.s9, R.mipmap.s10,
                R.mipmap.s11, R.mipmap.s12};


        adapter = new StarRyAdapter(this, ids, names);
        ryStar.setAdapter(adapter);
        adapter.setListener(new OnRyClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Log.d("print", names.get(position));
                Intent intent = new Intent(StarSelectActivity.this, StarDetailActivity.class);
                intent.putExtra("name", stars.get(position));
                intent.putExtra("index", id2[position]);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean isOpenStatus() {
        return false;
    }


    @OnClick(R.id.back)
    public void onViewClicked() {
        finish();
    }
}
