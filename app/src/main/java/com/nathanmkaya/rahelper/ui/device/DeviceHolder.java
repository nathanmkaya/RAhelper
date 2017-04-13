package com.nathanmkaya.rahelper.ui.device;

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

public class DeviceHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.type_txt)
    TextView typeTxt;
    @BindView(R.id.make_txt)
    TextView makeTxt;
    @BindView(R.id.serial_txt)
    TextView serialTxt;
    private ClickListener clickListener;

    public DeviceHolder(View itemView) {
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
