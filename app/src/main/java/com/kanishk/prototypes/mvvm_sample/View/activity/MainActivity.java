package com.kanishk.prototypes.mvvm_sample.View.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.kanishk.prototypes.mvvm_sample.Bus.Event.PostEvent;
import com.kanishk.prototypes.mvvm_sample.Bus.EventModel.PostEventModel;
import com.kanishk.prototypes.mvvm_sample.Data.ApplicationManager;
import com.kanishk.prototypes.mvvm_sample.Data.PostDataManager;
import com.kanishk.prototypes.mvvm_sample.Model.ActivityBlob;
import com.kanishk.prototypes.mvvm_sample.R;
import com.kanishk.prototypes.mvvm_sample.Utils.GridItemDecoration;
import com.kanishk.prototypes.mvvm_sample.View.adapter.ApiRefAdapter;
import com.kanishk.prototypes.mvvm_sample.View.adapter.PostAdapter;
import com.kanishk.prototypes.mvvm_sample.View.adapter.QuickShotAdapter;
import com.kanishk.prototypes.mvvm_sample.View.adapter.VideoAdapter;
import com.kanishk.prototypes.mvvm_sample.ViewModel.MainActivityViewModel;
import com.kanishk.prototypes.mvvm_sample.databinding.ActivityMainBinding;

import org.json.JSONException;

import java.io.IOException;

public class MainActivity extends BaseActivity implements PostEvent {

    private final Context context = MainActivity.this;

    private RecyclerView recyclerView;
    private PostAdapter adapter;
    private Toolbar toolbar;
    private ActivityMainBinding mainBinding;
    private PostDataManager postDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        evaluateIntent(getIntent());
    }

    @Override
    protected void setToolbarListeners() {
        toolbar.inflateMenu(R.menu.main_menu);
        toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.action_search) {
                Toast.makeText(context, "helo", Toast.LENGTH_SHORT).show();
            }
            return true;
        });
    }

    @Override
    public void setupBindings() {
        super.setupBindings();
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    private void evaluateIntent(Intent intent) {
        String type = intent.getStringExtra("type");
        switch (type) {

            case ApplicationManager.ACTIVITY_TUTORIAL_VID :
                try {
                    ActivityBlob blob = new ActivityBlob("Videos", "Quickly watch latest videos", "All videos are curated from youtube", R.drawable.ic_video_player_white);
                    mainBinding.setViewModel(new MainActivityViewModel(context, blob));
                    postDataManager = new PostDataManager();
                    postDataManager.getVideos(context);
                }
                catch (IOException | JSONException e) { e.printStackTrace(); }
                break;

            case ApplicationManager.ACTIVITY_API_REF :
                try {
                    ActivityBlob blob = new ActivityBlob("Api Reference", "Official API Documentation", "All the documentation is owned by kotlinlang.org", R.drawable.ic_search);
                    mainBinding.setViewModel(new MainActivityViewModel(context, blob));
                    postDataManager = new PostDataManager();
                    postDataManager.getApiRef(context);
                }
                catch (IOException e) { e.printStackTrace(); }
                catch (JSONException e) { e.printStackTrace(); }
                break;

            case ApplicationManager.ACTIVITY_QUICKSHOTS :
                try {
                    ActivityBlob blob = new ActivityBlob("Quickshots", "Quickshots by Learn Kotlin", "All your quickshots appear here", R.drawable.ic_camera_diaphragm);
                    mainBinding.setViewModel(new MainActivityViewModel(context, blob));
                    postDataManager = new PostDataManager();
                    postDataManager.getQuickShots(context);
                }
                catch (IOException e) { e.printStackTrace(); }
                catch (JSONException e) { e.printStackTrace(); }
                break;

        }
    }

    @Override
    public void setUpViews() {
        super.setUpViews();
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linear = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linear);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.addItemDecoration(new GridItemDecoration(1, 2, true));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    @Override
    public void onDataReceived(PostEventModel eventModel) {
        switch (eventModel.getType()) {
            case "Video" :
                VideoAdapter adapterVideo = new VideoAdapter(context, eventModel.getVideos());
                recyclerView.setAdapter(adapterVideo);
                postDataManager = null;
                break;
            case "Post" :
                PostAdapter adapterpost = new PostAdapter(context, eventModel.getPosts());
                recyclerView.setAdapter(adapterpost);
                postDataManager = null;
                break;
            case "ApiRef" :
                ApiRefAdapter apiRefAdapter = new ApiRefAdapter(context, eventModel.getApiRefs());
                recyclerView.setAdapter(apiRefAdapter);
                postDataManager = null;
                break;
            case "QuickShot" :
                QuickShotAdapter quickShotAdapter = new QuickShotAdapter(context, eventModel.getQuickshots());
                StaggeredGridLayoutManager grid = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(grid);
                recyclerView.setHasFixedSize(true);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setNestedScrollingEnabled(false);
                recyclerView.addItemDecoration(new GridItemDecoration(3, 0, false));
                recyclerView.setAdapter(quickShotAdapter);
                postDataManager = null;
                break;
        }
    }

    @Override
    public void onDataUpdate(PostEventModel eventModel) {
        adapter.addNewPost(eventModel.getPosts().get(0));
        recyclerView.smoothScrollToPosition(0);
    }
}
