package com.jackshi.androidxkotlinbottomnavigationview.utils

import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPagerAdapter(
    fm: FragmentManager,
    list: ArrayList<Fragment>,
    menuItem: MenuItem
) : FragmentPagerAdapter(fm) {
    private var mList: ArrayList<Fragment> = ArrayList()
    private var mMenuItem: MenuItem

    init {
        mList = list
        mMenuItem = menuItem
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mMenuItem.title
    }

    override fun getItem(position: Int): Fragment {
        return mList[position]
    }

    override fun getCount(): Int {
        return mList.size
    }
}