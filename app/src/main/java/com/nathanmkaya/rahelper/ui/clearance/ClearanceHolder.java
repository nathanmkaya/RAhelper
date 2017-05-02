package com.nathanmkaya.rahelper.ui.clearance;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nathanmkaya.rahelper.R;
import com.nathanmkaya.rahelper.ui.custom.ClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nathan on 4/13/17.
 */

public class ClearanceHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.student_img)
    public ImageView studentImg;
    @BindView(R.id.student_name_txt)
    public TextView studentName;
    @BindView(R.id.student_regno_txt)
    public TextView studentRegNo;
    @BindView(R.id.student_room_txt)
    public TextView studentRoom;
    @BindView(R.id.student_status)
    public TextView studentStatus;

    private ClickListener clickListener;

    public ClearanceHolder(View itemView) {
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
