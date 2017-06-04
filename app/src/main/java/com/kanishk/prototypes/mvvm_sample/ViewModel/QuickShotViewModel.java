package com.kanishk.prototypes.mvvm_sample.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;

import com.kanishk.prototypes.mvvm_sample.Data.IntentManager;
import com.kanishk.prototypes.mvvm_sample.Model.Quickshot;

import java.util.ArrayList;

/**
 * Created by kanishk on 4/6/17.
 */

public class QuickShotViewModel extends BaseObservable {
    private Quickshot quickshot;
    private Context context;
    private ArrayList<Quickshot> list = new ArrayList<>();
    int position;

    public QuickShotViewModel(Context context, Quickshot quickshot, ArrayList<Quickshot> list, int position) {
        this.context = context;
        this.quickshot = quickshot;
        this.list = list;
        this.position = position;
    }

    public String getQuickshotImage() {
        return quickshot.getPath();
    }

    public View.OnClickListener onClickQuickshot() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 4/6/17 add transition to slideshow dialog fragment
                showSlideshow();
            }

            private void showSlideshow() {
                IntentManager.moveToSlideshowFragment(context, position);
            }
        };
    }
}
