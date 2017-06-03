package com.kanishk.prototypes.mvvm_sample.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.view.View;

import com.kanishk.prototypes.mvvm_sample.Data.IntentManager;
import com.kanishk.prototypes.mvvm_sample.Model.DashboardItem;

/**
 * Created by kanishk on 03/06/17.
 */

public class DashboardItemViewModel extends BaseObservable {

    private Context context;
    private DashboardItem dashBoardItem;

    public DashboardItemViewModel(Context context, DashboardItem dashBoardItem) {
        this.context = context;
        this.dashBoardItem = dashBoardItem;
    }

    public String getName() {
        return dashBoardItem.getDashboardItemName();
    }

    public int getPhoto() {
        return dashBoardItem.getDashboardItemPhoto();
    }

    public View.OnClickListener onClickDashboardItem() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentManager.moveToDashboardItemActivity(context);
            }
        };
    }

}
