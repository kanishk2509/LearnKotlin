package com.kanishk.prototypes.mvvm_sample.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;

import com.kanishk.prototypes.mvvm_sample.Data.ApplicationManager;
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
                switch ((getName())) {
                    case ApplicationManager.ACTIVITY_TUTORIAL_VID :
                        IntentManager.moveToTutorialVideoActivity(context);
                        break;
                    case ApplicationManager.ACTIVITY_API_REF :
                        IntentManager.moveToApiRefActivity(context);
                        break;
                    case ApplicationManager.ACTIVITY_QUICKSHOTS :
                        IntentManager.moveToQuickShotActivity(context);
                        break;
                    case ApplicationManager.ACTIVITY_JAVA_TO_KOTLIN :
                        IntentManager.moveToLessonActivity(context);
                        break;
                }
            }
        };
    }

}
