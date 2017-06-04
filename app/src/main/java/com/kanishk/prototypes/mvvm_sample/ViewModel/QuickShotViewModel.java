package com.kanishk.prototypes.mvvm_sample.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;

import com.kanishk.prototypes.mvvm_sample.Model.Quickshot;

/**
 * Created by kanishk on 4/6/17.
 */

public class QuickShotViewModel extends BaseObservable {
    private Quickshot quickshot;
    private Context context;

    public QuickShotViewModel(Context context, Quickshot quickshot) {
        this.context = context;
        this.quickshot = quickshot;
    }

    public String getQuickshotImage() {
        return quickshot.getPath();
    }
}
