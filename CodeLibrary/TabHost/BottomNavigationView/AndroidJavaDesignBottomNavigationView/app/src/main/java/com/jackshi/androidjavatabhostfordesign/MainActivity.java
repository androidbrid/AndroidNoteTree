package com.jackshi.androidjavatabhostfordesign;

import android.support.annotation.NonNull;
import android.support.design.bottomnavigation.LabelVisibilityMode;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jackshi.androidjavatabhostfordesign.fragment.FindFragment;
import com.jackshi.androidjavatabhostfordesign.fragment.HomeFragment;
import com.jackshi.androidjavatabhostfordesign.fragment.MeFragment;
import com.jackshi.androidjavatabhostfordesign.fragment.MemberFragment;
import com.jackshi.androidjavatabhostfordesign.fragment.MessageFragment;
import com.jackshi.androidjavatabhostfordesign.utils.FragmentChangeManager;
import com.jackshi.androidjavatabhostfordesign.utils.MessageEvent;
import com.jackshi.androidjavatabhostfordesign.utils.MyPagerAdapter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FrameLayout mFrameLayout;
    ViewPager mViewPager;
    BottomNavigationView mBottomNavigationView;
    ArrayList<Fragment> mList;
    FragmentChangeManager mChangeManager;
    MenuItem mMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //当前api版本28,android9.0,使用design:28.0.0的BottomNavigationView的注意事项
        /**
         * 缺点:
         *  1.页面数最大是5,不能超过5否则会崩溃
         *  2.无角标设置api支持,需要自己单独加载布局,并且角标的位置不可控需要自己调整位置
         *  3.设置图标大小、调整导航栏高度及图标和文字之间的间距需要重写dimens
         *      dimens:design_bottom_navigation_margin、design_bottom_navigation_icon_size、design_bottom_navigation_height
         *优点:
         *  1.有单独的重复点击事件(setOnNavigationItemReselectedListener),可设置再次点击方法,可以实现再次点击刷新列表功能
         *  2.自带部分图标切换动画(如水波纹效果,缩放等)
         */
        initView();
        initData();
        initClick();
    }

    private void initView() {
        mList = new ArrayList<>();
        mFrameLayout = findViewById(R.id.activity_main_fLayout);
        mViewPager = findViewById(R.id.activity_main_viewPage);
        mBottomNavigationView = findViewById(R.id.activity_main_bottomNavigationView);

        //水平平移动画效果
        mBottomNavigationView.setItemHorizontalTranslationEnabled(true);
        //设置item状态文字显示
        mBottomNavigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_AUTO);
        EventBus.getDefault().register(this);
    }

    private void initData() {
        HomeFragment homeFragment = HomeFragment.newInstance("home", "home");
        FindFragment findFragment = FindFragment.newInstance("find", "find");
        MessageFragment messageFragment = MessageFragment.newInstance("message", "message");
        MeFragment meFragment = MeFragment.newInstance("me", "me");
        MemberFragment memberFragment = MemberFragment.newInstance("member", "member");
        mList.add(homeFragment);
        mList.add(findFragment);
        mList.add(messageFragment);
        mList.add(memberFragment);
        mList.add(meFragment);

        //获取整个的NavigationView
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) mBottomNavigationView.getChildAt(0);
        //这里就是获取所添加的每一个Tab(或者叫menu)，
        View tab = menuView.getChildAt(3);
        BottomNavigationItemView itemView = (BottomNavigationItemView) tab;
        //加载我们的角标View，新创建的一个布局
        View badge = LayoutInflater.from(this).inflate(R.layout.badge_layout, menuView, false);
        //添加到Tab上
        itemView.addView(badge);
        TextView tv = badge.findViewById(R.id.badge_layout_tv_msg_count);
        tv.setText("" + 50);

        //1.FrameLayout+BottomNavigationView实现
        mFrameLayout.setVisibility(View.VISIBLE);
        mViewPager.setVisibility(View.GONE);
        mChangeManager = new FragmentChangeManager(getSupportFragmentManager(), R.id.activity_main_fLayout, mList);

//       //2.ViewPager+BottomNavigationView实现
//        mFrameLayout.setVisibility(View.GONE);
//        mViewPager.setVisibility(View.VISIBLE);
//        mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(), mList, mMenuItem));
//        mViewPager.setCurrentItem(0);
    }

    private void initClick() {
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                mMenuItem = menuItem;
                switch (menuItem.getItemId()) {
                    case R.id.item_bottom_1:
                        mChangeManager.setFragments(0);
//                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.item_bottom_2:
                        mChangeManager.setFragments(1);
//                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.item_bottom_3:
                        mChangeManager.setFragments(2);
//                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.item_bottom_4:
                        mChangeManager.setFragments(3);
//                        mViewPager.setCurrentItem(3);
                        break;
                    case R.id.item_bottom_5:
                        mChangeManager.setFragments(4);
//                        mViewPager.setCurrentItem(4);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });
        mBottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.item_bottom_1:
                        Toast.makeText(MainActivity.this, "homeRe", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_bottom_2:
                        Toast.makeText(MainActivity.this, "findRe", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_bottom_3:
                        Toast.makeText(MainActivity.this, "msgRe", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_bottom_4:
                        Toast.makeText(MainActivity.this, "memberRe", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.item_bottom_5:
                        Toast.makeText(MainActivity.this, "meRe", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });

//        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                if (mMenuItem != null) {
//                    mMenuItem.setChecked(false);
//                } else {
//                    mBottomNavigationView.getMenu().getItem(0).setChecked(false);
//                }
//                mMenuItem = mBottomNavigationView.getMenu().getItem(position);
//                mMenuItem.setChecked(true);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//            }
//        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent messageEvent) {
        switch (messageEvent.getType()) {
            case 0:
                if (messageEvent.getFlag()) {
                    //移除选中item水波纹的效果
                    mBottomNavigationView.setItemBackground(null);
                }
                break;
            case 1:
                //改变选中非选中文字大小来达到移除缩放效果
                if (messageEvent.getFlag()) {
                    mBottomNavigationView.setItemTextAppearanceInactive(R.style.bottom_normal_text);
                    mBottomNavigationView.setItemTextAppearanceActive(R.style.bottom_normal_text);
                } else {
                    mBottomNavigationView.setItemTextAppearanceInactive(R.style.bottom_normal_text);
                    mBottomNavigationView.setItemTextAppearanceActive(R.style.bottom_selected_text);
                }
                break;
            case 2:
                if (messageEvent.getPosition() == 0) {
                    mBottomNavigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_AUTO);
                } else if (messageEvent.getPosition() == 1) {
                    mBottomNavigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_SELECTED);
                } else if (messageEvent.getPosition() == 2) {
                    mBottomNavigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
                } else {
                    mBottomNavigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_UNLABELED);
                }
                break;
            case 3:
                if (messageEvent.getFlag()) {
                    mBottomNavigationView.setItemHorizontalTranslationEnabled(false);
                } else {
                    mBottomNavigationView.setItemHorizontalTranslationEnabled(true);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}