package com.jackshi.androidxkotlinflycotablayout.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.flyco.tablayout.listener.OnTabSelectListener
import com.jackshi.androidxkotlinflycotablayout.R
import com.jackshi.androidxkotlinflycotablayout.utils.MyPagerAdapter
import com.jackshi.androidxkotlinflycotablayout.utils.MyPagerAdapter2
import kotlinx.android.synthetic.main.fragment_home.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment(), OnTabSelectListener {
    private var param1: String? = null
    private var param2: String? = null
    var mTitles = arrayOf("关注", "推荐", "热榜", "视频")
    var mListFragment: ArrayList<Fragment> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("bqt","onCreate")
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d("bqt","onActivityCreated")
//        initData()
    }

    private fun initData() {
        for (i in mTitles.indices) {
            when (i) {
                0 -> {
                    val firstFragment = FirstFragment.newInstance(mTitles[i], mTitles[i])
                    mListFragment.add(firstFragment)
                }
                1 -> {
                    val twoFragment = TwoFragment.newInstance(mTitles[i], mTitles[i])
                    mListFragment.add(twoFragment)
                }
                2 -> {
                    val threeFragment = ThreeFragment.newInstance(mTitles[i], mTitles[i])
                    mListFragment.add(threeFragment)
                }
                else -> {
                    val fourFragment = FourFragment.newInstance(mTitles[i], mTitles[i])
                    mListFragment.add(fourFragment)
                }
            }
        }
        fragment_home_viewpager.adapter =
            MyPagerAdapter2(activity!!.supportFragmentManager, mListFragment, mTitles)
        fragment_home_viewpager.currentItem = 0
        fragment_home_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                fragment_home_viewpager.currentItem = position
            }
        })
        fragment_home_stLayout.setViewPager(fragment_home_viewpager)
        fragment_home_stLayout.setOnTabSelectListener(this)
    }

    override fun onTabSelect(position: Int) {
    }

    override fun onTabReselect(position: Int) {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("bqt","onDestroyView")
    }
}