package com.panshen.com.rain.sun;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.util.AttributeSet;

import com.panshen.com.rain.BaseView;
import com.panshen.com.rain.R;

import java.util.ArrayList;
import java.util.Random;

public class SunView extends BaseView {
    private int[] colors = {Color.parseColor("#9ea8b1b4"), Color.parseColor("#9fffffff"), Color.parseColor("#9e3a4859")};
    private SunBg sunbg;
    private Context mContext;
    private ArrayList<Sun> mSuns = new ArrayList<Sun>();

    public SunView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public SunView(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected void drawSub(Canvas canvas) {
        if (mSuns.size() != 0 && sunbg != null) {
            sunbg.draw(canvas);
            for (Sun s : mSuns) {
                s.draw(canvas);
            }
        }
    }

    @Override
    protected void logic() {
        if (mSuns.size() != 0 && sunbg != null) {
            for (Sun s : mSuns) {
                //s.move();
            }
        }
    }

    @Override
    protected void init() {
        sunbg = new SunBg(getWidth(), getHeight(), mContext, getResources().getColor(R.color.colorCloudBackground));
        for (int i = 0; i < 1; i++) {
            Sun sun = new Sun( getWidth(), getHeight(), mContext, colors[new Random().nextInt(colors.length)]);
            mSuns.add(sun);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
