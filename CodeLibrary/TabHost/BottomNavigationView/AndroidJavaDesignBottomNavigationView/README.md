### BottomNavigationView实现底部导航栏切换
1. 使用环境：
    - Android9.0  api版本28
    - 使用com.android.support:design:28.0.0
2. 当前版本优缺点(个人观点)：
    - 优点:
    	1. 有单独的重复点击事件(setOnNavigationItemReselectedListener),可设置再次点击方法,可以实现再次点击刷新列表功能
		2. 自带部分图标切换动画(如水波纹效果,缩放等)
    - 缺点:
    	1. 页面数最大是5,不能超过5否则会崩溃
		2. 无角标设置api支持,需要自己单独加载布局,并且角标的位置不可控需要自己调整位置
		3. 设置图标大小、调整导航栏高度及图标和文字之间的间距需要重写dimens
		dimens:design_bottom_navigation_margin、design_bottom_navigation_icon_size、design_bottom_navigation_height
3. 实现效果展示(gif):  
![image](https://github.com/androidbrid/AndroidNoteTree/blob/master/CodeLibrary/TabHost/BottomNavigationView/AndroidJavaDesignBottomNavigationView/1111111.gif)
4. 实现效果apk：
