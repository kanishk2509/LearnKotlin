package com.kanishk.prototypes.mvvm_sample.Data;

import android.content.Context;
import android.content.Intent;

import com.kanishk.prototypes.mvvm_sample.Bus.Event.IntentEvent;
import com.kanishk.prototypes.mvvm_sample.View.activity.LessonActivity;
import com.kanishk.prototypes.mvvm_sample.View.activity.MainActivity;

/**
 * Created by kanishk on 03/06/17.
 */

public class IntentManager {

    public static void moveToDashboardItemActivity(Context activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        intent.putExtra("type", ApplicationManager.ACTIVITY_TUTORIAL_VID);
        IntentEvent event = (IntentEvent) activity;
        event.onIntentReceived(intent);
    }

    public static void moveToTutorialVideoActivity(Context activity) {
        Intent intent_tutorial = new Intent(activity, MainActivity.class);
        intent_tutorial.putExtra("type", ApplicationManager.ACTIVITY_TUTORIAL_VID);
        IntentEvent event = (IntentEvent) activity;
        event.onIntentReceived(intent_tutorial);
    }

    public static void moveToApiRefActivity(Context activity) {
        Intent intent_apiref = new Intent(activity, MainActivity.class);
        intent_apiref.putExtra("type", ApplicationManager.ACTIVITY_API_REF);
        IntentEvent event = (IntentEvent) activity;
        event.onIntentReceived(intent_apiref);
    }

    public static void moveToQuickShotActivity(Context activity) {
        Intent intent_quickshot = new Intent(activity, MainActivity.class);
        intent_quickshot.putExtra("type", ApplicationManager.ACTIVITY_QUICKSHOTS);
        IntentEvent event = (IntentEvent) activity;
        event.onIntentReceived(intent_quickshot);
    }

    public static void moveToLessonActivity(Context activity) {
        Intent intent_lesson = new Intent(activity, LessonActivity.class);
        intent_lesson.putExtra("type", ApplicationManager.ACTIVITY_JAVA_TO_KOTLIN);
        IntentEvent event = (IntentEvent) activity;
        event.onIntentReceived(intent_lesson);
    }

    public static void moveToSlideshowFragment(Context activity, int position) {
        Intent intent_lesson = new Intent(activity, LessonActivity.class);
        intent_lesson.putExtra("type", ApplicationManager.FRAGMENT_SLIDESHOW);
        intent_lesson.putExtra("position", position);
        IntentEvent event = (IntentEvent) activity;
        event.onIntentReceived(intent_lesson);
    }
}
