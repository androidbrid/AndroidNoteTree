1. [搭建VPS服务器,可选择商家](https://ssr.tools/55)
	- [搬瓦工](https://bwh88.net/index.php):`(未采纳)`  
		![图片](http://chuantu.xyz/t6/741/1605515862x1031866013.png)  
		* 搬瓦工教程:  
			[搬瓦工VPS服务器购买及用教程](https://ssr.tools/208)  
		* 套餐如何选择  
			![图片](http://chuantu.xyz/t6/741/1605517885x1033347913.png)  
		* [全部套餐列表](https://bwh88.net/cart.php?gid=1)  
		* 支付宝支付注意事项  
			![图片](http://chuantu.xyz/t6/741/1605518316x1031866013.png)  
		* 购买流程  
			![图片](http://chuantu.xyz/t6/741/1605518441x1031866013.png)  
		* [优惠码](https://www.wervps.com/bwh1pice)  
			![图片](http://chuantu.xyz/t6/741/1605518537x1700338641.png)  
		* 搬瓦工测试IP  
			![图片](http://chuantu.xyz/t6/741/1605519083x1031866013.png)  
		* 搬瓦工支付宝购买流程  
			![图片](http://chuantu.xyz/t6/741/1605520117x1700338641.png)  
			<a href="#winscpPutty">使用Winscp和Putty请参考Vultr,下面会有具体的使用步骤</a>  
		* 搬瓦工后台面板简介  
			![图片](http://chuantu.xyz/t6/741/1605520498x1031866013.png)  
		* 搬瓦工购买VPS后的网络优化  
			![图片](http://chuantu.xyz/t6/741/1605520616x1033347913.png)  
			1. [BBR一键安装脚本](https://ssr.tools/199)  
			2. [魔改BBR一键安装脚本(参考VultrBBR步骤)](https://ssr.tools/550) <a href="#end">`本文集成步骤`</a>  
			3. [BBR Plus一键安装脚本](https://ssr.tools/1217)  
		* 少数情况下连接速度太慢的解决办法  
			![图片](http://chuantu.xyz/t6/741/1605521219x1031866013.png)  
		* 搬瓦工VPS如何续费  
			![图片](http://chuantu.xyz/t6/741/1605521262x1700338641.png)  
		* [如何续费](https://ssr.tools/1293)  
	- [Vultr](https://www.vultr.com/):`(采纳)`  
		![图片](http://chuantu.xyz/t6/741/1605515510x1700338641.png)  
		* Vultr教程:  
			[VultrVPS服务器购买及使用教程](https://ssr.tools/216)  
		* 套餐如何选择:目前博主使用的是日本的(个人感觉经济又实惠网速也不错的)  
			![图片](http://chuantu.xyz/t6/741/1605522480x1033347913.jpg)  
		* Vultr VPS服务器购买简易流程  
			![图片](http://chuantu.xyz/t6/741/1605522715x1031866013.png)  
			* [Vultr账号注册](https://www.vultr.com/)  
			![图片](http://chuantu.xyz/t6/741/1605522865x1700338641.png)  
			* Vultr充值  
			![图片](http://chuantu.xyz/t6/741/1605522979x1033347913.png)  
			* 确认机房位置  
			![图片](http://chuantu.xyz/t6/741/1605526887x1700338641.png)  
			* VPS服务器购买  
			![图片](http://chuantu.xyz/t6/741/1605527178x1700338641.png)  
		* <p id="winscpPutty">Winscp及Putty下载、安装、使用教程</p>  
			  
			![图片](http://chuantu.xyz/t6/741/1605531470x1033347913.png)  
			* 下载地址  
			![图片](http://chuantu.xyz/t6/741/1605531562x1031866013.png)  
				1. [Winscp目前官方最新绿色免安装版:](https://winscp.net/download/WinSCP-5.13.3-Portable.zip)  
				2. [Winscp中文翻译文件:](https://winscp.net/translations/dll/5.13.3/chs.zip)  
				3. [Putty目前最新版:](https://winscp.net/download/putty.exe)  
			* 安装教程  
			![图片](http://chuantu.xyz/t6/741/1605583787x992248267.png)  
			* Winscp使用教程  
			![图片](http://chuantu.xyz/t6/741/1605583896x-1224475230.png)  
			* Putty使用教程  
			![图片](http://chuantu.xyz/t6/741/1605584318x1700338641.png)  
		* <p id="end">魔改BBR一键安装脚本</font>  
			  
			* 关于暴力魔改BBR  
			![图片](http://chuantu.xyz/t6/741/1605529964x1031866013.png)  
			* 原版BBR与魔改BBR加速效果对比测试  
			![图片](http://chuantu.xyz/t6/741/1605530222x1033347913.png)  
			* 魔改BBR一键安装脚本  
			![图片](http://chuantu.xyz/t6/741/1605530507x1700338641.png)  
				*	图中1步骤:安装涉及到的指令  
			    	*	Debian版:  
							1.	wget --no-check-certificate https://github.com/tcp-		nanqinlang/general/releases/download/3.4.2.1/tcp_nanqinlang-fool-1.3.0.sh  
							2.	bash tcp_nanqinlang-fool-1.3.0.sh  
					*	CentOS版:  
							1.	wget --no-check-certificate https://raw.githubusercontent.com/tcp-nanqinlang/general/master/General/CentOS/bash/tcp_nanqinlang-1.3.2.sh  
							2.	bash tcp_nanqinlang-1.3.2.sh  
				*	图中5步骤:系统重启完成后,重新Putty连接  
					*	Debian版:  
							1.	bash tcp_nanqinlang-fool-1.3.0.sh  
					*	CentOS版:  
							1.	bash tcp_nanqinlang-1.3.2.sh  
			* 魔改BBR卸载  
			![图片](http://chuantu.xyz/t6/741/1605530913x1031866013.png)  
				*	图中1步骤:涉及到的指令  
					*	Debian版:  
							1.	bash tcp_nanqinlang-fool-1.3.0.sh  
					*	CentOS版:  
							1.	bash tcp_nanqinlang-1.3.2.sh  
		* <p id="ssrinstall">SSR一键安装脚本</font>  
			  
			![图片](http://chuantu.xyz/t6/741/1605585712x-1224475230.png)  
			* SSR一键搭建流程  
			![图片](http://chuantu.xyz/t6/741/1605586208x992249049.png)  
				*	图中2步骤:涉及到的指令  
					1.	wget --no-check-certificate -O shadowsocks-all.sh https://raw.githubusercontent.com/teddysun/shadowsocks_install/master/shadowsocks-all.sh  
					2.	chmod +x shadowsocks-all.sh  
					3.	./shadowsocks-all.sh 2>&1 | tee shadowsocks-all.log  
				*	提示:如果运行上面第一条命令时，出现找不到wget之类的提示,则表明系统没有预装wget，先运行以下命令完成wget的安装  
					CentOS:  
						1.	yum -y install wget  
					Ubuntu/Debian:  
						1.	apt-get -y install wget  
				<a href="#ssrdownload">SSR各平台客户端下载汇总</a>  
			* SSR常用命令  
			![图片](http://chuantu.xyz/t6/741/1605586268x992248267.png)  
				*	启动SSR:  
					1.	/etc/init.d/shadowsocks-r start  
				*	退出SSR:  
					1.	/etc/init.d/shadowsocks-r stop  
				*	重启SSR:  
					1.	/etc/init.d/shadowsocks-r restart  
				*	SSR状态:  
					1.	/etc/init.d/shadowsocks-r status  
				*	卸载SSR:  
					1.	./shadowsocks-all.sh uninstall  
		* <p id="ssrdownload">SSR各平台客户端下载汇总</font>  
			  
			##### ShadowSocksR分为服务端和客户端,两者要分别安装,配合使用.服务器一般只需安装一个版本,而客户端则根据平台的不同,分为多个版本.目前SSR客户端的可用平台有:路由器版、Windows版、安卓版、IOS版、MAC版,基本涵盖我们日常使用环境.  
			* [SSR服务端](https://ssr.tools/31) <a href="#ssrinstall">`本文地址`</a>  
			![图片](http://chuantu.xyz/t6/741/1605593913x1033347913.png)  
			* [SSR Windows客户端](https://github.com/shadowsocksrr/shadowsocksr-csharp/releases/download/4.9.0/ShadowsocksR-win-4.9.0.zip)  
			![图片](http://chuantu.xyz/t6/741/1605594447x1033347913.png)  
				*	[SSR Windows客户端下载、安装及使用教程](https://ssr.tools/82)  
					1.	[SSR Windows客户端下载](https://github.com/shadowsocksrr/shadowsocksr-csharp/releases/download/4.9.0/ShadowsocksR-win-4.9.0.zip)  
						![图片](http://chuantu.xyz/t6/741/1605595303x1031866013.png)  
					2.	[SSR Windows客户端安装及运行](https://www.microsoft.com/zh-cn/download/details.aspx?id=17718)  
						![图片](http://chuantu.xyz/t6/741/1605595520x1031866013.png)  
					3.	SSR客户端使用教程  
						![图片](http://chuantu.xyz/t6/741/1605595713x1031866013.png)  
					4.	SSR菜单选项设置  
						![图片](http://chuantu.xyz/t6/741/1605595911x1033347913.png)  
					5.	如何设置SSR开机启动  
						![图片](http://chuantu.xyz/t6/741/1605595985x1033347913.png)  
					6.	如何让局域网其它设备连接SSR  
						![图片](http://chuantu.xyz/t6/741/1605596062x1700338641.png)  
					7.	SSR如何通过GFWList只能分流  
						![图片](http://chuantu.xyz/t6/741/1605596352x1031866013.png)  

