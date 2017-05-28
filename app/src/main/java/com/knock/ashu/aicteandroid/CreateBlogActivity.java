package com.knock.ashu.aicteandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.knock.ashu.aicteandroid.fragments.CreateBlogFragment;

/**
 * Created by Ashu on 1/3/2017.
 */

public class CreateBlogActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return CreateBlogFragment.newInstance();
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, CreateBlogActivity.class);
    }
}
