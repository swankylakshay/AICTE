package com.knock.ashu.aicteandroid.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.knock.ashu.aicteandroid.MainActivity;
import com.knock.ashu.aicteandroid.R;
import com.knock.ashu.aicteandroid.models.User;
import com.knock.ashu.aicteandroid.network.aicte.ApiClient;
import com.knock.ashu.aicteandroid.utils.Loader;
import com.knock.ashu.aicteandroid.utils.ValidationListener;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Ashu on 1/2/2017.
 */

public class LoginFragment extends AicteFragment {

    protected Validator validator;

    @NotEmpty
    @Email
    @BindView(R.id.et_email)
    EditText etEmail;
    @NotEmpty
    @Password(min = 6)
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.button_login)
    Button btnLogin;

    public LoginFragment() {
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_login;
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        validator = new Validator(this);

        validator.setValidationListener(new ValidationListener() {

            @Override
            public Context getContext() {
                return getActivity();
            }

            @Override
            public void onValidationSucceeded() {

                final Loader progressLoader = new Loader(getContext());
                progressLoader.setText(getString(R.string.please_wait));
                progressLoader.setWindowColor(getResources().getColor(R.color.background_dialog));
                progressLoader.show();

                String email = getStringFromEditText(etEmail);
                String password = getStringFromEditText(etPassword);
                ApiClient.getClient().login(email, password).enqueue(new ApiClient.Callback<User>() {
                    @Override
                    public void success(User response) {
                        progressLoader.success();
                        if (response.getSuccess()) {
                            Toast.makeText(getContext(), "You have logged in successfully", Toast.LENGTH_SHORT).show();
                            startActivity(MainActivity.newIntent(getContext()));
                        }
                        Toast.makeText(getContext(), "error: " + "email or password is not valid", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void failure(Error error) {
                        progressLoader.error();
                        Toast.makeText(getContext(), "error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }

    @OnClick(R.id.button_login)
    public void login() {
        validator.validate();
        hideKeyboard(getActivity());
    }
}
