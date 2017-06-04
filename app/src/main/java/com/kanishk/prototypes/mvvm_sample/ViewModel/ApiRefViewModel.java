package com.kanishk.prototypes.mvvm_sample.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.view.View;

import com.kanishk.prototypes.mvvm_sample.Data.ApplicationManager;
import com.kanishk.prototypes.mvvm_sample.Model.ApiRef;
import com.kanishk.prototypes.mvvm_sample.View.activity.WebViewActivity;

/**
 * Created by kanishk on 4/6/17.
 */

public class ApiRefViewModel extends BaseObservable {

    private Context context;
    private ApiRef apiRef;

    public ApiRefViewModel(Context context, ApiRef apiRef) {
        this.context = context;
        this.apiRef = apiRef;
    }

    public String getTitle() {
        return apiRef.getTitle();
    }

    public String getSerial() {
        return apiRef.getSerial();
    }

    public String getUrl() {
        return apiRef.getUrl();
    }

    public String getThumbnail() {
        return ApplicationManager.YOUTUBE_URL_THUMBNAIL + apiRef.getUrl() + "/0.jpg";
    }

    public View.OnClickListener onClick() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayHello();
            }
        };
    }

    private void sayHello() {
       context.startActivity(new Intent(context, WebViewActivity.class).putExtra("url", getUrl()));
    }
}