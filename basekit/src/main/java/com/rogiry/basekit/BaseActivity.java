package com.rogiry.basekit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by pen9uin on 2017. 6. 5..
 */

public class BaseActivity extends AppCompatActivity {
    ImageLoader loader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void progressON() {
        BaseApplication.getInstance().progressON(this, null);
    }

    public void progressON(String msg) {
        BaseApplication.getInstance().progressON(this, msg);
    }

    public void progressOFF() {
        BaseApplication.getInstance().progressOFF();
    }

    public void progressON(ImageLoader imageLoader) {
        BaseApplication.getInstance()
                .getProgressDialog()
                .setImageLoader(imageLoader)
                .show();
    }

    public void progressON(ImageLoader imageLoader, String msg) {
        BaseApplication.getInstance()
                .getProgressDialog()
                .setImageLoader(imageLoader)
                .show();
    }

    public interface ImageLoader {
        void setImage(ImageView view);
    }
}
