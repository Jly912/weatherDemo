package com.jal.weatherdemo;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.jal.adapter.CityRyAdapter;
import com.jal.base.BaseActivity;
import com.jal.contract.MyCityContract;
import com.jal.http.Http;
import com.jal.interfaces.OnDownListener;
import com.jal.interfaces.OnRyClickListener;
import com.jal.presenter.CityPresenter;
import com.jal.util.SharedUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by SEELE on 2017/4/24.
 */

public class MyCityActivity extends BaseActivity implements MyCityContract.View {
    @Bind(R.id.ry_city)
    RecyclerView ryCity;
    @Bind(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;

    private CityRyAdapter adapter;
    private MyCityContract.Presenter presenter;
    private String user, pwd;
    private List<String> citys=new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mycity;
    }

    @Override
    protected void init() {

        user = SharedUtil.getString("username");
        pwd = SharedUtil.getString("pwd");
        presenter = new CityPresenter(this, this);
        Intent intent = getIntent();
        citys = (List<String>) intent.getSerializableExtra("city");

        presenter.loadatas();

        adapter = new CityRyAdapter(this);
        ryCity.setLayoutManager(new LinearLayoutManager(this));
        adapter.setData(citys);
        ryCity.setAdapter(adapter);

        adapter.setListener(new OnRyClickListener() {
            @Override
            public void onItemClick(View view, final int position) {
                Log.d("print","----点击-");
                Http.delCity(user, pwd, citys.get(position), new OnDownListener() {
                    @Override
                    public void downSucc(Object object) {
                        if(object!=null){
                            int code= (int) object;
                            switch (code){
                                case 0:
                                    //删除成功
                                    adapter.removeDate(position);
//                                    int size = adapter.getCity().size();
                                    showToast("删除成功！");
                                    break;
                                case 1:
                                    //用户不存在该城市
                                    showToast("用户不存在该城市！");
                                    break;
                                case -1:
                                    //数据库操作失败
                                    showToast("数据库操作失败!");
                                    break;
                            }
                        }
                    }

                    @Override
                    public void downFilded() {
                        showError();
                    }
                });
            }
        });

        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.refresh();
            }
        });
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        finish();
    }

    @Override
    public void showLoading() {
        swipeRefresh.setRefreshing(true);
    }

    @Override
    public void stopLoading() {
        swipeRefresh.setRefreshing(false);
    }

    @Override
    public void showResult(final List<String> city) {
        adapter.setData(city);
        Log.d("print","----点击111111-");

    }

    @Override
    public void showError() {
        Toast.makeText(this, "加载失败！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(MyCityContract.Presenter presenter) {
        if (presenter != null) {
            this.presenter = presenter;
        }
    }

    @Override
    public boolean isOpenStatus() {
        return false;
    }

    public void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
