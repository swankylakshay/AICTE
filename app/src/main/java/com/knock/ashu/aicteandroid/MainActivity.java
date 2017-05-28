package com.knock.ashu.aicteandroid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.knock.ashu.aicteandroid.fragments.MainFragment;

/**
 * Created by Ashu on 1/3/2017.
 */

public class MainActivity extends SingleFragmentActivity {

    MainFragment mainFragment;

    @Override
    protected Fragment createFragment() {
        return MainFragment.newInstance();
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onBackPressed() {
        if (mainFragment == null || !mainFragment.isAdded() || !mainFragment.deselectIfSelected()) {
            super.onBackPressed();
        }
    }
}
