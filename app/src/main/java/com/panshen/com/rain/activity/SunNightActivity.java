package com.panshen.com.rain.activity;

import android.app.Activity;
import android.os.Bundle;

import com.panshen.com.rain.sunnight.SunNightView;

public class SunNightActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SunNightView(this));
    }
}
