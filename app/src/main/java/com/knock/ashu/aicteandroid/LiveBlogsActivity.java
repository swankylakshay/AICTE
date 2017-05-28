package com.knock.ashu.aicteandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.knock.ashu.aicteandroid.fragments.ReadBlogsFragment;

/**
 * Created by Ashu on 1/9/2017.
 */

public class LiveBlogsActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return ReadBlogsFragment.newInstance();
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, LiveBlogsActivity.class);
    }

}
