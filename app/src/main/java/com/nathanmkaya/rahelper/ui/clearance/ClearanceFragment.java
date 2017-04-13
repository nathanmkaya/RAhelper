package com.nathanmkaya.rahelper.ui.clearance;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.nathanmkaya.rahelper.R;
import com.nathanmkaya.rahelper.model.Student;
import com.nathanmkaya.rahelper.ui.custom.ClickListener;
import com.nathanmkaya.rahelper.utils.DbReference;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClearanceFragment extends Fragment {

    @BindView(R.id.clearance_list)
    RecyclerView clearanceList;
    FirebaseRecyclerAdapter<Student, ClearanceHolder> recyclerAdapter;

    public ClearanceFragment() {
        // Required empty public constructor
    }

    public static ClearanceFragment newInstance(String mode) {
        ClearanceFragment fragment = new ClearanceFragment();
        Bundle args = new Bundle();
        args.putString("MODE", mode);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_clearance, container, false);
        ButterKnife.bind(this, view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        layoutManager.scrollToPosition(0);
        clearanceList.setLayoutManager(layoutManager);

        recyclerAdapter = new FirebaseRecyclerAdapter<Student, ClearanceHolder>(Student.class, R.layout.student, ClearanceHolder.class, DbReference.students) {
            @Override
            protected void populateViewHolder(ClearanceHolder clearanceHolder, Student student, int i) {

            }

            @Override
            public ClearanceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                ClearanceHolder holder = super.onCreateViewHolder(parent, viewType);
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
