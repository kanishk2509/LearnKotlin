package com.kanishk.prototypes.mvvm_sample.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;

import com.kanishk.prototypes.mvvm_sample.Model.ActivityBlob;

/**
 * Created by kanishk on 31/05/17.
 */

public class MainActivityViewModel extends BaseObservable {

    private Context context;
    String title;
    String banner;
    String banner_sub;
    int banner_image;

    public MainActivityViewModel(Context context, ActivityBlob blob) {
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

    public View.OnClickListener onClickAddPost() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //PostDataManager.getNewPosts(context);
            }
        };
    }
}
