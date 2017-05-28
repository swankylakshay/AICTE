package com.knock.ashu.aicteandroid.fragments;

import android.widget.Button;

import com.knock.ashu.aicteandroid.LoginActivity;
import com.knock.ashu.aicteandroid.R;
import com.knock.ashu.aicteandroid.SignUpActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Ashu on 1/3/2017.
 */

public class LoginPromptFragment extends AicteFragment {

    public LoginPromptFragment() {
    }

    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_signup)
    Button btnSignUp;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_login_prompt;
    }

    public static LoginPromptFragment newInstance() {
        return new LoginPromptFragment();
    }

    @OnClick(R.id.btn_login)
    public void openLoginActivity() {
        startActivity(LoginActivity.newIntent(getContext()));
    }

    @OnClick(R.id.btn_signup)
    public void openSignUpActivity() {
        startActivity(SignUpActivity.newIntent(getContext()));
    }
}
