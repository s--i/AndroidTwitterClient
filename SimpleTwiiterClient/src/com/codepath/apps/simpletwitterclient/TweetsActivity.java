package com.codepath.apps.simpletwitterclient;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

import com.codepath.apps.simpletwitterclient.fragments.HomeTimelineFragment;
import com.codepath.apps.simpletwitterclient.fragments.MentionsTimelineFragment;

public class TweetsActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweets);

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setDisplayShowTitleEnabled(true);

        HomeTimelineFragment homeTimelineFragemnt = new HomeTimelineFragment();
        homeTimelineFragemnt.setActivity(this);
        MentionsTimelineFragment mentionsTimelineFragment = new MentionsTimelineFragment();
        mentionsTimelineFragment.setActivity(this);

        Tab homeTab = actionBar.newTab().setText("Home").setTabListener(homeTimelineFragemnt).setIcon(R.drawable.ic_launcher);
        Tab mentionsTab = actionBar.newTab().setText("Mentions").setTabListener(mentionsTimelineFragment).setIcon(R.drawable.ic_launcher);

        actionBar.addTab(homeTab);
        actionBar.addTab(mentionsTab);
        actionBar.selectTab(homeTab);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tweets, menu);
        return true;
    }
}