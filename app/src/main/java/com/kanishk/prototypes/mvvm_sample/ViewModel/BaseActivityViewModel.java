package com.kanishk.prototypes.mvvm_sample.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;

/**
 * Created by kanishk on 03/06/17.
 */

public class BaseActivityViewModel extends BaseObservable {
    private Context context;
    public BaseActivityViewModel(Context context) {
        this.context = context;
    }
}
