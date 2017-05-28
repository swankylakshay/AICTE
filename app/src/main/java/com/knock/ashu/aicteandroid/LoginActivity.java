package com.knock.ashu.aicteandroid;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.knock.ashu.aicteandroid.fragments.LoginFragment;

/**
 * Created by Ashu on 1/2/2017.
 */

public class LoginActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return LoginFragment.newInstance();
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, LoginActivity.class);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActionBarProperties(getResources().getString(R.string.login), getResources().getColor(R.color.blue));
    }
}
