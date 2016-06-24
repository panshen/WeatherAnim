package com.panshen.com.rain.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.panshen.com.rain.R;

public class MainActivity extends AppCompatActivity {
    private ViewPager vp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layoutaa);
        vp = (ViewPager) findViewById(R.id.vp);
        vp.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        vp.setCurrentItem(0);
    }
}
