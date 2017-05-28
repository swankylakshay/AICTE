package com.knock.ashu.aicteandroid.views.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.knock.ashu.aicteandroid.R;
import com.knock.ashu.aicteandroid.models.Blog;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ashu on 1/3/2017.
 */

public class BlogViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_title_blogs)
    TextView tvTitle;
    @BindView(R.id.tv_description_blog)
    TextView tvDescription;
    @BindView(R.id.iv_blog_image)
    ImageView ivBlog;

    public BlogViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setItemsToViews(Blog blog) {
        tvTitle.setText(""+blog.getTitle());
        tvDescription.setText(""+blog.getDescription());
        Picasso.with(itemView.getContext()).load(blog.getImage()).into(ivBlog);
    }
}
