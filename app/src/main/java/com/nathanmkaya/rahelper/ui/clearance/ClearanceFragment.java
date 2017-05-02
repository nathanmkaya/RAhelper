package com.nathanmkaya.rahelper.ui.clearance;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;
import com.nathanmkaya.rahelper.R;
import com.nathanmkaya.rahelper.model.Student;
import com.nathanmkaya.rahelper.ui.UIUtils;
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

    public static ClearanceFragment newInstance(boolean mode) {
        ClearanceFragment fragment = new ClearanceFragment();
        Bundle args = new Bundle();
        args.putBoolean("cleared", mode);
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
        Query cleared = DbReference.students.orderByChild("cleared").equalTo(getArguments().getBoolean("cleared"));
        recyclerAdapter = new FirebaseRecyclerAdapter<Student, ClearanceHolder>(Student.class, R.layout.clearance, ClearanceHolder.class, cleared) {
            @Override
            protected void populateViewHolder(ClearanceHolder clearanceHolder, Student student, int i) {
                clearanceHolder.studentName.setText(student.name);
                clearanceHolder.studentRegNo.setText(student.regNo);
                clearanceHolder.studentRoom.setText(student.room);
                clearanceHolder.studentStatus.setText(student.cleared ? "Cleared" : "Not Cleared");
                Glide.with(getActivity())
                        .load(student.img)
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .into(clearanceHolder.studentImg);
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
                        UIUtils.showMenu(getActivity(), view, R.menu.clearance, item -> {
                            switch (item.getItemId()) {
                                case R.id.student_cleared:
                                    getRef(position).child("cleared").setValue(true);
                                    return true;
                                default:
                                    return false;
                            }
                        });
                    }
                });
                return holder;
            }
        };
        clearanceList.setAdapter(recyclerAdapter);
        return view;
    }


    @Override
    public void onStop() {
        super.onStop();
        if (recyclerAdapter != null) {
            recyclerAdapter.cleanup();
        }
    }
}
