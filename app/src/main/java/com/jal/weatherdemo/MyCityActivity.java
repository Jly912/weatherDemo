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
import com.jal.util.NetworkUtil;
import com.jal.util.SharedUtil;
import com.zaaach.citypicker.CityPickerActivity;

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
    private List<String> citys = new ArrayList<>();

    private static final int REQUEST_CODE_PICK_CITY = 233;

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
                Log.d("print", "----点击-");
                Http.delCity(user, pwd, citys.get(position), new OnDownListener() {
                    @Override
                    public void downSucc(Object object) {
                        if (object != null) {
                            int code = (int) object;
                            switch (code) {
                                case 0:
                                    //删除成功
                                    adapter.removeDate(position);
                                    SharedUtil.putInt("cityNum", adapter.getCity().size());
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

    @OnClick({R.id.iv_back, R.id.iv_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_add:
                startActivityForResult(new Intent(this, CityPickerActivity.class), REQUEST_CODE_PICK_CITY);
                break;
        }
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
        Log.d("print", "----点击111111-");

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

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK) {
            if (data != null) {
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                Log.d("print", "------------返回" + city);
                showLoading();
                List<String> city1 = adapter.getCity();
                Log.d("print", "------------city1----" + city1);
                if(city1.size()==0||city1==null){
                    if (NetworkUtil.isNetworkConnected(this)) {
                        presenter.addCity(city);
                        presenter.refresh();
                        SharedUtil.putString("cityNum",adapter.getCity().size()+"");
                        Log.d("print", "------------成功" + city);
                    } else {
                        showToast("请检查网络是否正常！");
                        Log.d("print", "------------失败" + city);
                    }
                }else {
                    if (city1.size() >= 0 && city1 != null) {
                        for (int i = 0; i < city1.size(); i++) {
                            if (city1.get(i).equals(city)) {
                                showToast("该城市已收藏！");
                                Log.d("print", "------------存在" + city);
                                stopLoading();
                                return;
                            }
                        }
                    }

                    if (NetworkUtil.isNetworkConnected(this)) {
                        presenter.addCity(city);
                        Log.d("print","大于0----不存在----");
                        adapter.addCity(city);
                        SharedUtil.putString("cityNum",adapter.getCity().size()+"");
                        Log.d("print", "------------成功" + city);
                    } else {
                        showToast("请检查网络是否正常！");
                        Log.d("print", "------------失败" + city);
                    }

                }
                stopLoading();
            }

        }

    }
}
