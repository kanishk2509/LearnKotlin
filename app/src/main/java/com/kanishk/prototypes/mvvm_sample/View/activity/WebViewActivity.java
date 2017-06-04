package com.kanishk.prototypes.mvvm_sample.View.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.widget.EditText;
import android.widget.Toast;

import com.kanishk.prototypes.mvvm_sample.R;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import im.delight.android.webview.AdvancedWebView;

public class WebViewActivity extends AppCompatActivity implements AdvancedWebView.Listener {

    private AdvancedWebView mWebView;
    private ProgressDialog progressDialog;
    private Toolbar toolbar;
    private Toolbar toolbarSetName;
    private EditText toolbarSetNameEditText;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        setupViews();
        initWebView(getIntent());
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setupViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_clip);
        toolbar.inflateMenu(R.menu.clipview_menu);

        toolbarSetName = (Toolbar) findViewById(R.id.toolbar_set_name);
        toolbarSetName.inflateMenu(R.menu.setquickshot_name_menu);
        toolbarSetName.setVisibility(View.GONE);
        toolbarSetNameEditText = (EditText) findViewById(R.id.set_name);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_search :
                        toolbarSetName.setVisibility(View.VISIBLE);
                        toolbarSetName.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                            @Override
                            public boolean onMenuItemClick(MenuItem menuItem) {
                                switch (menuItem.getItemId()) {
                                    case R.id.action_search :
                                        // TODO: 4/6/17 hide virtual keyboard
                                        toolbarSetName.setVisibility(View.GONE);
                                        Handler handler = new Handler();
                                        handler.postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                takeQuickshot(toolbarSetNameEditText.getText().toString());
                                            }
                                        }, 1000);
                                }
                                return true;
                            }
                        });
                }
                return true;
            }
            private void takeQuickshot(String name) {
                Date now = new Date();
                String mPath;
                android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);
                try {
                    if (name != null) {
                        mPath = Environment.getExternalStorageDirectory().toString() + "/PICTURES/Screenshots/" + "learn_kotlin_" + name + ".jpg";
                    } else {
                        mPath = Environment.getExternalStorageDirectory().toString() + "/PICTURES/Screenshots/" + "learn_kotlin_" + now + ".jpg";
                    }
                    Log.e("Saving to .. ", "" + mPath);
                    View v1 = getWindow().getDecorView().getRootView();
                    v1.setDrawingCacheEnabled(true);
                    Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
                    v1.setDrawingCacheEnabled(false);
                    File imageFile = new File(mPath);
                    FileOutputStream outputStream = new FileOutputStream(imageFile);
                    int quality = 100;
                    bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
                    outputStream.flush();
                    outputStream.close();
                    Toast.makeText(WebViewActivity.this, "Quickshot saved! You can view this later in 'Quickshots' section.", Toast.LENGTH_SHORT).show();
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initWebView(Intent intent) {
        mWebView = (AdvancedWebView) findViewById(R.id.webView);
        mWebView.setListener(this, this);
        mWebView.loadUrl(intent.getStringExtra("url"));
        mWebView.setDesktopMode(true);
        mWebView.setWebChromeClient(new WebChromeClient());
    }

    @Override
    public void onPageStarted(String s, Bitmap bitmap) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading content");
        progressDialog.show();
    }

    @Override
    public void onPageFinished(String s) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.hide();
        }
    }

    @Override
    public void onPageError(int i, String s, String s1) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.hide();
        }
    }

    @Override
    public void onDownloadRequested(String s, String s1, String s2, long l, String s3, String s4) {

    }

    @Override
    public void onExternalPageRequest(String s) {

    }
}
