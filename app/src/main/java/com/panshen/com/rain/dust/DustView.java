package com.panshen.com.rain.dust;


import java.util.ArrayList;
import java.util.Random;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.util.AttributeSet;
import android.util.Log;

import com.panshen.com.rain.BaseView;
import com.panshen.com.rain.R;

public class DustView extends BaseView {

    private ArrayList<Dust> list = new ArrayList<>();
    private int rainNum = 80;
    private int size;
    private int rainColor;
    private boolean randColor;
    private DustWall rw;

    private boolean  perpared;
    public DustView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs,
                R.styleable.DustView);

        rainNum = ta.getInteger(R.styleable.DustView_rainNum, 200);
        size = ta.getInteger(R.styleable.DustView_size, 20);
        rainColor = ta.getInteger(R.styleable.DustView_rainColor, 0xffffffff);
        randColor = ta.getBoolean(R.styleable.DustView_randColor, false);
        ta.recycle();
    }

    public DustView(Context context) {
        super(context);
    }

    @Override
    protected void drawSub(Canvas canvas) {
        rw.draw(canvas);
        for (Dust item : list) {
            item.draw(canvas);
        }
    }

    @Override
    protected void logic() {
        for (Dust item : list) {
            item.move();
        }
    }

    @Override
    protected void init() {
        rw = new DustWall(getWidth(), getHeight(), getResources().getColor(R.color.colorDust));
        for (int i = 0; i < rainNum; i++) {
            Dust item = new Dust(getWidth(), getHeight());
            list.add(item);
        }
        perpared = true;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(perpared) {
            Log.i("x", event.values[0] + "");//横向
            Log.i("y", event.values[1] + "");//纵向
            Log.i("z", event.values[2] + "");//垂直
            for (Dust item : list) {
                item.ControlX(event.values[0]);
                item.ControlY(event.values[1]);
                item.ControlZ(event.values[2]);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
