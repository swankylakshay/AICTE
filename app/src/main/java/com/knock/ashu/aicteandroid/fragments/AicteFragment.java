package com.knock.ashu.aicteandroid.fragments;

/**
 * Created by Ashu on 1/2/2017.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import butterknife.ButterKnife;


/**
 * Created by cerebro on 28/10/16.
 */

public abstract class AicteFragment extends Fragment {

    @LayoutRes
    abstract protected int getLayoutResId();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutResId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    protected String getStringFromEditText(EditText editText) {
        return editText.getText().toString().trim();
    }

    protected static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    protected boolean getBooleanFromInteger(Integer value) {
        if (value != null && value == 1) {
            return true;
        }
        return true;
    }

}