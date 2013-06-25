package com.codepath.apps.simpletwitterclient.fragments;

import java.util.ArrayList;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.codepath.apps.simpletwitterclient.R;
import com.codepath.apps.simpletwitterclient.TweetsAdapter;
import com.codepath.apps.simpletwitterclient.models.Tweet;

public class TimelineFragment extends Fragment implements TabListener {
    private TweetsAdapter adapter;
    private FragmentActivity fragmentActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timeline, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.adapter = new TweetsAdapter(getActivity().getBaseContext(), new ArrayList<Tweet>());

        ListView lv = (ListView)getActivity().findViewById(R.id.lvTweets);
        lv.setAdapter(adapter);
    }

    public TweetsAdapter getAdapter() {
        return this.adapter;
    }

    public void setActivity(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    @Override
    public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTabSelected(Tab tab, android.app.FragmentTransaction ft) {
        FragmentTransaction fts = this.fragmentActivity.getSupportFragmentManager().beginTransaction();
        fts.replace(R.id.frameContainer, this);
        fts.commit();
    }

    @Override
    public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {
        // TODO Auto-generated method stub
    }
}