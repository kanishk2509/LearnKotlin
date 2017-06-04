package com.kanishk.prototypes.mvvm_sample.Model;

/**
 * Created by kanishk on 4/6/17.
 */

public class Quickshot {
    private String title;
    private String path;

    public Quickshot(String title, String path) {
        this.title = title;
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public String getPath() {
        return path;
    }
}
