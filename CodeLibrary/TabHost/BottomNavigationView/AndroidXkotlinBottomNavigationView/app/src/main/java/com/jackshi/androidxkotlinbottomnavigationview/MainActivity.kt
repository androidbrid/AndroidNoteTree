package com.jackshi.androidxkotlinbottomnavigationview

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import com.jackshi.androidxkotlinbottomnavigationview.fragment.*
import com.jackshi.androidxkotlinbottomnavigationview.utils.FragmentChangeManager
import com.jackshi.androidxkotlinbottomnavigationview.utils.MessageEvent
import com.jackshi.androidxkotlinbottomnavigationview.utils.MyPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {
    private var mList: ArrayList<Fragment> = ArrayList()
    private lateinit var mMenuItem: MenuItem
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //当前api版本30,android11,androidx、kotlin版本,使用google.android.material的BottomNavigationView的注意事项
        /**
         * 缺点:
         *  1.页面数最大是5,不能超过5否则会崩溃
         *  2.设置图标大小、调整导航栏高度及图标和文字之间的间距需要重写dimens
         *      dimens:design_bottom_navigation_margin、design_bottom_navigation_icon_size、design_bottom_navigation_height
         *优点:
         *  1.有单独的重复点击事件(setOnNavigationItemReselectedListener),可设置再次点击方法,可以实现再次点击刷新列表功能
         *  2.自带部分图标切换动画(如水波纹效果,缩放等)
         *  3.角标设置api支持
         */
        initView()
        initData()
        initClick()
    }

    private fun initView() {
        activity_main_bottomNavigationView.labelVisibilityMode =
            LabelVisibilityMode.LABEL_VISIBILITY_AUTO
        activity_main_bottomNavigationView.isItemHorizontalTranslationEnabled = true
        var mBadge1 = activity_main_bottomNavigationView.getOrCreateBadge(R.id.item_bottom_1)
        var mBadge2 = activity_main_bottomNavigationView.getOrCreateBadge(R.id.item_bottom_2)
        mBadge1.number = 1899
        mBadge1.isVisible = true
        mBadge2.isVisible = true
        EventBus.getDefault().register(this)
    }

    private fun initData() {
        val homeFragment = HomeFragment.newInstance("home", "home")
        val findFragment = FindFragment.newInstance("find", "find")
        val messageFragment = MessageFragment.newInstance("message", "message")
        val memberFragment = MemberFragment.newInstance("member", "member")
        val meFragment = MeFragment.newInstance("me", "me")

        mList.add(homeFragment)
        mList.add(findFragment)
        mList.add(messageFragment)
        mList.add(memberFragment)
        mList.add(meFragment)
    }

    private fun initClick() {
        activity_main_viewPage.visibility = View.GONE
        activity_main_fLayout.visibility = View.VISIBLE
        var mFragmentManager =
            FragmentChangeManager(supportFragmentManager, R.id.activity_main_fLayout, mList)

//        mMenuItem = activity_main_bottomNavigationView.menu.getItem(0)
//        activity_main_bottomNavigationView.menu.getItem(0).isChecked = true
//        activity_main_viewPage.visibility = View.VISIBLE
//        activity_main_fLayout.visibility = View.GONE
//        activity_main_viewPage.adapter = MyPagerAdapter(supportFragmentManager, mList, mMenuItem)
//        activity_main_viewPage.currentItem = 0

        val mOnNavigationItemReselectedListener =
            BottomNavigationView.OnNavigationItemReselectedListener {
                mMenuItem = it
                when (it.itemId) {
                    R.id.item_bottom_1 -> {
                        Toast.makeText(this@MainActivity, "homeRe", Toast.LENGTH_SHORT).show()
                    }
                    R.id.item_bottom_2 -> {
                        Toast.makeText(this@MainActivity, "findRe", Toast.LENGTH_SHORT).show()
                    }
                    R.id.item_bottom_3 -> {
                        Toast.makeText(this@MainActivity, "messageRe", Toast.LENGTH_SHORT).show()
                    }
                    R.id.item_bottom_4 -> {
                        Toast.makeText(this@MainActivity, "memberRe", Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        Toast.makeText(this@MainActivity, "meRe", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        val mOnNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.item_bottom_1 -> {
                        mFragmentManager.setFragments(0)
//                        activity_main_viewPage.currentItem = 0
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.item_bottom_2 -> {
                        mFragmentManager.setFragments(1)
//                        activity_main_viewPage.currentItem = 1
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.item_bottom_3 -> {
                        mFragmentManager.setFragments(2)
//                        activity_main_viewPage.currentItem = 2
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.item_bottom_4 -> {
                        mFragmentManager.setFragments(3)
//                        activity_main_viewPage.currentItem = 3
                        return@OnNavigationItemSelectedListener true
                    }
                    else -> {
                        mFragmentManager.setFragments(4)
//                        activity_main_viewPage.currentItem = 4
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            }

        activity_main_bottomNavigationView.setOnNavigationItemSelectedListener(
            mOnNavigationItemSelectedListener
        )
        activity_main_bottomNavigationView.setOnNavigationItemReselectedListener(
            mOnNavigationItemReselectedListener
        )

//        activity_main_viewPage.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
//
//            override fun onPageScrollStateChanged(state: Int) {}
//
//            override fun onPageScrolled(
//                position: Int,
//                positionOffset: Float,
//                positionOffsetPixels: Int
//            ) {
//            }
//
//            override fun onPageSelected(position: Int) {
//                if (mMenuItem != null) {
//                    mMenuItem.isChecked = false
//                } else {
//                    activity_main_bottomNavigationView.menu.getItem(0).isChecked = false
//                }
//                mMenuItem = activity_main_bottomNavigationView.menu.getItem(position)
//                mMenuItem.isChecked = true
//            }
//        })
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(messageEvent: MessageEvent) {
        when (messageEvent.type) {
            0 -> if (messageEvent.flag) {
                //移除选中item水波纹的效果
                activity_main_bottomNavigationView.itemBackground = null
            }
            1 ->//改变选中非选中文字大小来达到移除缩放效果
                if (messageEvent.flag) {
                    activity_main_bottomNavigationView.itemTextAppearanceInactive =
                        R.style.bottom_normal_text
                    activity_main_bottomNavigationView.itemTextAppearanceActive =
                        R.style.bottom_normal_text
                } else {
                    activity_main_bottomNavigationView.itemTextAppearanceInactive =
                        R.style.bottom_normal_text
                    activity_main_bottomNavigationView.itemTextAppearanceActive =
                        R.style.bottom_selected_text
                }
            2 -> when {
                messageEvent.position === 0 -> {
                    activity_main_bottomNavigationView.labelVisibilityMode =
                        LabelVisibilityMode.LABEL_VISIBILITY_AUTO
                }
                messageEvent.position === 1 -> {
                    activity_main_bottomNavigationView.labelVisibilityMode =
                        LabelVisibilityMode.LABEL_VISIBILITY_SELECTED
                }
                messageEvent.position === 2 -> {
                    activity_main_bottomNavigationView.labelVisibilityMode =
                        LabelVisibilityMode.LABEL_VISIBILITY_LABELED
                }
                else -> {
                    activity_main_bottomNavigationView.labelVisibilityMode =
                        LabelVisibilityMode.LABEL_VISIBILITY_UNLABELED
                }
            }
            3 -> activity_main_bottomNavigationView.isItemHorizontalTranslationEnabled =
                !messageEvent.flag
            else -> {
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}