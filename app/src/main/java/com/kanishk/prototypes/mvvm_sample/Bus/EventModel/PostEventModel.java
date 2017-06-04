package com.kanishk.prototypes.mvvm_sample.Bus.EventModel;

import com.kanishk.prototypes.mvvm_sample.Model.ApiRef;
import com.kanishk.prototypes.mvvm_sample.Model.Post;
import com.kanishk.prototypes.mvvm_sample.Model.Quickshot;
import com.kanishk.prototypes.mvvm_sample.Model.Video;

import java.util.ArrayList;

/**
 * Created by kanishk on 31/05/17.
 */

public class PostEventModel {

    private String type;
    private ArrayList<Post> posts;
    private ArrayList<Video> videos;
    private ArrayList<ApiRef> apiRefs;
    private ArrayList<Quickshot> quickshots;

    public PostEventModel(String type) {
        this.type = type;
    }
    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }
    public void setVideos(ArrayList<Video> videos) {
        this.videos = videos;
    }
    public void setApiRefs(ArrayList<ApiRef> apiRefs) {
        this.apiRefs = apiRefs;
    }
    public void setQuickshots(ArrayList<Quickshot> quickshots) { this.quickshots = quickshots; }

    public String getType() {
        return type;
    }
    public ArrayList<Post> getPosts() {
        return posts;
    }
    public ArrayList<Video> getVideos() {
        return videos;
    }
    public ArrayList<ApiRef> getApiRefs() {
        return apiRefs;
    }
    public ArrayList<Quickshot> getQuickshots() { return quickshots; }

}
