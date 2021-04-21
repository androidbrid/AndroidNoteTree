package com.jackshi.androidjavatabhostfordesign.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.MenuItem;

import java.util.ArrayList;

public class MyPagerAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> mList;
    MenuItem mMenuItem;
    public MyPagerAdapter(FragmentManager fm, ArrayList<Fragment> list, MenuItem menuItem) {
        super(fm);
        this.mList=list;
        this.mMenuItem=menuItem;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mMenuItem.getTitle();
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }
}
