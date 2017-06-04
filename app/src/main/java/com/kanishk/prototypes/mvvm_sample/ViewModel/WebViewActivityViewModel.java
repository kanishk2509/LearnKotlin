package com.kanishk.prototypes.mvvm_sample.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;

import com.kanishk.prototypes.mvvm_sample.Model.ActivityBlob;

/**
 * Created by kanishk on 4/6/17.
 */

public class WebViewActivityViewModel extends BaseObservable {

    private Context context;
    String title;
    String banner;
    String banner_sub;
    int banner_image;

    public WebViewActivityViewModel(Context context, ActivityBlob blob) {
        this.context = context;
        this.title = blob.getTitle();
        this.banner = blob.getBanner();
        this.banner_sub = blob.getBanner_sub();
        this.banner_image = blob.getBanner_image();
    }

    public Context getContext() {
        return context;
    }

    public String getBanner() {
        return this.banner;
    }

    public String getBanner_sub() {
        return this.banner_sub;
    }

    public int getBanner_image() {
        return this.banner_image;
    }

    public String getTitle() {
        return this.title;
    }
}
