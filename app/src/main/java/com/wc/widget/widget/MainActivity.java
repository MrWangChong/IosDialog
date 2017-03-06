package com.wc.widget.widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wc.widget.dialog.IosDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }
}
