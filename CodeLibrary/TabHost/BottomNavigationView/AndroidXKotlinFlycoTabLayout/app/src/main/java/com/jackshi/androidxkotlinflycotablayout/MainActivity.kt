package com.jackshi.androidxkotlinflycotablayout

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.flyco.tablayout.utils.UnreadMsgUtils
import com.jackshi.androidxkotlinflycotablayout.fragment.*
import com.jackshi.androidxkotlinflycotablayout.utils.MyPagerAdapter
import com.jackshi.androidxkotlinflycotablayout.utils.TabEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnTabSelectListener, ViewPager.OnPageChangeListener {
    private var mTitles = arrayOf("首页", "发现", "消息", "会员", "我的")
    private var mSelectImg = intArrayOf(
        R.drawable.ic_blue_home, R.drawable.ic_blue_find,
        R.drawable.ic_blue_msg, R.drawable.ic_blue_member, R.drawable.ic_blue_me
    )
    private var mUnSelectImg = intArrayOf(
        R.drawable.ic_white_home, R.drawable.ic_white_find,
        R.drawable.ic_white_msg, R.drawable.ic_white_member, R.drawable.ic_white_me
    )
    var mListFragment: ArrayList<Fragment> = ArrayList()
    var mListData: ArrayList<CustomTabEntity> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    private fun initData() {
        for (i in mTitles.indices) {
            when (i) {
                0 -> {
                    val homeFragment = HomeFragment.newInstance(mTitles[i], mTitles[i])
                    mListFragment.add(homeFragment)
                }
                1 -> {
                    val findFragment = FindFragment.newInstance(mTitles[i], mTitles[i])
                    mListFragment.add(findFragment)
                }
                2 -> {
                    val messageFragment = MessageFragment.newInstance(mTitles[i], mTitles[i])
                    mListFragment.add(messageFragment)
                }
                3 -> {
                    val memberFragment = MemberFragment.newInstance(mTitles[i], mTitles[i])
                    mListFragment.add(memberFragment)
                }
                else -> {
                    val meFragment = MeFragment.newInstance(mTitles[i], mTitles[i])
                    mListFragment.add(meFragment)
                }
            }
        }

        for (i in mTitles.indices) {
            mListData.add(
                TabEntity(
                    mTitles[i],
                    mSelectImg[i],
                    mUnSelectImg[i]
                )
            )
        }

//        activity_main_fLayout.visibility = View.VISIBLE
//        activity_main_viewPage.visibility = View.GONE
//        activity_main_ct_l.setTabData(mListData, this, R.id.activity_main_fLayout, mListFragment)
//        activity_main_ct_l.currentTab = 0

        activity_main_fLayout.visibility = View.GONE
        activity_main_viewPage.visibility = View.VISIBLE
        activity_main_ct_l.setTabData(mListData)
        activity_main_viewPage.adapter =
            MyPagerAdapter(supportFragmentManager, mListFragment, mTitles)
        activity_main_viewPage.currentItem = 0
//        activity_main_viewPage.offscreenPageLimit = 5
        activity_main_viewPage.addOnPageChangeListener(this)


        activity_main_ct_l.showDot(0)
        var msgView = activity_main_ct_l.getMsgView(0)
        if (msgView != null) {
            UnreadMsgUtils.setSize(msgView, 20)
            msgView.backgroundColor = Color.parseColor("#6D8FB0")
        }
        activity_main_ct_l.showMsg(1, 250)
        activity_main_ct_l.setMsgMargin(1, -15f, 0f)
        activity_main_ct_l.setOnTabSelectListener(this)
    }

    override fun onTabSelect(position: Int) {
        activity_main_viewPage.currentItem = position
    }

    override fun onTabReselect(position: Int) {
        Toast.makeText(this, "Re", Toast.LENGTH_SHORT).show()
    }

    override fun onPageScrollStateChanged(state: Int) {
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
    }

    override fun onPageSelected(position: Int) {
        activity_main_ct_l.currentTab = position
    }
}