package com.kanishk.prototypes.mvvm_sample.View.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.gms.maps.model.Dash;
import com.kanishk.prototypes.mvvm_sample.Bus.Event.DashboardEvent;
import com.kanishk.prototypes.mvvm_sample.Bus.Event.IntentEvent;
import com.kanishk.prototypes.mvvm_sample.Data.ApplicationManager;
import com.kanishk.prototypes.mvvm_sample.Model.DashboardItem;
import com.kanishk.prototypes.mvvm_sample.R;
import com.kanishk.prototypes.mvvm_sample.Utils.GridItemDecoration;
import com.kanishk.prototypes.mvvm_sample.View.adapter.DashboardItemAdapter;
import com.kanishk.prototypes.mvvm_sample.ViewModel.HomeActivityViewModel;
import com.kanishk.prototypes.mvvm_sample.databinding.ActivityHomeBinding;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity implements IntentEvent, DashboardEvent {

    private final Context context = HomeActivity.this;
    private RecyclerView dashboardRecyclerView;
    private DashboardItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupDashboardRecyclerView();
    }

    private void setupDashboardRecyclerView() {
        Toast.makeText(context, "2", Toast.LENGTH_SHORT).show();
        dashboardRecyclerView = (RecyclerView) findViewById(R.id.home_activity_dashboard);
        GridLayoutManager grid = new GridLayoutManager(context, 3);
        grid.setReverseLayout(true);
        dashboardRecyclerView.setLayoutManager(grid);
        dashboardRecyclerView.setHasFixedSize(true);
        dashboardRecyclerView.setItemAnimator(new DefaultItemAnimator());
        dashboardRecyclerView.setNestedScrollingEnabled(false);
        dashboardRecyclerView.addItemDecoration(new GridItemDecoration(3, 0, true));
        ApplicationManager.getDashboardItems(context);
    }

    @Override
    public void setupBindings() {
        super.setupBindings();
        ActivityHomeBinding activityHomeBinding = DataBindingUtil.setContentView(this, getLayoutId());
        activityHomeBinding.setViewModel(new HomeActivityViewModel(context));
    }

    @Override
    public void setUpViews() {
        super.setUpViews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void setToolbarListeners() {
        mToolbar.inflateMenu(R.menu.main_menu);
        mToolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.action_profile) {
                Toast.makeText(context, "helo", Toast.LENGTH_SHORT).show();
            }
            return true;
        });
    }

    @Override
    public void onIntentReceived(Intent intent) {
        startActivityForResult(intent, 1);
    }

    @Override
    public void onDashboardReceived(ArrayList<DashboardItem> list) {
        Toast.makeText(context, "1", Toast.LENGTH_SHORT).show();
        adapter = new DashboardItemAdapter(context, list);
        dashboardRecyclerView.setAdapter(adapter);
    }
}
