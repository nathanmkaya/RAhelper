package com.nathanmkaya.rahelper.ui.device;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.nathanmkaya.rahelper.R;
import com.nathanmkaya.rahelper.model.Device;
import com.nathanmkaya.rahelper.ui.BaseActivity;
import com.nathanmkaya.rahelper.ui.custom.ClickListener;
import com.nathanmkaya.rahelper.utils.DbReference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DevicesActivity extends BaseActivity {

    FirebaseRecyclerAdapter<Device, DeviceHolder> recyclerAdapter;
    @BindView(R.id.device_list)
    RecyclerView deviceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devices);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager.scrollToPosition(0);
        deviceList.setLayoutManager(layoutManager);

        recyclerAdapter = new FirebaseRecyclerAdapter<Device, DeviceHolder>(Device.class, R.layout.device, DeviceHolder.class, DbReference.devices) {
            @Override
            protected void populateViewHolder(DeviceHolder deviceHolder, Device device, int i) {

            }

            @Override
            public DeviceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                DeviceHolder holder = super.onCreateViewHolder(parent, viewType);
                holder.setOnClickListener(new ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemLongClick(View view, int position) {

                    }
                });
                return holder;
            }
        };
        deviceList.setAdapter(recyclerAdapter);
    }
}
