package com.kanishk.prototypes.mvvm_sample.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.util.Log;

import com.kanishk.prototypes.mvvm_sample.Model.Quickshot;

/**
 * Created by kanishk on 4/6/17.
 */

public class SlideshowDialogViewModel extends BaseObservable {
    private Quickshot quickshot;
    private Context context;
    private String title;
    private String path;
    private int position;

    public SlideshowDialogViewModel(Quickshot quickshot, Context context, int position) {
        this.quickshot = quickshot;
        this.context = context;
        this.title = quickshot.getTitle();
        Log.e("Quickshot Model", title);
        this.path = quickshot.getPath();
        Log.e("Quickshot Model", path);
        this.position = position;
    }

    public Quickshot getSlideshow() {
        return quickshot;
    }

    public Context getContext() {
        return context;
    }

    public String getTitle() {
        return this.title;
    }

    public String getPath() {
        return this.path;
    }

    public int getPosition() {
        return this.position;
    }
}
