package com.panshen.com.rain.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.panshen.com.rain.FragmentAdapter;
import com.panshen.com.rain.R;

public class MainActivity  extends AppCompatActivity{
    private ViewPager vp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = (ViewPager) findViewById(R.id.vp);
        //填充适配器
        vp.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        //设置显示的index
        vp.setCurrentItem(0);
    }
}
