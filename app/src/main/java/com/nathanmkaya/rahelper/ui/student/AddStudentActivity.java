package com.nathanmkaya.rahelper.ui.student;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.mvc.imagepicker.ImagePicker;
import com.nathanmkaya.rahelper.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddStudentActivity extends AppCompatActivity {

    @BindView(R.id.student_img)
    ImageView studentImg;
    @BindView(R.id.student_name)
    TextInputEditText studentName;
    @BindView(R.id.student_regno)
    TextInputEditText studentRegNo;
    @BindView(R.id.student_room)
    TextInputEditText studentRoom;
    @BindView(R.id.submit_btn)
    Button submitBtn;

    Bitmap img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_student);
        ButterKnife.bind(this);
        setTitle("Add New Student");
        Dexter.withActivity(AddStudentActivity.this)
                .withPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                Toast.makeText(AddStudentActivity.this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                Toast.makeText(AddStudentActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).check();

        studentImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.pickImage(AddStudentActivity.this, "Select Image...");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        img = ImagePicker.getImageFromResult(this, requestCode, resultCode, data);
        studentImg.setImageBitmap(img);

        //System.out.println(file);

    }

    @OnClick(R.id.submit_btn)
    public void Onclick() {
        StudentHelper.addStudent(img, studentName.getText().toString(), studentRegNo.getText().toString(), studentRoom.getText().toString());
        finish();
    }
}
