package com.rogiry.basekit;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import android.widget.TextView;

/**
 * Created by pen9uin on 2017. 6. 5..
 */

public class BaseApplication extends Application {
    private static BaseApplication baseApplication;
    private ProgressDialog progressDialog;

    public static BaseApplication getInstance() {
        return baseApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
    }

    public void progressON(Activity activity, String message) {
        if (activity == null || activity.isFinishing())
            return;

        if (progressDialog != null && progressDialog.isShowing())
            progressSET(message);
        else {
            progressDialog = new ProgressDialog(activity);
            progressDialog.show();
        }

        progressDialog.setProgressMessge(message);
    }

    public void progressSET(String message) {
        if (progressDialog == null || !progressDialog.isShowing()) {
            return;
        }

        TextView tv_progress_message = (TextView) progressDialog.findViewById(R.id.tv_progress_message);
        if (!TextUtils.isEmpty(message)) {
            tv_progress_message.setText(message);
        }
    }

    public void progressOFF() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    public ProgressDialog getProgressDialog() {
        return progressDialog;
    }
}
