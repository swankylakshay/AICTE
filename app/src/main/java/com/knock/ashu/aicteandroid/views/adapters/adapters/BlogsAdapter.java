package com.knock.ashu.aicteandroid.views.adapters.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.knock.ashu.aicteandroid.R;
import com.knock.ashu.aicteandroid.models.Blog;
import com.knock.ashu.aicteandroid.models.BlogList;
import com.knock.ashu.aicteandroid.views.adapters.BlogViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashu on 1/3/2017.
 */

public class BlogsAdapter extends RecyclerView.Adapter<BlogViewHolder> {

    private List<Blog> mList = new ArrayList<>();

    @Override
    public BlogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.cell_blog, null);
        return new BlogViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BlogViewHolder holder, int position) {
        holder.setItemsToViews(mList.get(position));
    }

    @Override
    public int getItemCount() {
        if (mList.size() > 0) {
            Log.d("getItemCount", "getItemCount: " + mList.size());
            return mList.size();
        } else
            return 0;
    }

    public void setBlogs(BlogList list) {
        mList = list.getData();
        notifyDataSetChanged();
    }
}
