package com.kanishk.prototypes.mvvm_sample.Data;

import android.content.Context;
import android.os.Environment;

import com.kanishk.prototypes.mvvm_sample.Bus.Event.PostEvent;
import com.kanishk.prototypes.mvvm_sample.Bus.EventModel.PostEventModel;
import com.kanishk.prototypes.mvvm_sample.Model.ApiRef;
import com.kanishk.prototypes.mvvm_sample.Model.Post;
import com.kanishk.prototypes.mvvm_sample.Model.Quickshot;
import com.kanishk.prototypes.mvvm_sample.Model.Video;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by kanishk on 31/05/17.
 */

public class PostDataManager {

    private File[] listFile;
    private String[] FilePathStrings, FileNameStrings;

    public void getPosts(Context c) {
        PostEvent events = (PostEvent) c;
        ArrayList<Post> list = new ArrayList<>();
        list.add(new Post("Post 1", "A new post using MVVM!", "kanishk"));
        list.add(new Post("Post 2", "A second post using MVVM!", "kanishk"));
        list.add(new Post("Post 3", "A third post using MVVM!", "kanishk"));
        list.add(new Post("Post 4", "A fourth post using MVVM!", "kanishk"));
        list.add(new Post("Post 5", "A fifth post using MVVM!", "kanishk"));
        PostEventModel eventModel = new PostEventModel("Post");
        eventModel.setPosts(list);
        events.onDataReceived(eventModel);
    }

    public void getNewPosts(Context c) {
        PostEvent events = (PostEvent) c;
        ArrayList<Post> list = new ArrayList<>();
        list.add(new Post("Post 1", "A new post using MVVM!", "kanishk"));
        PostEventModel eventModel = new PostEventModel("Post");
        eventModel.setPosts(list);
        events.onDataUpdate(eventModel);
    }

    public void getVideos(Context c) throws IOException, JSONException {
        PostEvent event = (PostEvent) c;
        ArrayList<Video> list = new ArrayList<>();
        InputStream is = c.getAssets().open("json/youtube.json");
        int size = is.available();
        byte[] buffer = new byte[size];
        is.read(buffer);
        is.close();
        String bufferString = new String(buffer);
        JSONObject object = new JSONObject(bufferString);
        JSONArray array = object.getJSONArray("videos");
        for (int i = 0; i < array.length(); i++) {
            JSONObject object1 = array.getJSONObject(i);
            list.add(new Video(object1.getString("serial"), object1.getString("title"), object1.getString("url")));
        }
        PostEventModel eventModel = new PostEventModel("Video");
        eventModel.setVideos(list);
        event.onDataReceived(eventModel);
    }

    public void getApiRef(Context c) throws IOException, JSONException {
        PostEvent event = (PostEvent) c;
        ArrayList<ApiRef> list = new ArrayList<>();
        InputStream isApi = c.getAssets().open("json/youtube.json");
        int size = isApi.available();
        byte[] buffer = new byte[size];
        isApi.read(buffer);
        isApi.close();
        String bufferString = new String(buffer);
        JSONObject object = new JSONObject(bufferString);
        JSONArray array = object.getJSONArray("ref");
        for (int i = 0; i < array.length(); i++) {
            JSONObject object1 = array.getJSONObject(i);
            list.add(new ApiRef(object1.getString("serial"), object1.getString("title"), object1.getString("url")));
        }
        PostEventModel eventModel = new PostEventModel("ApiRef");
        eventModel.setApiRefs(list);
        event.onDataReceived(eventModel);
    }

    public void getQuickShots(Context c) throws IOException, JSONException {
        PostEvent event = (PostEvent) c;
        ArrayList<Quickshot> list = new ArrayList<>();
        File file = new File(Environment.getExternalStorageDirectory() + File.separator + "/PICTURES/Screenshots");
        if (file.isDirectory()) {
            listFile = file.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File file, String s) {
                    return s.startsWith("learn_kotlin_");
                }
            });
            FilePathStrings = new String[listFile.length];
            FileNameStrings = new String[listFile.length];
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].getName().startsWith("learn_kotlin_")); {
                    list.add(new Quickshot(listFile[i].getName(), listFile[i].getAbsolutePath()));
                }
            }
        }
        PostEventModel eventModel = new PostEventModel("QuickShot");
        eventModel.setQuickshots(list);
        event.onDataReceived(eventModel);
    }
}
