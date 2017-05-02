package com.nathanmkaya.rahelper;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;
import com.nathanmkaya.rahelper.utils.DbReference;


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        DbReference.keepSynced(true);
    }
}
