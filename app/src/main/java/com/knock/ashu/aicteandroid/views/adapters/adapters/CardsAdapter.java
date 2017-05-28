package com.knock.ashu.aicteandroid.views.adapters.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.knock.ashu.aicteandroid.R;
import com.knock.ashu.aicteandroid.models.Card;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ashu on 1/3/2017.
 */

public class CardsAdapter extends RecyclerView.Adapter<CardsAdapter.CardsViewHolder> {

    private OnItemClickListener itemClickListener;
    private View view;
    private ArrayList<Card> mList;

    @Override
    public CardsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.cell_card, null);
        return new CardsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CardsViewHolder holder, int position) {
        holder.setDataToViews(mList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClicked(holder.getAdapterPosition(), holder.ivPreview);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mList.size() > 0) {
            return mList.size();
        }
        return 0;
    }


    public void setItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }


    public void setCards(ArrayList<Card> list) {
        mList = list;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClicked(int pos, View view);
    }


    public class CardsViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.cv_cards)
        CardView cvCards;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_subtitle)
        TextView tvSubtitle;
        @BindView(R.id.iv_preview)
        ImageView ivPreview;

        public CardsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setDataToViews(Card card) {
            tvTitle.setText(card.getTitle());
            tvSubtitle.setText(card.getSubtitle());
            Picasso.with(itemView.getContext()).load(card.getImage()).into(ivPreview);
            cvCards.setCardBackgroundColor(card.getBackground());
            cvCards.setBackgroundColor(card.getBackground());
        }
    }


}
