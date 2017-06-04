package com.kanishk.prototypes.mvvm_sample.View.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kanishk.prototypes.mvvm_sample.Model.Quickshot;
import com.kanishk.prototypes.mvvm_sample.R;
import com.kanishk.prototypes.mvvm_sample.ViewModel.QuickShotViewModel;
import com.kanishk.prototypes.mvvm_sample.databinding.ItemQuickshotGridBinding;

import java.util.ArrayList;

/**
 * Created by kanishk on 4/6/17.
 */

public class QuickShotAdapter extends RecyclerView.Adapter<QuickShotAdapter.QuickShotAdapterBindingHolder> {

    private Context context;
    private ArrayList<Quickshot> arrayList = new ArrayList<>();

    public QuickShotAdapter(Context context, ArrayList<Quickshot> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public QuickShotAdapterBindingHolder onCreateViewHolder(ViewGroup parent, int i) {
        ItemQuickshotGridBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_quickshot_grid,
                parent,
                false);
        return new QuickShotAdapterBindingHolder(binding);
    }

    @Override
    public void onBindViewHolder(QuickShotAdapterBindingHolder holder, int i) {
        ItemQuickshotGridBinding binding = holder.binding;
        binding.setViewModel(new QuickShotViewModel(context, arrayList.get(i)));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class QuickShotAdapterBindingHolder extends RecyclerView.ViewHolder {
        ItemQuickshotGridBinding binding;
        public QuickShotAdapterBindingHolder(ItemQuickshotGridBinding binding) {
            super(binding.content);
            this.binding = binding;
        }
    }
}
