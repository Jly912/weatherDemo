package com.jal.presenter;

import android.content.Context;

import com.google.gson.Gson;
import com.jal.contract.RegisterContract;

/**
 * Created by SEELE on 2017/4/17.
 */

public class RegisterPresenter implements RegisterContract.Presenter {

    private RegisterContract.View view;

    private Gson gson=new Gson();

    private Context context;

    public RegisterPresenter(Context context,RegisterContract.View view){
        this.context=context;
        this.view=view;
    }

    @Override
    public void startRegist() {

    }

}
