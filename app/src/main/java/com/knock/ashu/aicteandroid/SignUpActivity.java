package com.knock.ashu.aicteandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;

import com.knock.ashu.aicteandroid.fragments.SignUpFragment;

/**
 * Created by Ashu on 1/2/2017.
 */

public class SignUpActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return SignUpFragment.newInstance();
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, SignUpActivity.class);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActionBarProperties(getResources().getString(R.string.signup),getResources().getColor(R.color.blue));
    }
}
