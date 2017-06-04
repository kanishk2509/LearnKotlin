package com.kanishk.prototypes.mvvm_sample.View.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kanishk.prototypes.mvvm_sample.Model.Quickshot;
import com.kanishk.prototypes.mvvm_sample.Model.Slideshow;
import com.kanishk.prototypes.mvvm_sample.R;
import com.kanishk.prototypes.mvvm_sample.ViewModel.SlideshowDialogViewModel;
import com.kanishk.prototypes.mvvm_sample.databinding.ImageFullscreenPreviewBinding;

import java.util.ArrayList;

/**
 * Created by kanishk on 4/6/17.
 */

public class SlideshowDialogFragment extends DialogFragment {

    private String TAG = SlideshowDialogFragment.class.getSimpleName();
    private ArrayList<?> images;
    private ViewPager viewPager;
    private SlideshowPagerAdapter myViewPagerAdapter;
    private int selectedPosition = 0;
    private String forObject;

    private boolean show = true;
    private boolean backToFrag;

    public static SlideshowDialogFragment newInstance() {
        SlideshowDialogFragment f = new SlideshowDialogFragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        forObject = getArguments().getString("for");
        assert forObject != null;
        if (forObject.equals("image")) {
            images = (ArrayList<Slideshow>) getArguments().getSerializable("images");
            selectedPosition = getArguments().getInt("position");
        }

        View v = inflater.inflate(R.layout.fragment_slideshow_dialog, container, false);
        viewPager = (ViewPager) v.findViewById(R.id.viewpager);

        Log.e(TAG, "position: " + selectedPosition);
        Log.e(TAG, "images size: " + images.size());
        Log.e(TAG, "for object: " + forObject);

        myViewPagerAdapter = new SlideshowPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        setCurrentItem(selectedPosition);
        return v;
    }

    private void setCurrentItem(int position) {
        viewPager.setCurrentItem(position, false);
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public class SlideshowPagerAdapter extends PagerAdapter {

        private LayoutInflater layoutInflater;

        public SlideshowPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageFullscreenPreviewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(container.getContext()), R.layout.image_fullscreen_preview, container, false);
            binding.setViewModel(new SlideshowDialogViewModel((Quickshot)images.get(position), getContext(), position));
            container.addView(binding.getRoot());
            return binding.getRoot();
        }

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == ((View) obj);
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }
}
