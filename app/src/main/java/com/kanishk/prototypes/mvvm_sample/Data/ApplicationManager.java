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

    public static final String YOUTUBE_URL_THUMBNAIL = "https://img.youtube.com/vi/";
    public static final String YOUTUBE_URL = "https://www.youtube.com/watch?v=";

    public static final String ACTIVITY_JAVA_TO_KOTLIN = "Java to Kotlin";
    public static final String ACTIVITY_API_REF = "API Reference";
    public static final String ACTIVITY_TUTORIAL_VID = "Videos";
    public static final String ACTIVITY_COMMUNITY = "Community";
    public static final String ACTIVITY_PROGRAMS = "Programs";
    public static final String ACTIVITY_QUICKSHOTS = "Quickshots";

    public static final String FRAGMENT_SLIDESHOW = "fragment_slideshow";

    public static void getDashboardItems(Context context) {
        DashboardEvent event = (DashboardEvent) context;
        ArrayList<DashboardItem> list = new ArrayList<>();
        list.add(new DashboardItem(R.drawable.ic_alphabet, ACTIVITY_JAVA_TO_KOTLIN));
        list.add(new DashboardItem(R.drawable.ic_book, ACTIVITY_API_REF));
        list.add(new DashboardItem(R.drawable.ic_lamp, ACTIVITY_QUICKSHOTS));
        list.add(new DashboardItem(R.drawable.ic_laptop, ACTIVITY_TUTORIAL_VID));
        list.add(new DashboardItem(R.drawable.ic_diploma, ACTIVITY_COMMUNITY));
        list.add(new DashboardItem(R.drawable.ic_keyboard, ACTIVITY_PROGRAMS));
        event.onDashboardReceived(list);
    }


}
