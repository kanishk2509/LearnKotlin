package com.kanishk.prototypes.mvvm_sample.View.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kanishk.prototypes.mvvm_sample.Model.ApiRef;
import com.kanishk.prototypes.mvvm_sample.R;
import com.kanishk.prototypes.mvvm_sample.ViewModel.ApiRefViewModel;
import com.kanishk.prototypes.mvvm_sample.databinding.ItemApiRefBinding;

import java.util.ArrayList;

/**
 * Created by kanishk on 4/6/17.
 */

public class ApiRefAdapter extends RecyclerView.Adapter<ApiRefAdapter.ApiRefBindingHolder> {

    private ArrayList<ApiRef> list = new ArrayList<>();
    private Context context;

    public ApiRefAdapter(Context context, ArrayList<ApiRef> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public ApiRefBindingHolder onCreateViewHolder(ViewGroup parent, int i) {
        ItemApiRefBinding postBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_api_ref,
                parent,
                false);
        return new ApiRefAdapter.ApiRefBindingHolder(postBinding);
    }

    @Override
    public void onBindViewHolder(ApiRefBindingHolder apiRefBindingHolder, int i) {
        ItemApiRefBinding binding = apiRefBindingHolder.binding;
        binding.setViewModel(new ApiRefViewModel(context, list.get(i)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ApiRefBindingHolder extends RecyclerView.ViewHolder {

        ItemApiRefBinding binding;

        ApiRefBindingHolder(ItemApiRefBinding binding) {
            super(binding.content);
            this.binding = binding;
        }
    }
}
