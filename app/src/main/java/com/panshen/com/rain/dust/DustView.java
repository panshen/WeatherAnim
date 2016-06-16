package com.panshen.com.rain.dust;


import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.util.AttributeSet;
import android.util.Log;

import com.panshen.com.rain.BaseView;
import com.panshen.com.rain.R;

public class DustView extends BaseView {

    private ArrayList<Dust> list = new ArrayList<>();
    private int mDustCount = 150;
    private DustWall dustWall;

    private boolean  perpared;
    public DustView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DustView(Context context) {
        super(context);
    }

    @Override
    protected int getSensorType() {
        return Sensor.TYPE_ROTATION_VECTOR;
    }

    @Override
    protected void drawSub(Canvas canvas) {
        dustWall.draw(canvas);
//        for (Dust item : list) {
//            item.draw(canvas);
//        }
        for (int i = 0; i < list.size(); i++) {
                list.get(i).draw(canvas);
        }
    }

    @Override
    protected void logic() {
        for(int i = 0;i<list.size();i++){
            list.get(i).move();
        }
    }

    @Override
    protected void init() {
        dustWall = new DustWall(getWidth(), getHeight(), getResources().getColor(R.color.colorDustWall));
        for (int i = 0; i < mDustCount; i++) {
            Dust item = new Dust(getWidth(), getHeight(),getResources().getColor(R.color.colorDust));
            list.add(item);
        }
        perpared = true;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(perpared) {
            Log.i("x", event.values[0] + "");
            Log.i("y", event.values[1] + "");
            Log.i("z", event.values[2] + "");
//            for (Dust item : list) {
//                item.SetX(event.values[0]);
//                item.SetY(event.values[1]);
//                item.ControlZ(event.values[2]);
//            }
            for(int i=0;i<list.size();i++){
                list.get(i).SetX(event.values[0]);
                list.get(i).SetY(event.values[1]);
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
