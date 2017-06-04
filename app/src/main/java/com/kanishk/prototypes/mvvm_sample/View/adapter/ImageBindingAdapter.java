package com.kanishk.prototypes.mvvm_sample.View.adapter;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

/**
 * Created by kanishk on 3/6/17.
 */

public class ImageBindingAdapter {

    @BindingAdapter({"url"})
    public static void loadImage(ImageView imageView, String url)
    {
        Glide.with(imageView.getContext()).load(url).thumbnail(0.2f).into(imageView);
    }

    @BindingAdapter({"local_path"})
    public static void loadLocalImage(ImageView imageView, String url)
    {
        File file = new File(url);
        Uri imageUri = Uri.fromFile(file);
        Glide.with(imageView.getContext()).load(imageUri).thumbnail(0.2f).into(imageView);
    }
}
