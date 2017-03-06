package com.wc.widget.dialog;

/**
 * IOSdialog
 * Created by RushKing on 2016/7/11.
 */

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class IosDialog extends Dialog {
    private Context mContext;
    private String title, message, textNegativeButton, textPositiveButton;
    private OnClickListener onClickListenerNegativeButton, onClickListenerPositiveButton;
    private View mContentView;
    private boolean canceledOnTouchOutside = true;

    private int titleColor = -1;

    public IosDialog(Context context) {
        super(context, R.style.IosDialog);
        this.mContext = context;
    }

    public IosDialog(Context context, int theme) {
        super(context, theme);
        this.mContext = context;
    }

    public IosDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public IosDialog setTitle(String title, int color) {
        this.title = title;
        this.titleColor = color;
        return this;
    }

    public IosDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * 设置左边按钮---取消
     */
    public IosDialog setNegativeButton(String text, OnClickListener onClickListener) {
        this.textNegativeButton = text;
        this.onClickListenerNegativeButton = onClickListener;
        return this;
    }

    /**
     * 设置右边按钮 ---确定
     */
    public IosDialog setPositiveButton(String text, OnClickListener onClickListener) {
        this.textPositiveButton = text;
        this.onClickListenerPositiveButton = onClickListener;
        return this;
    }

    /**
     * 设置能否点击外部取消弹出框
     */
    public IosDialog setDialogCanceledOnTouchOutside(boolean can) {
        this.canceledOnTouchOutside = can;
        return this;
    }

    /**
     * 设置显示的View
     */
    public IosDialog setView(View v) {
        this.mContentView = v;
        return this;
    }

    public IosDialog createDialog() {
        LinearLayout layout = new LinearLayout(mContext);
        layout.setLayoutParams(new LayoutParams(dip2px(mContext, 200), LayoutParams.WRAP_CONTENT));
        // layout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(0, dip2px(mContext, 25), 0, 0);

        LinearLayout layoutContent = new LinearLayout(mContext);
        layoutContent.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        // layout.setBackgroundColor(Color.parseColor("#FFFFFF"));
        layoutContent.setOrientation(LinearLayout.VERTICAL);
        layoutContent.setPadding(0, 0, 0, dip2px(mContext, 20));
        if (!TextUtils.isEmpty(title)) {
            TextView textTitle = new TextView(mContext);
            textTitle.setText(title);
            textTitle.setTextSize(18);
            if (titleColor != -1) {
                textTitle.setTextColor(titleColor);
            }
            textTitle.getPaint().setTypeface(Typeface.DEFAULT_BOLD);
            LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
            lp.gravity = Gravity.CENTER_HORIZONTAL;
            textTitle.setLayoutParams(lp);
            layoutContent.addView(textTitle);
        }

        if (!TextUtils.isEmpty(message)) {
            TextView textMessage = new TextView(mContext);
            textMessage.setText(message);
            textMessage.setTextSize(16);
            textMessage.setGravity(Gravity.CENTER);
            textMessage.setPadding(dip2px(mContext, 20), dip2px(mContext, 10), dip2px(mContext, 20), 0);
            LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
            textMessage.setLayoutParams(lp);
            layoutContent.addView(textMessage);
        }

        if (mContentView != null) {
            layoutContent.addView(mContentView);
        }

        LinearLayout layoutButton = new LinearLayout(mContext);
        layoutButton.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));

        layout.addView(layoutContent);
        layout.addView(layoutButton);
        if (onClickListenerNegativeButton != null) {
            if (onClickListenerPositiveButton == null) { // 只有一个按钮
                layoutButton.setOrientation(LinearLayout.VERTICAL);
                Button negativeButton = new Button(mContext);
                negativeButton.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, dip2px(mContext, 44), 1.0f));
                negativeButton.setTextColor(Color.parseColor("#439AFC"));
                negativeButton.setBackgroundResource(R.drawable.dialog_button);
                negativeButton.setText(textNegativeButton);
                negativeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListenerNegativeButton.onClick(IosDialog.this, v);
                    }
                });
                layoutButton.addView(negativeButton);
            } else {//两个按钮
                layoutButton.setOrientation(LinearLayout.HORIZONTAL);
                Button negativeButton = new Button(mContext);
                negativeButton.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, dip2px(mContext, 44), 1.0f));
                negativeButton.setTextColor(Color.parseColor("#439AFC"));
                negativeButton.setBackgroundResource(R.drawable.dialog_left_button);
                negativeButton.setText(textNegativeButton);
                negativeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListenerNegativeButton.onClick(IosDialog.this, v);
                    }
                });
                layoutButton.addView(negativeButton);

                Button positiveButton = new Button(mContext);
                positiveButton.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, dip2px(mContext, 44), 1.0f));
                positiveButton.setTextColor(Color.parseColor("#439AFC"));
                positiveButton.setBackgroundResource(R.drawable.dialog_right_button);
                positiveButton.setText(textPositiveButton);
                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListenerPositiveButton.onClick(IosDialog.this, v);
                    }
                });
                layoutButton.addView(positiveButton);
            }
        } else {
            if (onClickListenerPositiveButton != null) {  // 只有一个按钮
                layoutButton.setOrientation(LinearLayout.VERTICAL);
                Button positiveButton = new Button(mContext);
                positiveButton.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, dip2px(mContext, 44), 1.0f));
                positiveButton.setTextColor(Color.parseColor("#439AFC"));
                positiveButton.setBackgroundResource(R.drawable.dialog_button);
                positiveButton.setText(textPositiveButton);
                positiveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickListenerPositiveButton.onClick(IosDialog.this, v);
                    }
                });
                layoutButton.addView(positiveButton);
            }
        }

        final int viewWidth = dip2px(mContext, 300);
        layout.setMinimumWidth(viewWidth);
        setContentView(layout);
        setCanceledOnTouchOutside(canceledOnTouchOutside);
        return this;
    }

    private int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public interface OnClickListener {
        void onClick(IosDialog dialog, View v);
    }
}

