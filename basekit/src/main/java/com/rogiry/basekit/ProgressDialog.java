package com.rogiry.basekit;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialog;
import android.text.TextUtils;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pen9uin on 2017. 6. 5..
 */

public class ProgressDialog extends AppCompatDialog {
    private ProgressBar progress_bar;
    private ImageView progress_img_view;
    private TextView progress_textView;
    private BaseActivity.ImageLoader loader;

    private boolean setContent = false;

    private void init() {
        this.setCancelable(false);
        this.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        bindView();
    }
    private void bindView() {
        progress_bar = (ProgressBar) findViewById(R.id.pb_progress_bar);
        progress_img_view = (ImageView) findViewById(R.id.iv_progress_img);
    }

    public ProgressDialog(Context context) {
        super(context);
        init();
    }

    public ProgressDialog(Context context, int theme) {
        super(context, theme);
        init();
    }

    public ProgressDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    public ProgressDialog(Context context, BaseActivity.ImageLoader loader) {
        super(context);
        this.loader = loader;
        init();
    }

    public ProgressDialog(Context context, int theme, BaseActivity.ImageLoader loader) {
        super(context, theme);
        this.loader = loader;
        init();
    }

    public ProgressDialog(Context context, boolean cancelable, OnCancelListener cancelListener, BaseActivity.ImageLoader loader) {
        super(context, cancelable, cancelListener);
        this.loader = loader;
        init();
    }

    @Override
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, @Nullable Menu menu, int deviceId) {

    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        this.setContent = true;
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        this.setContent = true;
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        this.setContent = true;
    }

    public ProgressDialog setImageLoader(BaseActivity.ImageLoader loader) {
        this.loader = loader;
        return this;
    }

    public ProgressDialog setProgressImage(@DrawableRes int drawableId) {
        if (loader == null) {
            setImageViewToggle(true);
            progress_img_view.setImageResource(drawableId);
        }
        else
            this.loader.setImage(progress_img_view);

        return this;
    }

    public void setProgressMessge(String message) {
        TextView tv_progress_message = (TextView) this.findViewById(R.id.tv_progress_message);
        if (!TextUtils.isEmpty(message)) {
            tv_progress_message.setText(message);
        }
    }

    public TextView getProgressTextView() {
        return this.progress_textView;
    }

    public ImageView getProgress_img_view() {
        return progress_img_view;
    }

    public void unsetProgressImage() {
        setImageViewToggle(false);
    }

    private void setImageViewToggle(boolean toggle) {
        progress_bar.setVisibility(toggle ? View.GONE : View.VISIBLE);
        progress_img_view.setVisibility(toggle ? View.VISIBLE : View.GONE);
    }

    @Override
    public void show() {
        if(!this.setContent)
            this.setContentView(R.layout.progress_loading);
        super.show();
    }

    @Override
    public void setOnDismissListener(@Nullable OnDismissListener listener) {
        unsetProgressImage();
        super.setOnDismissListener(listener);
    }
}
