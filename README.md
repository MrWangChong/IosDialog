# 高仿IosDialog 
使用方法和dialog一样
###引入
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```
 Step 2. Add the dependency
 ```gradle
 dependencies {
	        compile 'com.github.MrWangChong:IosDialog:1.0.2'
	}
 ```
 
 ###用法
 和Dialog一样，在设置标题内容以及点击事件的时候，可以传入颜色来改变默认颜色值
 ```java
 IosDialog dialog = new IosDialog(this).setTitle("标题").setMessage("内容")
                 .setNegativeButton("取消", new IosDialog.OnClickListener() {
                     @Override
                     public void onClick(IosDialog dialog, View v) {
                         dialog.dismiss();
                         //doSomething
                     }
                 }).setPositiveButton("确定", new IosDialog.OnClickListener() {
                     @Override
                     public void onClick(IosDialog dialog, View v) {
                         dialog.dismiss();
                         //doSomething
                     }
                 }).createDialog();
         dialog.show();
 ```
