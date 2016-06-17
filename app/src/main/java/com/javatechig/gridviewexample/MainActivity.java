package com.javatechig.gridviewexample;


import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;

public class MainActivity extends ActionBarActivity {
    public boolean twoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        float scaleFactor = metrics.density;
        float widthDp = width / scaleFactor;
        float heightDp = height / scaleFactor;
        if (widthDp < 600 || heightDp < 500 && savedInstanceState == null) {
            setContentView(R.layout.activity_gridview);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
        } else if (widthDp < 600 || heightDp < 500 && savedInstanceState != null) {
            setContentView(R.layout.activity_gridview);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
        }
        else {
            setContentView(R.layout.two_panel_tablet);
            if (savedInstanceState == null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container3, new DetailsFragment())
                        .commit();
            }

        }

    }
    
}

