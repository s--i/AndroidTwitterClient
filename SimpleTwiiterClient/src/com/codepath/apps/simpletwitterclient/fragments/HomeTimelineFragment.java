package com.codepath.apps.simpletwitterclient.fragments;

import org.json.JSONArray;

import android.os.Bundle;

import com.codepath.apps.simpletwitterclient.SimpleTwitterApp;
import com.codepath.apps.simpletwitterclient.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

public class HomeTimelineFragment extends TimelineFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SimpleTwitterApp.getRestClient().getHomeTimeline(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(JSONArray jsonTweets) {
                getAdapter().addAll(Tweet.fromJson(jsonTweets));
            }
        });
    }
}