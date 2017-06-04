package com.kanishk.prototypes.mvvm_sample.View.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.kanishk.prototypes.mvvm_sample.Model.Content;
import com.kanishk.prototypes.mvvm_sample.Model.Points;
import com.kanishk.prototypes.mvvm_sample.Model.Row;
import com.kanishk.prototypes.mvvm_sample.R;
import com.kanishk.prototypes.mvvm_sample.Utils.GridItemDecoration;
import com.kanishk.prototypes.mvvm_sample.View.adapter.ContentAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class LessonActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Row> rows=new ArrayList<>();
    ContentAdapter adapter;
    String jc="",jc1="";
    String he="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        recyclerView= (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager grid = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(grid);
        try{
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONObject o= (JSONObject) obj.getJSONObject("1");
            he=o.getString("heading");
            JSONArray ja=o.getJSONArray("content");
            Log.d("one",ja.toString());
            JSONObject jo=ja.getJSONObject(0);
            Log.d("two",jo.toString());
            JSONObject jo1=jo.getJSONObject("description");
            Log.d("three",jo1.toString());
            JSONArray ja1=jo1.getJSONArray("points");
            Log.d("four",ja1.toString());
            JSONObject jo2=ja1.getJSONObject(0);
            Log.d("five",jo2.toString());
            jc=jo2.getString("java_code");
            Log.d("six",jc);
            jc1=jo2.getString("kotlin_code");
        }
        catch (JSONException e){
            Log.d("error",e.getMessage());
        }

        ArrayList<Points> p1=new ArrayList<>();
        Points p=new Points("","",jc,jc1);
        p1.add(p);
        p1.add(p);

        ArrayList<Content> con1=new ArrayList<>();
        Content c1=new Content("","",p1);
        con1.add(c1);
        con1.add(c1);

        Row row1=new Row(con1);

        rows.add(row1);
        rows.add(row1);

        recyclerView.addItemDecoration(new GridItemDecoration(1, 4, true));
        recyclerView.setNestedScrollingEnabled(false);

        adapter=new ContentAdapter(rows,this,recyclerView);
        recyclerView.setAdapter(adapter);
    }
    public String loadJSONFromAsset(){
        String json = null;
        try {
            InputStream is = LessonActivity.this.getAssets().open("json/1.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        //Toast.makeText(MainActivity.this,""+json,2000).show();
        return json;

    }

}
