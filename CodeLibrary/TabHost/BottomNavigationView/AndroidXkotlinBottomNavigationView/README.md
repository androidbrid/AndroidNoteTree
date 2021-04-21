### BottomNavigationView实现底部导航栏切换
1. 使用环境：
    - Android11  api版本30
	- AndroidX   Kotlin语言版本
    - 使用com.google.android.material:material:1.2.1
2. 当前版本优缺点(个人观点)：
    - 优点:
    	1. 有单独的重复点击事件(setOnNavigationItemReselectedListener),可设置再次点击方法,可以实现再次点击刷新列表功能
		2. 自带部分图标切换动画(如水波纹效果,缩放等)  
		3. 角标设置api支持
    - 缺点:
    	1. 页面数最大是5,不能超过5否则会崩溃
		2. 设置图标大小、调整导航栏高度及图标和文字之间的间距需要重写dimens
		dimens:design_bottom_navigation_margin、design_bottom_navigation_icon_size、design_bottom_navigation_height
3. 实现效果展示(gif):  
    - **FrameLayout + BottomNavigationView**:  
		
		![dl](source/1111111.gif)  
    - **ViewPager + BottomNavigationView**:  
		
		![dl](source/2222222.gif)
4. 实现效果apk:  
    - **FrameLayout + BottomNavigationView**:  
		
		<a href="https://github.com/androidbrid/AndroidNoteTree/tree/master/CodeLibrary/TabHost/BottomNavigationView/AndroidJavaDesignBottomNavigationView/source/FrameLayout/app-debug.apk" download="app-debug.apk">**==*apk下载*==**</a>  
    - **ViewPager + BottomNavigationView**:  
		
		<a href="https://github.com/androidbrid/AndroidNoteTree/tree/master/CodeLibrary/TabHost/BottomNavigationView/AndroidJavaDesignBottomNavigationView/source/ViewPager/app-debug.apk" download="app-debug.apk">**==*apk下载*==**</a>

