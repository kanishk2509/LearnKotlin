package com.kanishk.prototypes.mvvm_sample.View.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kanishk.prototypes.mvvm_sample.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
