package com.nathanmkaya.rahelper.ui.news;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nathanmkaya.rahelper.R;
import com.nathanmkaya.rahelper.ui.custom.ClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nathan on 4/4/17.
 */

public class NewsHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.title_txt)
    TextView titleTxt;
    @BindView(R.id.body_txt)
    TextView bodyTxt;
    @BindView(R.id.from_txt)
    TextView fromTxt;
    @BindView(R.id.date_txt)
    TextView dateTxt;

    private ClickListener clickListener;

    public NewsHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(v, getAdapterPosition());
            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                clickListener.onItemLongClick(v, getAdapterPosition());
                return true;
            }
        });
    }

    public void setOnClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }
}
