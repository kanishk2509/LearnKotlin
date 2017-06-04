package com.kanishk.prototypes.mvvm_sample.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.net.Uri;
import android.view.View;

import com.kanishk.prototypes.mvvm_sample.Data.ApplicationManager;
import com.kanishk.prototypes.mvvm_sample.Model.Video;

/**
 * Created by kanishk on 3/6/17.
 */

public class VideoViewModel extends BaseObservable {

    private Context context;
    private Video video;

    public VideoViewModel(Context context, Video video) {
        this.context = context;
        this.video = video;
    }

    public String getTitle() {
        return video.getTitle();
    }

    public String getSerial() {
        return video.getSerial();
    }

    public String getUrl() {
        return ApplicationManager.YOUTUBE_URL + video.getUrl();
    }

    public String getThumbnail() {
        return ApplicationManager.YOUTUBE_URL_THUMBNAIL + video.getUrl() + "/0.jpg";
    }

    public View.OnClickListener onClickVideo() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sayHello();
            }
        };
    }

    private void sayHello() {
        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getUrl())).putExtra("force_fullscreen",true));
    }
}
