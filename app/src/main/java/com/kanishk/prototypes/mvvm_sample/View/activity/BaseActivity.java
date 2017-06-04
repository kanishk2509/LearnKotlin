package com.kanishk.prototypes.mvvm_sample.View.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.claudiodegio.msv.BaseMaterialSearchView;
import com.kanishk.prototypes.mvvm_sample.R;

public abstract class BaseActivity extends AppCompatActivity {

    private static String bufferString;
    private BaseMaterialSearchView mSearchView;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupBindings();
        setUpViews();
        setToolbarListeners();
    }

    protected abstract void setToolbarListeners();

    public void setUpViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar_home);
        mSearchView = (BaseMaterialSearchView) findViewById(R.id.sv);
    }

    public void setupBindings() {
    }

    public int getLayoutId() {
        return R.layout.activity_base;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
        mSearchView.setMenuItem(menu.findItem(R.id.action_search));
        return true;
    }
}
