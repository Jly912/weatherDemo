package com.jal.app;

import android.app.Application;
import android.content.Context;

import com.jal.util.SharedUtil;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheEntity;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.cookie.store.PersistentCookieStore;

import java.util.logging.Level;

/**
 * Created by SEELE on 2017/4/13.
 */

public class AppContext extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        SharedUtil.init(this);

        OkGo.init(this);

        try {
            OkGo.getInstance()
                    .debug("OkGo", Level.INFO, true)
                    .setCacheMode(CacheMode.NO_CACHE)
                    .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)
                    .setRetryCount(3)
                    .setCookieStore(new PersistentCookieStore());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Context getContext() {
        return context;
    }
}
