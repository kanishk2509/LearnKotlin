package com.kanishk.prototypes.mvvm_sample.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.renderscript.BaseObj;

/**
 * Created by kanishk on 03/06/17.
 */

public class HomeActivityViewModel extends BaseObservable {
    private Context context;
    public HomeActivityViewModel(Context context) {
        this.context = context;
    }
}
