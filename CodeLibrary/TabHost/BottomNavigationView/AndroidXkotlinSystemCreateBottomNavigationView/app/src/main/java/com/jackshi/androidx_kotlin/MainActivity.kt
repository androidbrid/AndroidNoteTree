package com.jackshi.androidx_kotlin

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : AppCompatActivity() {
    private lateinit var mNavView: BottomNavigationView
    private lateinit var mMenuItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mNavView = findViewById(R.id.nav_view)

        /**
         * 缺点:
         *  1.页面数最大是5,不能超过5否则会崩溃
         *  2.页面切换再重新切回当前页面,导致Fragment重新被创建,导致页面数据刷新无法保存
         * 原因:
         *  内部方法createFragmentNavigator()执行重建
         * 解决办法:
         *  修改源码重写NavHostFragment
         */
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_find,
                R.id.navigation_message,
                R.id.navigation_member,
                R.id.navigation_me
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        mNavView.setupWithNavController(navController)
        mNavView.isItemHorizontalTranslationEnabled = true
        mNavView.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_AUTO

        var badge1: BadgeDrawable = mNavView.getOrCreateBadge(R.id.navigation_home)
        var badge2: BadgeDrawable = mNavView.getOrCreateBadge(R.id.navigation_find)
        badge1.number = 1000
        badge1.isVisible = true
        badge2.isVisible = true
        EventBus.getDefault().register(this)
        initClick()
    }

    private fun initClick() {
        val mOnNavigationItemReselectedListener =
            BottomNavigationView.OnNavigationItemReselectedListener {
                mMenuItem = it
                when (it.itemId) {
                    R.id.navigation_home -> {
                        Toast.makeText(this@MainActivity, "homeRe", Toast.LENGTH_SHORT).show()
                    }
                    R.id.navigation_find -> {
                        Toast.makeText(this@MainActivity, "findRe", Toast.LENGTH_SHORT).show()
                    }
                    R.id.navigation_message -> {
                        Toast.makeText(this@MainActivity, "messageRe", Toast.LENGTH_SHORT).show()
                    }
                    R.id.navigation_member -> {
                        Toast.makeText(this@MainActivity, "memberRe", Toast.LENGTH_SHORT).show()
                    }
                    else -> {
                        Toast.makeText(this@MainActivity, "meRe", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        mNavView.setOnNavigationItemReselectedListener(mOnNavigationItemReselectedListener)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(messageEvent: MessageEvent) {
        when (messageEvent.type) {
            0 -> if (messageEvent.flag) {
                //移除选中item水波纹的效果
                mNavView.itemBackground = null
            }
            1 ->//改变选中非选中文字大小来达到移除缩放效果
                if (messageEvent.flag) {
                    mNavView.itemTextAppearanceInactive =
                        R.style.bottom_normal_text
                    mNavView.itemTextAppearanceActive =
                        R.style.bottom_normal_text
                } else {
                    mNavView.itemTextAppearanceInactive =
                        R.style.bottom_normal_text
                    mNavView.itemTextAppearanceActive =
                        R.style.bottom_selected_text
                }
            2 -> when {
                messageEvent.position === 0 -> {
                    mNavView.labelVisibilityMode =
                        LabelVisibilityMode.LABEL_VISIBILITY_AUTO
                }
                messageEvent.position === 1 -> {
                    mNavView.labelVisibilityMode =
                        LabelVisibilityMode.LABEL_VISIBILITY_SELECTED
                }
                messageEvent.position === 2 -> {
                    mNavView.labelVisibilityMode =
                        LabelVisibilityMode.LABEL_VISIBILITY_LABELED
                }
                else -> {
                    mNavView.labelVisibilityMode =
                        LabelVisibilityMode.LABEL_VISIBILITY_UNLABELED
                }
            }
            3 -> mNavView.isItemHorizontalTranslationEnabled =
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