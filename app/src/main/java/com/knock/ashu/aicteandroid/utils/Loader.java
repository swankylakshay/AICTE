package com.knock.ashu.aicteandroid.utils;

/**
 * Created by Ashu on 1/3/2017.
 */

import android.content.Context;

import com.kaopiz.kprogresshud.KProgressHUD;
import com.knock.ashu.aicteandroid.R;

/**
 * Created by Hemant Saini on 27-12-2016.
 */

public class Loader extends KProgressHUD {
    public Loader(Context context) {
        super(context);
        this.setStyle(Style.SPIN_INDETERMINATE)
                .setCancellable(false)
                .setDimAmount(0.5f)
                .setAnimationSpeed(2).setWindowColor(context.getResources().getColor(R.color.gray_very_light));
    }

    public void setText(String message) {
        this.setLabel(message);
    }

    public void success() {
        this.dismiss();
    }

    public void error() {
        this.dismiss();
    }
}