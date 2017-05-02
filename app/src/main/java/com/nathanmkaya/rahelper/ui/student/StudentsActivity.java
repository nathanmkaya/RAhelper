package com.nathanmkaya.rahelper.ui.student;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.nathanmkaya.rahelper.R;
import com.nathanmkaya.rahelper.model.Student;
import com.nathanmkaya.rahelper.ui.BaseActivity;
import com.nathanmkaya.rahelper.ui.custom.ClickListener;
import com.nathanmkaya.rahelper.utils.DbReference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StudentsActivity extends BaseActivity {

    @BindView(R.id.student_list)
    RecyclerView studentList;
    //@BindView(R.id.fab)FloatingActionButton fab;

    FirebaseRecyclerAdapter<Student, StudentHolder> recyclerAdapter;
    DatabaseReference students = DbReference.students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        //setContent(R.layout.activity_students);
        ButterKnife.bind(this);

        fab.setImageResource(R.drawable.student_add);
        fab.setVisibility(View.VISIBLE);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*FragmentManager fragmentManager = getSupportFragmentManager();
                AddStudent addStudent = new AddStudent();
                addStudent.show(fragmentManager, "add_student");*/
                startActivity(new Intent(getBaseContext(), AddStudentActivity.class));
                //fillDatabase();

            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        layoutManager.scrollToPosition(0);
        studentList.setLayoutManager(layoutManager);

        recyclerAdapter = new FirebaseRecyclerAdapter<Student, StudentHolder>(Student.class, R.layout.student, StudentHolder.class, students) {
            @Override
            protected void populateViewHolder(StudentHolder studentHolder, Student student, int i) {

                Glide.with(StudentsActivity.this)
                        .load(student.img)
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .into(studentHolder.studentImg);
                //studentHolder.studentImg.setImageURI(Uri.parse(student.img));
                studentHolder.studentName.setText(student.name);
                studentHolder.studentRegNo.setText(student.regNo);
                studentHolder.studentRoomNo.setText(student.room);
                studentHolder.studentNoDevice.setText(student.devices.size() != 0 ? String.valueOf(student.devices.size()) : String.valueOf(0));
            }

            @Override
            public StudentHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                StudentHolder holder = super.onCreateViewHolder(parent, viewType);
                holder.setOnClickListener(new ClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(StudentsActivity.this, "Item clicked at" + position, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {
                        Toast.makeText(StudentsActivity.this, "Item long clicked at" + position, Toast.LENGTH_SHORT).show();
                    }
                });
                return holder;
            }
        };
        studentList.setAdapter(recyclerAdapter);
    }

    private void fillDatabase() {
        for (int i = 0; i < 5; i++) {
            Student student = new Student("test" + i, "14-186" + i, String.valueOf(i), "img" + i);
            /*Map<String, Object> postValues = student.toMap();
            Map<String, Object> childUpdates = new HashMap<>();
            childUpdates.put("test" + i, postValues);*/
            students.push().setValue(student);
        }
    }
}
