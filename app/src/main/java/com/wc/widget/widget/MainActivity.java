package com.wc.widget.widget;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wc.widget.dialog.IosDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dialog1(View v) {
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

    public void dialog2(View v) {
        IosDialog dialog = new IosDialog(this).setTitle("标题", Color.RED).setMessage("内容", Color.BLUE)
                .setNegativeButton("取消", Color.GRAY, new IosDialog.OnClickListener() {
                    @Override
                    public void onClick(IosDialog dialog, View v) {
                        dialog.dismiss();
                        //doSomething
                    }
                }).setPositiveButton("确定", Color.GREEN, new IosDialog.OnClickListener() {
                    @Override
                    public void onClick(IosDialog dialog, View v) {
                        dialog.dismiss();
                        //doSomething
                    }
                }).createDialog();
        dialog.show();
    }

    public void dialog3(View v) {
        IosDialog dialog = new IosDialog(this).setTitle(R.string.dialog_title, Color.RED).setMessage(R.string.dialog_message, Color.BLUE)
                .setNegativeButton(R.string.dialog_negative, Color.GRAY, new IosDialog.OnClickListener() {
                    @Override
                    public void onClick(IosDialog dialog, View v) {
                        dialog.dismiss();
                        //doSomething
                    }
                }).setPositiveButton(R.string.dialog_positive, Color.GREEN, new IosDialog.OnClickListener() {
                    @Override
                    public void onClick(IosDialog dialog, View v) {
                        dialog.dismiss();
                        //doSomething
                    }
                }).createDialog();
        dialog.show();
    }
}
