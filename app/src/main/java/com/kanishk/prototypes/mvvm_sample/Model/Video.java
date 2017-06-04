package com.kanishk.prototypes.mvvm_sample.Model;

/**
 * Created by kanishk on 3/6/17.
 */

public class Video {

    public String serial;
    public String title;
    public String url;

    public Video(String serial, String title, String url) {
        this.serial = serial;
        this.title = title;
        this.url = url;
    }

    public String getSerial() {
        return serial;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
