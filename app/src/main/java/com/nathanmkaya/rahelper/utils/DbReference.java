package com.nathanmkaya.rahelper.utils;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DbReference {

    public static FirebaseDatabase root = FirebaseDatabase.getInstance();
    public static DatabaseReference students = root.getReference("students");
    public static DatabaseReference devices  = root.getReference("devices");
    public static DatabaseReference clearance = root.getReference("clearance");
    public static DatabaseReference maintenance = root.getReference("maintenance");
    public static DatabaseReference news = root.getReference("news");

    public static void initialize(){

    }

    public static void keepSynced(boolean condition){
        students.keepSynced(condition);
        devices.keepSynced(condition);
        clearance.keepSynced(condition);
        maintenance.keepSynced(condition);
        news.keepSynced(condition);
    }
}
