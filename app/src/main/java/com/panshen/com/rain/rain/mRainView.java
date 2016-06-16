package com.panshen.com.rain.rain;


import android.content.Context;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.util.AttributeSet;
import android.util.Log;

import com.panshen.com.rain.BaseView;
import com.panshen.com.rain.R;

import java.util.ArrayList;

public class mRainView extends BaseView {

    private ArrayList<mRain> list = new ArrayList<>();
    private int mDustCount = 30;
    private RainWall rainWall;

    private boolean  perpared;
    public mRainView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public mRainView(Context context) {
        super(context);
    }

    @Override
    protected int getSensorType() {
        return Sensor.TYPE_GRAVITY;
    }

    @Override
    protected void drawSub(Canvas canvas) {
        rainWall.draw(canvas);
        for (int i = 0; i < list.size(); i++) {
            list.get(i).draw(canvas);
        }
    }

    @Override
    protected void logic() {
    }

    @Override
    protected void init() {
        rainWall = new RainWall(getWidth(), getHeight(), getResources().getColor(R.color.colorDustWall));
        for (int i = 0; i < mDustCount; i++) {
            mRain item = new mRain(getWidth(), getHeight(),getResources().getColor(R.color.colorDust));
            list.add(item);
        }
        perpared = true;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(perpared) {
            for (int i = 0; i < list.size(); i++) {
                list.get(i).SetY(event.values[1]);
                list.get(i).SetX(event.values[0]);
                list.get(i).ControlZ(event.values[2]);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        list.clear();
        list = null;
        System.gc();
    }
}
