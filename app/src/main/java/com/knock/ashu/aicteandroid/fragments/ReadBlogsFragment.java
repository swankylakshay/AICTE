package com.knock.ashu.aicteandroid.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.knock.ashu.aicteandroid.R;
import com.knock.ashu.aicteandroid.models.Blog;
import com.knock.ashu.aicteandroid.models.BlogList;
import com.knock.ashu.aicteandroid.network.aicte.ApiClient;
import com.knock.ashu.aicteandroid.views.adapters.adapters.BlogsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Ashu on 1/3/2017.
 */

public class ReadBlogsFragment extends AicteFragment {

    @BindView(R.id.rv_blogs)
    RecyclerView rvBlogs;

    private BlogsAdapter mAdapter;

    public ReadBlogsFragment() {
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_read_blogs;
    }

    public static ReadBlogsFragment newInstance() {
        return new ReadBlogsFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView.LayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(getContext());
        rvBlogs.setLayoutManager(layoutManager);
        mAdapter = new BlogsAdapter();
        rvBlogs.setAdapter(mAdapter);

        ApiClient.getClient().readBlogs().enqueue(new ApiClient.Callback<BlogList>() {
            @Override
            public void success(BlogList response) {
                Toast.makeText(getContext(), "success", Toast.LENGTH_SHORT).show();
                mAdapter.setBlogs(response);
            }

            @Override
            public void failure(Error error) {
                Toast.makeText(getContext(), "failure", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
