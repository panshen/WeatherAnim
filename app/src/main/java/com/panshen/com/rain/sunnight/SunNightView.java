package com.panshen.com.rain.sunnight;

import android.content.Context;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.util.AttributeSet;

import com.panshen.com.rain.BaseView;
import com.panshen.com.rain.R;

import java.util.ArrayList;
import java.util.Random;

public class SunNightView extends BaseView {
    private int[] mColors = {getResources().getColor(R.color.colorSunNight1), getResources().getColor(R.color.colorSunNight2), getResources().getColor(R.color.colorSunNight3)};
    private SunNightWall mSunbg;
    private Context mContext;
    private ArrayList<SunNight> mSunNights = new ArrayList<SunNight>();
    private int[] CircleWidths = {3,6,2,8};
    private int[] CircleLength = {120,80,200,50};
    public SunNightView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }

    public SunNightView(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected int getSensorType() {
        return Sensor.TYPE_GRAVITY;
    }

    @Override
    protected void drawSub(Canvas canvas) {
        mSunbg.draw(canvas);
        for (int i = 0; i < mSunNights.size(); i++) {
            mSunNights.get(i).draw(canvas);
        }
    }

    @Override
    protected void logic() {
//        for (SunNight s : mSunNights) {
//            //s.move();
//        }
    }

    @Override
    protected void init() {
        mSunbg = new SunNightWall(getWidth(), getHeight(), mContext, getResources().getColor(R.color.colorSunNightWall));
        for (int i = 20; i >= 0; i--) {
            try {
                SunNight sunNight = new SunNight(CircleLength[new Random().nextInt(CircleLength.length)],CircleWidths[new Random().nextInt(CircleWidths.length)],i * 100, getWidth(), getHeight(), mColors[new Random().nextInt(mColors.length)]);
                mSunNights.add(sunNight);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        for (int i = 0; i < mSunNights.size(); i++) {
            mSunNights.get(i).SetY(event.values[1]);
            mSunNights.get(i).SetX(event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
