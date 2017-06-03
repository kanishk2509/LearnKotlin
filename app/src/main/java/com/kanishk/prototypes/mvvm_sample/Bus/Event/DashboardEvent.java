package com.kanishk.prototypes.mvvm_sample.Bus.Event;

import com.kanishk.prototypes.mvvm_sample.Model.DashboardItem;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by kanishk on 03/06/17.
 */

public interface DashboardEvent {
    void onDashboardReceived(ArrayList<DashboardItem> list);
}
