package com.panshen.com.rain.sun;

import android.content.Context;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.util.AttributeSet;

import com.panshen.com.rain.BaseView;
import com.panshen.com.rain.R;
import com.panshen.com.rain.cloud.Cloud;

import java.util.ArrayList;
import java.util.Iterator;

public class SunView extends BaseView {
    private int[] colors = {getResources().getColor(R.color.colorSun), getResources().getColor(R.color.colorSunn), getResources().getColor(R.color.colorSunnn), getResources().getColor(R.color.colorSunnnn), getResources().getColor(R.color.colorSunnnnn), getResources().getColor(R.color.colorSunnnnnn), getResources().getColor(R.color.colorSunnnnnnn), getResources().getColor(R.color.colorSunnnnnnnn)};
    private SunBg sunbg;
    private Context mContext;
    private ArrayList<Sun> mSuns = new ArrayList<Sun>();
    private Sun s = new Sun(getWidth(), getHeight(), mContext, colors[1], 4 * 100);
    public SunView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SunView(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected void drawSub(Canvas canvas) {
        sunbg.draw(canvas);
        for (int i = 0; i < mSuns.size(); i++) {
            mSuns.get(i).draw(canvas);
        }
    }

    @Override
    protected void logic() {
        for (Sun s : mSuns) {
            //s.move();
        }
    }

    @Override
    protected void init() {
        sunbg = new SunBg(getWidth(), getHeight(), mContext, getResources().getColor(R.color.colorCloudBackground));
        for (int i = 8; i >= 0; i--) {
            try {
                Sun sun = new Sun(getWidth(), getHeight(), mContext, colors[i], i * 150);
                mSuns.add(sun);
            } catch (Exception e) {

            }
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        for (int i = 0; i < mSuns.size(); i++) {
            mSuns.get(i).ControlY(event.values[1]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
