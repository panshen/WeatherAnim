package com.panshen.com.rain.activity;

import android.app.Activity;
import android.os.Bundle;

import com.panshen.com.rain.sun.SunView;

public class SunActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SunView(SunActivity.this));
    }
}
