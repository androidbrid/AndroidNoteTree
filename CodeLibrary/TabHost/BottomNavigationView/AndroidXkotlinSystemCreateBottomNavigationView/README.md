### BottomNavigationView实现底部导航栏切换
1. 使用环境：
    - Android11  api版本30
	- AndroidX   Kotlin语言版本
    - 使用com.google.android.material:material:1.2.1
2. 当前版本缺点(个人观点)：
    - 缺点:
    	1. 页面数最大是5,不能超过5否则会崩溃
		2. 页面切换再重新切回当前页面,导致Fragment重新被创建,导致页面数据刷新无法保存  
	- 原因:  
		1. 内部方法createFragmentNavigator()执行重建
	- 解决办法:
	    1. 修改源码重写NavHostFragment
3. 实现效果展示(gif):  
    - **fragment + BottomNavigationView**:  
		
		![dl](source/1111111.gif)
4. 实现效果apk:  
    - **fragment + BottomNavigationView**:  
		
		<a href="https://github.com/androidbrid/AndroidNoteTree/tree/master/CodeLibrary/TabHost/BottomNavigationView/AndroidXkotlinSystemCreateBottomNavigationView/source/app-debug.apk" download="app-debug.apk">**==*apk下载*==**</a>

