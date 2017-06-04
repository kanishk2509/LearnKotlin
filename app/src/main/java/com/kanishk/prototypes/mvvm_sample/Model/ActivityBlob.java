package com.kanishk.prototypes.mvvm_sample.Model;

/**
 * Created by kanishk on 4/6/17.
 */

public class ActivityBlob {
    String title;
    String banner;
    String banner_sub;
    int banner_image;

    public ActivityBlob(String title, String banner, String banner_sub, int banner_image) {
        this.title = title;
        this.banner = banner;
        this.banner_sub = banner_sub;
        this.banner_image = banner_image;
    }


    public String getTitle() {
        return title;
    }

    public String getBanner() {
        return banner;
    }

    public String getBanner_sub() {
        return banner_sub;
    }

    public int getBanner_image() {
        return banner_image;
    }
}
