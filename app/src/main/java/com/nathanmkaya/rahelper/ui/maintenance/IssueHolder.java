package com.nathanmkaya.rahelper.ui.maintenance;

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

public class IssueHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.hostel_txt)
    TextView hostelTxt;
    @BindView(R.id.wing_txt)
    TextView wingTxt;
    @BindView(R.id.date_posted_txt)
    TextView datePostedTxt;
    @BindView(R.id.date_fixed_txt)
    TextView dateFixedTxt;
    @BindView(R.id.issueTxt)
    TextView issueTxt;

    private ClickListener clickListener;

    public IssueHolder(View itemView) {
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
