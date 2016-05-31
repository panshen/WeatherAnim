package com.panshen.com.rain.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.panshen.com.rain.sun.Sun;
import com.panshen.com.rain.sun.SunView;

/**
 * Created by Z on 2016/5/29.
 */
public class SunActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new SunView(SunActivity.this));
    }
}
