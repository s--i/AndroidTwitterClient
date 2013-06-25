package com.codepath.apps.simpletwitterclient.fragments;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ActionBar.TabListener;
import android.os.Bundle;

import com.codepath.apps.simpletwitterclient.SimpleTwitterApp;
import com.codepath.apps.simpletwitterclient.models.Tweet;
import com.loopj.android.http.JsonHttpResponseHandler;

public class MentionsTimelineFragment extends TimelineFragment implements TabListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SimpleTwitterApp.getRestClient().getMentionsTimeline(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(JSONArray jsonTweets) {
                getAdapter().add(makeTestTweet());
                getAdapter().addAll(Tweet.fromJson(jsonTweets));
            }
        });
    }

    private Tweet makeTestTweet() {
        Tweet tweet = new Tweet();

        try {
            JSONObject testUser = new JSONObject();
            testUser.put("name", "test name");
            testUser.put("id", "test id");
            testUser.put("screen_name", "test screen name");
            testUser.put("profile_image_url", "https://si0.twimg.com/profile_images/3244547434/9d7b76dd7f82274b7d9f3c6e793c7b97_normal.jpeg");

            JSONObject testTweet = new JSONObject();
            testTweet.put("user", testUser);
            testTweet.put("text", "blah blah blah blah blah blah blah blah");

            tweet = Tweet.fromJson(testTweet);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return tweet;
    }
}