package com.kanishk.prototypes.mvvm_sample.Data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.kanishk.prototypes.mvvm_sample.Bus.Event.IntentEvent;
import com.kanishk.prototypes.mvvm_sample.View.activity.MainActivity;

/**
 * Created by kanishk on 03/06/17.
 */

public class IntentManager {
    public static void moveToDashboardItemActivity(Context activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        intent.putExtra("move_to", "DashboardItemActivity");
        IntentEvent event = (IntentEvent) activity;
        event.onIntentReceived(intent);
    }
}
