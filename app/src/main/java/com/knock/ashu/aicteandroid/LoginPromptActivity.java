package com.knock.ashu.aicteandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.knock.ashu.aicteandroid.fragments.LoginPromptFragment;

public class LoginPromptActivity extends SingleFragmentActivity {


    public static Intent newIntent(Context context) {
        return new Intent(context, LoginPromptActivity.class);
    }


    @Override
    protected Fragment createFragment() {
        return LoginPromptFragment.newInstance();
    }
}
