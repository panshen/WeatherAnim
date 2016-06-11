package com.panshen.com.rain.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.panshen.com.rain.R;
import com.panshen.com.rain.cloud.CloudView;
import com.panshen.com.rain.sun.SunView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(new CloudView(this, CloudView.mode.DAY));
    }
}
