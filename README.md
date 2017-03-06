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
	        compile 'com.github.MrWangChong:IosDialog:1.0.4'
	}
 ```
 
 ###用法
 
 和Dialog一样，在设置标题内容以及点击事件的时候，可以传入颜色来改变默认颜色值
 ```java
 //use default setting
  Dialog dialog = new IosDialog.Builder(this).setTitle("提示").setMessage("是否确定退出app？")
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
                         finish();
                     }
                 }).build();
         dialog.show();
 ```
 可以设置标题，内容，按钮字体颜色和大小
 
  ```java
  //use more setting
   Dialog dialog = new IosDialog.Builder(this).setTitle("提示").setTitleColor(Color.RED).setTitleSize(20)
                  .setMessage("是否确定退出app？").setMessageColor(Color.BLUE).setMessageSize(18)
                  .setNegativeButtonColor(Color.GRAY)
                  .setNegativeButtonSize(18)
                  .setNegativeButton("取消", new IosDialog.OnClickListener() {
                      @Override
                      public void onClick(IosDialog dialog, View v) {
                          dialog.dismiss();
                          //doSomething
                      }
                  })
                  .setPositiveButtonColor(Color.GREEN)
                  .setPositiveButtonSize(18)
                  .setPositiveButton("确定", new IosDialog.OnClickListener() {
                      @Override
                      public void onClick(IosDialog dialog, View v) {
                          dialog.dismiss();
                          //doSomething
                          finish();
                      }
                  }).build();
          dialog.show();
  ```
可以使用资源id设置文字

  ```java
  //use resid setting
   Dialog dialog = new IosDialog.Builder(this).setTitle(R.string.dialog_title).setTitleColor(Color.RED).setTitleSize(20)
                  .setMessage(R.string.dialog_message).setMessageColor(Color.BLUE).setMessageSize(18)
                  .setNegativeButtonColor(Color.GRAY)
                  .setNegativeButtonSize(18)
                  .setNegativeButton(R.string.dialog_negative, new IosDialog.OnClickListener() {
                      @Override
                      public void onClick(IosDialog dialog, View v) {
                          dialog.dismiss();
                          //doSomething
                      }
                  })
                  .setPositiveButtonColor(Color.GREEN)
                  .setPositiveButtonSize(18)
                  .setPositiveButton(R.string.dialog_positive, new IosDialog.OnClickListener() {
                      @Override
                      public void onClick(IosDialog dialog, View v) {
                          dialog.dismiss();
                          //doSomething
                          finish();
                      }
                  }).build();
          dialog.show();
  ```
  可以设置显示的ContentView
  
  ```java
    //use ImageView as contentView
    ImageView imageView=new ImageView(this);
            imageView.setImageResource(R.mipmap.ic_launcher);
            Dialog dialog = new IosDialog.Builder(this).setTitle(R.string.dialog_title).setTitleColor(Color.RED).setTitleSize(20)
                    .setView(imageView)
                    .setNegativeButtonColor(Color.GRAY)
                    .setNegativeButtonSize(18)
                    .setNegativeButton(R.string.dialog_negative, new IosDialog.OnClickListener() {
                        @Override
                        public void onClick(IosDialog dialog, View v) {
                            dialog.dismiss();
                            //doSomething
                        }
                    })
                    .setPositiveButtonColor(Color.GREEN)
                    .setPositiveButtonSize(18)
                    .setPositiveButton(R.string.dialog_positive, new IosDialog.OnClickListener() {
                        @Override
                        public void onClick(IosDialog dialog, View v) {
                            dialog.dismiss();
                            //doSomething
                            finish();
                        }
                    }).build();
            dialog.show();
            
  ```
![image](https://github.com/MrWangChong/IosDialog/blob/master/img/iosdialog.gif)  
