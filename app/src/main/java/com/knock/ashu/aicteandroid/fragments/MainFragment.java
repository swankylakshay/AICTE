package com.knock.ashu.aicteandroid.fragments;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cleveroad.fanlayoutmanager.FanLayoutManager;
import com.cleveroad.fanlayoutmanager.FanLayoutManagerSettings;
import com.cleveroad.fanlayoutmanager.callbacks.FanChildDrawingOrderCallback;
import com.knock.ashu.aicteandroid.BulletinActivity;
import com.knock.ashu.aicteandroid.BureausActivity;
import com.knock.ashu.aicteandroid.CreateBlogActivity;
import com.knock.ashu.aicteandroid.AboutUsActivity;
import com.knock.ashu.aicteandroid.EducationActivity;
import com.knock.ashu.aicteandroid.GrievanceActivity;
import com.knock.ashu.aicteandroid.LiveBlogsActivity;
import com.knock.ashu.aicteandroid.R;
import com.knock.ashu.aicteandroid.ReportsActivity;
import com.knock.ashu.aicteandroid.StatisticsActivity;
import com.knock.ashu.aicteandroid.StudentsActivity;
import com.knock.ashu.aicteandroid.models.Card;
import com.knock.ashu.aicteandroid.views.adapters.adapters.CardsAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Ashu on 1/3/2017.
 */

public class MainFragment extends AicteFragment {

    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.rvCards)
    RecyclerView rvCards;
    @BindView(R.id.btn_blog)

    Button btnBlog;

    private CardsAdapter mAdapter;
    private ArrayList<Card> mList = new ArrayList<>();
    private FanLayoutManager layoutManager;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_main;
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FanLayoutManagerSettings fanLayoutManagerSettings = FanLayoutManagerSettings
                .newBuilder(getContext())
                .withFanRadius(true)
                .withAngleItemBounce(5)
                .withViewWidthDp(150)
                .withViewHeightDp(190)
                .build();
        layoutManager = new FanLayoutManager(getContext(), fanLayoutManagerSettings);
        rvCards.setLayoutManager(layoutManager);
        mAdapter = new CardsAdapter();
        rvCards.setAdapter(mAdapter);
        mAdapter.setCards(setupCards());
        rvCards.setChildDrawingOrderCallback(new FanChildDrawingOrderCallback(layoutManager));
        rvCards.setItemAnimator(new DefaultItemAnimator());
        ivLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layoutManager.collapseViews();
            }
        });
        mAdapter.setItemClickListener(new CardsAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(int pos, final View view) {
                if (layoutManager.getSelectedItemPosition() != pos) {
                    layoutManager.switchItem(rvCards, pos);
                } else {
                    layoutManager.straightenSelectedItem(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animator) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            onClick(layoutManager.getSelectedItemPosition());
                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animator) {

                        }
                    });
                }
            }
        });
    }

    @OnClick(R.id.btn_blog)
    public void openCreationWindow() {
        startActivity(CreateBlogActivity.newIntent(getContext()));
    }

    private ArrayList<Card> setupCards() {
        Card card;

        //ABOUT US CARD
        card = new Card();
        card.setTitle(getResources().getString(R.string.about_us));
        card.setSubtitle(getResources().getString(R.string.about_us_subtitle));
        card.setImage(R.drawable.aboutus);
        card.setBackground(getResources().getColor(R.color.blue));
        mList.add(card);

        //BUREAUS CARD
        card = new Card();
        card.setTitle(getResources().getString(R.string.bureaus));
        card.setSubtitle(getResources().getString(R.string.bureaus_subtitle));
        card.setImage(R.drawable.aicte);
        card.setBackground(getResources().getColor(R.color.orange));
        mList.add(card);

        //GRIEVANCE CARD
        card = new Card();
        card.setTitle(getResources().getString(R.string.grievance));
        card.setSubtitle(getResources().getString(R.string.grievance_subtitle));
        card.setImage(R.drawable.grievance);
        card.setBackground(getResources().getColor(R.color.green));
        mList.add(card);

        //REPORTS CARD
        card = new Card();
        card.setTitle(getResources().getString(R.string.reports));
        card.setSubtitle(getResources().getString(R.string.reports_subtitle));
        card.setImage(R.drawable.ic_logo);
        card.setBackground(getResources().getColor(R.color.yellow));
        mList.add(card);

        //STATISTICS CARD
        card = new Card();
        card.setTitle(getResources().getString(R.string.statistics));
        card.setSubtitle(getResources().getString(R.string.statistics_subtitle));
        card.setImage(R.drawable.ic_logo);
        card.setBackground(getResources().getColor(R.color.red));
        mList.add(card);

        //EDUCATION CARD
        card = new Card();
        card.setTitle(getResources().getString(R.string.education));
        card.setSubtitle(getResources().getString(R.string.education_subtitle));
        card.setImage(R.drawable.education);
        card.setBackground(getResources().getColor(R.color.green));
        mList.add(card);

        //STUDENTS CARD
        card = new Card();
        card.setTitle(getResources().getString(R.string.students));
        card.setSubtitle(getResources().getString(R.string.students_subtitle));
        card.setImage(R.drawable.students);
        card.setBackground(getResources().getColor(R.color.orange));
        mList.add(card);

        //BULLETIN CARD
        card = new Card();
        card.setTitle(getResources().getString(R.string.bulletin));
        card.setSubtitle(getResources().getString(R.string.bulletin_subtitle));
        card.setImage(R.drawable.bulletin);
        card.setBackground(getResources().getColor(R.color.blue_light));
        mList.add(card);

        //BLOG CARD
        card = new Card();
        card.setTitle(getResources().getString(R.string.live_blogs));
        card.setSubtitle(getResources().getString(R.string.live_blogs_subtitle));
        card.setImage(R.drawable.bulletin);
        card.setBackground(getResources().getColor(R.color.green));
        mList.add(card);

        return mList;
    }

    public boolean deselectIfSelected() {
        if (layoutManager.isItemSelected()) {
            layoutManager.deselectItem();
            return true;
        } else {
            return false;
        }
    }

    public void onClick(int pos) {
        if (pos == 0) {
            startActivity(AboutUsActivity.newIntent(getContext()));
        }
        if (pos == 1) {
            startActivity(BureausActivity.newIntent(getContext()));
        }
        if (pos == 2) {
            startActivity(GrievanceActivity.newIntent(getContext()));
        }
        if (pos == 3) {
            startActivity(ReportsActivity.newIntent(getContext()));
        }
        if (pos == 4) {
            startActivity(StatisticsActivity.newIntent(getContext()));
        }
        if (pos == 5) {
            startActivity(EducationActivity.newIntent(getContext()));
        }
        if (pos == 6) {
            startActivity(StudentsActivity.newIntent(getContext()));
        }
        if (pos == 7) {
            startActivity(BulletinActivity.newIntent(getContext()));
        }
        if (pos == 8) {
            startActivity(LiveBlogsActivity.newIntent(getContext()));
        }
    }

}