package com.kanishk.prototypes.mvvm_sample.Widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.TextView;

import com.kanishk.prototypes.mvvm_sample.Utils.FontCache;

/**
 * Created by kanishk on 4/6/17.
 */

public class SecondaryTextStyle extends TextView {

    public SecondaryTextStyle(Context context) {
        super(context);
        applyFont(context);
    }

    public SecondaryTextStyle(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyFont(context);
    }

    public SecondaryTextStyle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public SecondaryTextStyle(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        applyFont(context);
    }

    private void applyFont(Context context) {
        Typeface font = FontCache.getTypeface("fonts/Montserrat/Montserrat-Regular.ttf", context);
        setTypeface(font);
    }
}