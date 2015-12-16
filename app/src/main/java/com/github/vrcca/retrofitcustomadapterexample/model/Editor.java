package com.github.vrcca.retrofitcustomadapterexample.model;

import java.util.ArrayList;
import java.util.List;

public class Editor extends User {

    private List<String> posts;

    public Editor() {
        this.posts = new ArrayList<>();
    }

    public List<String> getPosts() {
        return posts;
    }

    public void addPost(String s) {
        posts.add(s);
    }
}
