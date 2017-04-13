package com.nathanmkaya.rahelper.ui.maintenance;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.nathanmkaya.rahelper.R;
import com.nathanmkaya.rahelper.model.Maintenance;
import com.nathanmkaya.rahelper.ui.custom.ClickListener;
import com.nathanmkaya.rahelper.utils.DbReference;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MaintenanceFragment extends Fragment {

    @BindView(R.id.pending_maintenance)
    RecyclerView pendingMaintenance;

    FirebaseRecyclerAdapter<Maintenance, IssueHolder> recyclerAdapter;
    DatabaseReference issues = DbReference.maintenance;

    public MaintenanceFragment() {
        // Required empty public constructor
    }

    public static MaintenanceFragment newInstance(String mode) {
        MaintenanceFragment fragment = new MaintenanceFragment();
        Bundle args = new Bundle();
        args.putString("MODE", mode);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_maintenance, container, false);
        ButterKnife.bind(this, view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        layoutManager.scrollToPosition(0);
        pendingMaintenance.setLayoutManager(layoutManager);

        recyclerAdapter = new FirebaseRecyclerAdapter<Maintenance, IssueHolder>(Maintenance.class, R.layout.issue, IssueHolder.class, issues) {
            @Override
            protected void populateViewHolder(IssueHolder issueHolder, Maintenance maintenance, int i) {

            }

            @Override
            public IssueHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                IssueHolder holder = super.onCreateViewHolder(parent, viewType);
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
        return view;
    }

}
