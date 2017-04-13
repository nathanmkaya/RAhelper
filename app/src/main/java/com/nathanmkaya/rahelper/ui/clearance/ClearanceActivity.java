package com.nathanmkaya.rahelper.ui.clearance;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.nathanmkaya.rahelper.R;
import com.nathanmkaya.rahelper.ui.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClearanceActivity extends BaseActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clearance);
        ButterKnife.bind(this);

        List<Fragment> fragments = getFragments();
        FragmentPagerAdapter pagerAdapter = new ClearancePagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private List<Fragment> getFragments() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(ClearanceFragment.newInstance("not_cleared"));
        fragmentList.add(ClearanceFragment.newInstance("cleared"));
        return fragmentList;
    }
}
