package com.jackshi.androidxkotlinflycotablayout.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPagerAdapter2(
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
//        return if(position>mStrList.size-1){
//            mStrList[position-1]
//        }else{
        return mStrList[position]
//        }
    }

    override fun getItem(position: Int): Fragment {
        return mList[position]
    }

    override fun getCount(): Int {
        return mList.size
    }
}