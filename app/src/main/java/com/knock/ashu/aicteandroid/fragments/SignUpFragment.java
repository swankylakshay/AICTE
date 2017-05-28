package com.knock.ashu.aicteandroid.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.knock.ashu.aicteandroid.LoginActivity;
import com.knock.ashu.aicteandroid.R;
import com.knock.ashu.aicteandroid.models.User;
import com.knock.ashu.aicteandroid.network.aicte.ApiClient;
import com.knock.ashu.aicteandroid.utils.Loader;
import com.knock.ashu.aicteandroid.utils.ValidationListener;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Ashu on 1/2/2017.
 */

public class SignUpFragment extends AicteFragment {

    @NotEmpty
    @BindView(R.id.edittext_fullname)
    EditText etFullName;
    @NotEmpty
    @Email
    @BindView(R.id.et_email)
    EditText etEmailSignUp;
    @NotEmpty
    @Password(min = 6)
    @BindView(R.id.et_password)
    EditText etPasswordSignUp;

    @BindView(R.id.radio_button_signup_agreement)
    RadioButton mAgreeToTermsButton;

    protected Validator validator;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_signup;
    }

    public static SignUpFragment newInstance() {
        return new SignUpFragment();
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

                String email = getStringFromEditText(etEmailSignUp);
                String password = getStringFromEditText(etPasswordSignUp);
                String fullname = getStringFromEditText(etFullName);

                ApiClient.getClient().signUp(email, fullname, password).enqueue(new ApiClient.Callback<User>() {
                    @Override
                    public void success(User response) {
                        progressLoader.success();
                        Toast.makeText(getContext(), "Your account has been created", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getContext(), "Login to your account", Toast.LENGTH_SHORT).show();
                        startActivity(LoginActivity.newIntent(getContext()));
                    }

                    @Override
                    public void failure(Error error) {
                        progressLoader.error();
                        Toast.makeText(getContext(), "some error occured", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }


    @OnClick(R.id.button_create_new_account)
    public void onCreateNewAccountClick() {
        validator.validate();
        hideKeyboard(getActivity());
    }


    @OnClick(R.id.button_facebook_sign_up)
    public void onFaceBookSignUpClick() {

    }
}
