package com.jal.http;

import android.util.Log;

import com.google.gson.Gson;
import com.jal.bean.LoginInfo;
import com.jal.bean.StartInfo;
import com.jal.bean.WeatherInfoBean;
import com.jal.interfaces.OnDownListener;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by SEELE on 2017/4/17.
 */

public class Http {

    public static void getWeatherInfo(String city, final OnDownListener listener) {
        OkGo.get(String.format(Api.JUHE_WEATHER, city))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Log.d("print", "ssssssss" + s);
                        if (s != null) {
                            WeatherInfoBean weatherInfoBean = new Gson().fromJson(s, WeatherInfoBean.class);
                            listener.downSucc(weatherInfoBean);
                        } else {
                            listener.downFilded();
                        }
                    }
                });

    }

    public static void getStarInfo(String name, final OnDownListener listener) {
        OkGo.get(String.format(Api.STAR_INFO, name))
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        if (s != null) {
                            StartInfo startInfo = new Gson().fromJson(s, StartInfo.class);
                            listener.downSucc(startInfo);
                        } else {
                            listener.downFilded();
                        }
                    }
                });
    }

    public static void getLogin(String name, String pwd, final OnDownListener listener) {

        String url = String.format(Api.LOGIN, name, pwd, "login");
        Log.d("print", "params" + name + pwd + "url" + url);

        OkGo.get(url)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        Log.d("print", "00000000000" + s);
                        if (s != null) {
                            LoginInfo loginInfo = new Gson().fromJson(s, LoginInfo.class);
                            listener.downSucc(loginInfo);
                        } else {
                            listener.downFilded();
                        }
                    }
                });

    }

    public static void delCity(String name, String pwd, String city, final OnDownListener listener) {
        String url = String.format(Api.REMOVE, name, pwd, city);

        OkGo.get(url)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {

                        Log.d("print", "delUrl+ssss========" + s);
                        if (s != null) {
                            try {
                                JSONObject object = new JSONObject(s);
                                int code = object.getInt("code");
                                Log.d("print", "delUrl+code========" + code);
                                listener.downSucc(code);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        } else {
                            listener.downFilded();
                        }
                    }
                });
    }

    public static void addCity(String name, String pwd, String city, final OnDownListener listener) {
        String url = String.format(Api.INSERT_CITY, name, pwd, city);
        Log.d("print", "addUrl+========" + url);
        OkGo.get(url)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Log.d("print", "addUrl+=====sss===" + s);
                        if (s != null) {
                            try {
                                JSONObject object = new JSONObject(s);
                                int code = object.getInt("code");
                                Log.d("print", "addUrl+=====code===" + s);
                                listener.downSucc(code);
                            } catch (JSONException e) {
                                e.printStackTrace();
                                listener.downFilded();
                            }

                        } else {
                            listener.downFilded();
                        }
                    }
                });

    }

    public static void registerUser(String name, String pwd, final OnDownListener listener) {
        String url = String.format(Api.REGIST, name, pwd);

        OkGo.get(url)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        Log.d("print","----shujuku-----code"+s);
                        if (s != null) {
                            try {
                                JSONObject object = new JSONObject(s);
                                int code = object.getInt("code");
                                switch (code) {
                                    case 0:
                                        //注册成功
                                        listener.downSucc(code);
                                        break;
                                    case 2:
                                        Log.d("print",code+"----shujuku-----code");
                                        //注册失败 数据库失败
                                        listener.downFilded();
                                        break;
                                    case 4:
                                        //用户存在
                                        Log.d("print",code+"----shujuku-----code");
                                        listener.downSucc(code);
                                        break;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                listener.downFilded();
                            }
                        } else {
                            listener.downFilded();
                        }
                    }
                });
    }
}
