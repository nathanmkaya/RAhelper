package com.nathanmkaya.rahelper.ui.maintenance;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.nathanmkaya.rahelper.R;
import com.nathanmkaya.rahelper.model.Maintenance;
import com.nathanmkaya.rahelper.ui.custom.ClickListener;
import com.nathanmkaya.rahelper.utils.DbReference;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.nathanmkaya.rahelper.ui.UIUtils.showMenu;

/**
 * A simple {@link Fragment} subclass.
 */
public class MaintenanceFragment extends Fragment {

    @BindView(R.id.pending_maintenance)
    RecyclerView MaintenanceList;

    FirebaseRecyclerAdapter<Maintenance, IssueHolder> recyclerAdapter;
    DatabaseReference issues = DbReference.maintenance;

    public MaintenanceFragment() {
        // Required empty public constructor
    }

    public static MaintenanceFragment newInstance(boolean mode) {
        MaintenanceFragment fragment = new MaintenanceFragment();
        Bundle args = new Bundle();
        //args.putString("MODE", mode);
        args.putBoolean("fixed", mode);
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
        MaintenanceList.setLayoutManager(layoutManager);

        Query fixed = issues.orderByChild("fixed").equalTo(getArguments().getBoolean("fixed"));

        recyclerAdapter = new FirebaseRecyclerAdapter<Maintenance, IssueHolder>(Maintenance.class, R.layout.issue, IssueHolder.class, fixed) {
            @Override
            protected void populateViewHolder(IssueHolder issueHolder, Maintenance maintenance, int i) {
                issueHolder.datePostedTxt.setText(String.valueOf(maintenance.datePosted));
                issueHolder.hostelTxt.setText(maintenance.hostel);
                issueHolder.wingTxt.setText(maintenance.wing);
                issueHolder.issueTxt.setText(maintenance.issue);

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
                        showMenu(getActivity(), view, R.menu.maintenance, item -> {
                            switch (item.getItemId()) {
                                case R.id.delete_maintenance:
                                    getRef(position).removeValue();
                                    return true;
                                case R.id.fixed_maintenance:
                                    getRef(position).child("fixed").setValue(true);
                                    return true;
                                default:
                                    return false;
                            }
                        });
                        view.setSelected(true);
                    }
                });

                return holder;
            }

            @Override
            protected Maintenance parseSnapshot(DataSnapshot snapshot) {
                return super.parseSnapshot(snapshot);
            }
        };
        MaintenanceList.setAdapter(recyclerAdapter);
        //fillDatabase();
        return view;
    }

    private void fillDatabase() {
        Date date = new Date();
        for (int i = 0; i < 5; i++) {
            Maintenance maintenance = new Maintenance("hostel" + i, "wing" + i, "issue" + i);
            issues.push().setValue(maintenance);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (recyclerAdapter != null) {
            recyclerAdapter.cleanup();
        }
    }
}
