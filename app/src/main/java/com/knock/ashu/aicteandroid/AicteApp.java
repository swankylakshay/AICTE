package com.knock.ashu.aicteandroid;

import android.content.Context;

import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;

/**
 * Created by Ashu on 1/2/2017.
 */

public class AicteApp extends android.app.Application {

    private static final long IMAGE_CACHE_SIZE = 1024 * 1024 * 100; // 100MB
    private static Context sContext;

    public static Context getAppContext() {
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        setupPicassoConfig();
    }

    private void setupPicassoConfig() {
        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttpDownloader(this, IMAGE_CACHE_SIZE));
        Picasso built = builder.build();
        built.setIndicatorsEnabled(false);
        built.setLoggingEnabled(true);
        Picasso.setSingletonInstance(built);
    }

}
