package com.kanishk.prototypes.mvvm_sample.View.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kanishk.prototypes.mvvm_sample.Model.Video;
import com.kanishk.prototypes.mvvm_sample.R;
import com.kanishk.prototypes.mvvm_sample.ViewModel.VideoViewModel;
import com.kanishk.prototypes.mvvm_sample.databinding.ItemYoutubeRowBinding;

import java.util.ArrayList;

/**
 * Created by kanishk on 3/6/17.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoAdapterBindingHolder> {

    private ArrayList<Video> list = new ArrayList<>();
    private Context context;

    public VideoAdapter(Context context, ArrayList<Video> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public VideoAdapter.VideoAdapterBindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemYoutubeRowBinding postBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_youtube_row,
                parent,
                false);
        return new VideoAdapter.VideoAdapterBindingHolder(postBinding);
    }

    @Override
    public void onBindViewHolder(VideoAdapterBindingHolder holder, int i) {
        ItemYoutubeRowBinding binding = holder.binding;
        binding.setViewModel(new VideoViewModel(context, list.get(i)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class VideoAdapterBindingHolder extends RecyclerView.ViewHolder {

        ItemYoutubeRowBinding binding;

        VideoAdapterBindingHolder(ItemYoutubeRowBinding binding) {
            super(binding.content);
            this.binding = binding;
        }
    }
}