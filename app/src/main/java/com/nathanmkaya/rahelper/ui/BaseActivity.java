package com.nathanmkaya.rahelper.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.nathanmkaya.rahelper.R;
import com.nathanmkaya.rahelper.ui.clearance.ClearanceActivity;
import com.nathanmkaya.rahelper.ui.device.DevicesActivity;
import com.nathanmkaya.rahelper.ui.maintenance.MaintenanceActivity;
import com.nathanmkaya.rahelper.ui.news.NewsActivity;
import com.nathanmkaya.rahelper.ui.student.StudentsActivity;

import butterknife.BindView;

public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.fab)
    public FloatingActionButton fab;
    @BindView(R.id.nav_view_bottom)NavigationView bottomNavigation;
    @BindView(R.id.nav_view_top)NavigationView topNavigation;
    @BindView(R.id.drawer_layout)DrawerLayout drawer;
    @BindView(R.id.toolbar)Toolbar toolbar;
    @BindView(R.id.content)
    FrameLayout content;

    public void setContent(int layoutResID) {

        //content.addView(getLayoutInflater().inflate(layoutResID, null));
        getLayoutInflater().inflate(layoutResID, content, true);

    }

    @Override
    public void setContentView(int layoutResID) {
        View root = getLayoutInflater().inflate(R.layout.activity_main, null);
        FrameLayout contentView = (FrameLayout) root.findViewById(R.id.content);
        contentView.addView(getLayoutInflater().inflate(layoutResID, null));
        super.setContentView(root);
        //ButterKnife.bind(root);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        setSupportActionBar(toolbar);

        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        topNavigation.setNavigationItemSelectedListener(topListener());
        bottomNavigation.setNavigationItemSelectedListener(bottomListener());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //super.setContentView(R.layout.activity_main);


    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public NavigationView.OnNavigationItemSelectedListener topListener(){
        return new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.nav_students:
                        startActivity(new Intent(BaseActivity.this, StudentsActivity.class));
                        break;
                    case R.id.nav_devices:
                        startActivity(new Intent(BaseActivity.this, DevicesActivity.class));
                        break;
                    case R.id.nav_maintenance:
                        startActivity(new Intent(BaseActivity.this, MaintenanceActivity.class));
                        break;
                    case R.id.nav_news:
                        startActivity(new Intent(BaseActivity.this, NewsActivity.class));
                        break;
                    case R.id.nav_clearance:
                        startActivity(new Intent(BaseActivity.this, ClearanceActivity.class));
                        break;
                    default:
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        };
    }

    public NavigationView.OnNavigationItemSelectedListener bottomListener(){
        return new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    default:
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        };
    }
}
