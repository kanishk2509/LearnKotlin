package com.kanishk.prototypes.mvvm_sample.View.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kanishk.prototypes.mvvm_sample.Model.DashboardItem;
import com.kanishk.prototypes.mvvm_sample.Model.Post;
import com.kanishk.prototypes.mvvm_sample.R;
import com.kanishk.prototypes.mvvm_sample.ViewModel.DashboardItemViewModel;
import com.kanishk.prototypes.mvvm_sample.databinding.ItemDashboardRowBinding;
import com.kanishk.prototypes.mvvm_sample.databinding.ItemPostRowBinding;

import java.util.ArrayList;

/**
 * Created by kanishk on 03/06/17.
 */

public class DashboardItemAdapter extends RecyclerView.Adapter<DashboardItemAdapter.DashboardItemAdapterViewHolder> {

    private ArrayList<DashboardItem> list = new ArrayList<>();
    private Context context;

    public DashboardItemAdapter(Context context, ArrayList<DashboardItem> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public DashboardItemAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemDashboardRowBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_dashboard_row, parent, false);
        return new DashboardItemAdapterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(DashboardItemAdapterViewHolder holder, int position) {
        ItemDashboardRowBinding binding = holder.binding;
        binding.setViewModel(new DashboardItemViewModel(context, list.get(position)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class DashboardItemAdapterViewHolder extends RecyclerView.ViewHolder {
        ItemDashboardRowBinding binding;
        DashboardItemAdapterViewHolder(ItemDashboardRowBinding binding) {
            super(binding.content);
            this.binding = binding;
        }
    }
}
