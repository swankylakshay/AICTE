package com.knock.ashu.aicteandroid.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.knock.ashu.aicteandroid.R;
import com.knock.ashu.aicteandroid.models.Blog;
import com.knock.ashu.aicteandroid.models.User;
import com.knock.ashu.aicteandroid.network.aicte.ApiClient;
import com.knock.ashu.aicteandroid.utils.Loader;
import com.knock.ashu.aicteandroid.utils.ValidationListener;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Ashu on 1/3/2017.
 */

public class CreateBlogFragment extends AicteFragment {

    @NotEmpty
    @BindView(R.id.et_title)
    EditText etTitle;

    @NotEmpty
    @BindView(R.id.et_description)
    EditText etDescription;

    @NotEmpty
    @BindView(R.id.et_image)
    EditText etImage;

    @BindView(R.id.btn_create_blog)
    Button btnCreateBlog;

    private String title;
    private String description;
    private String image;


    protected Validator validator;

    public CreateBlogFragment() {
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_create_blog;
    }

    public static CreateBlogFragment newInstance() {
        return new CreateBlogFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.btn_create_blog)
    public void createBlog() {
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
                image = getStringFromEditText(etImage);
                title = getStringFromEditText(etTitle);
                description = getStringFromEditText(etDescription);
                ApiClient.getClient().createBlog(title, description, image).enqueue(new ApiClient.Callback<User>() {
                    @Override
                    public void success(User response) {
                        progressLoader.success();
                        Toast.makeText(getContext(), "Blog successfully created", Toast.LENGTH_SHORT).show();
                        getActivity().finish();
                    }

                    @Override
                    public void failure(Error error) {
                        progressLoader.error();
                        Toast.makeText(getContext(), "Some error occured", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
