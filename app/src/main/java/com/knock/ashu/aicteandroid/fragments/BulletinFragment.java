package com.knock.ashu.aicteandroid.fragments;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.knock.ashu.aicteandroid.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import yalantis.com.sidemenu.interfaces.ScreenShotable;

/**
 * Created by Ashu on 1/3/2017.
 */

public class BulletinFragment extends AicteFragment implements ScreenShotable {

    private View containerView;
    private Bitmap bitmap;

    @BindView(R.id.iv_photo_about_us)
    ImageView ivPic;
    @BindView(R.id.tv_full_info_about_us)
    TextView tvInfo;

    public BulletinFragment() {
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_bulletin;
    }

    public static BulletinFragment newInstance() {
        return new BulletinFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.containerView = view.findViewById(R.id.container);
        Picasso.with(getContext()).load(R.drawable.bulletin).into(ivPic);
        tvInfo.setText(getResources().getString(R.string.full_info_bulletin));
    }

    @Override
    public void takeScreenShot() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Bitmap bitmap = Bitmap.createBitmap(containerView.getWidth(),
                        containerView.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);
                containerView.draw(canvas);
                BulletinFragment.this.bitmap = bitmap;
            }
        };

        thread.start();

    }

    @Override
    public Bitmap getBitmap() {
        return bitmap;
    }
}
