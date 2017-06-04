package com.kanishk.prototypes.mvvm_sample.Model;

/**
 * Created by kanishk on 4/6/17.
 */

public class ApiRef {

    public String serial;
    public String title;
    public String url;

    public ApiRef(String serial, String title, String url) {
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
