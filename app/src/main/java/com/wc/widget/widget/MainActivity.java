package com.wc.widget.widget;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.wc.widget.dialog.IosDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dialog1(View v) {
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
    }

    public void dialog2(View v) {
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
    }

    public void dialog3(View v) {
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
    }
    public void dialog4(View v) {
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
    }
}
