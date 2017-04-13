package com.nathanmkaya.rahelper.ui.clearance;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by nathan on 4/3/17.
 */

public class ClearancePagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public ClearancePagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "Not Cleared";
            case 1:
                return "Cleared";
            default:
                return super.getPageTitle(position);
        }
    }
}
