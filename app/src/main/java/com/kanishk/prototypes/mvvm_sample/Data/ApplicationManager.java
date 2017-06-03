package com.kanishk.prototypes.mvvm_sample.Data;

import android.content.Context;

import com.kanishk.prototypes.mvvm_sample.Bus.Event.DashboardEvent;
import com.kanishk.prototypes.mvvm_sample.Model.DashboardItem;
import com.kanishk.prototypes.mvvm_sample.R;

import java.util.ArrayList;

/**
 * Created by kanishk on 03/06/17.
 */

public class ApplicationManager {

    public static void getDashboardItems(Context context) {
        DashboardEvent event = (DashboardEvent) context;
        ArrayList<DashboardItem> list = new ArrayList<>();
        list.add(new DashboardItem(R.drawable.ic_close_circle_grey600_24dp, "Kotlin to Java"));
        list.add(new DashboardItem(R.drawable.ic_three, "Kotlin to Java"));
        list.add(new DashboardItem(R.drawable.ic_two, "Kotlin to Java"));
        list.add(new DashboardItem(R.drawable.ic_five, "Kotlin to Java"));
        list.add(new DashboardItem(R.drawable.ic_four, "Kotlin to Java"));
        list.add(new DashboardItem(R.drawable.ic_two, "Kotlin to Java"));
        event.onDashboardReceived(list);
    }
}
