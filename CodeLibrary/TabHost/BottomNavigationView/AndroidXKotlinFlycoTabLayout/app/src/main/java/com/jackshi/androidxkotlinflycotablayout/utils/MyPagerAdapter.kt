package com.jackshi.androidxkotlinflycotablayout.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPagerAdapter(
    fm: FragmentManager,
    list: ArrayList<Fragment>,
    strList: Array<String>
) : FragmentPagerAdapter(fm) {
    private var mList: ArrayList<Fragment> = ArrayList()
    private var mStrList: Array<String>

    init {
        mList = list
        mStrList = strList
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mStrList[position]
    }

    override fun getItem(position: Int): Fragment {
        return mList[position]
    }

    override fun getCount(): Int {
        return mList.size
    }
}