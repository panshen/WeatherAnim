package com.panshen.com.rain.sun;

import android.content.Context;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.util.AttributeSet;

import com.panshen.com.rain.BaseView;
import com.panshen.com.rain.R;

import java.util.ArrayList;

public class SunView extends BaseView {
    private int[] mColors = {getResources().getColor(R.color.colorSun), getResources().getColor(R.color.colorSunn), getResources().getColor(R.color.colorSunnn), getResources().getColor(R.color.colorSunnnn), getResources().getColor(R.color.colorSunnnnn), getResources().getColor(R.color.colorSunnnnnn), getResources().getColor(R.color.colorSunnnnnnn), getResources().getColor(R.color.colorSunnnnnnnn)};
    private SunBg mSunbg;
    private Halo mHalo;
    private Context mContext;
    private ArrayList<SunBeam> mSunBeams = new ArrayList<SunBeam>();
    public SunView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SunView(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected void drawSub(Canvas canvas) {
        mSunbg.draw(canvas);
        for (int i = 0; i < mSunBeams.size(); i++) {
            mSunBeams.get(i).draw(canvas);
        }
        mHalo.draw(canvas);
    }

    @Override
    protected void logic() {
        for (SunBeam s : mSunBeams) {
            //s.move();
        }
    }

    @Override
    protected void init() {
        mSunbg = new SunBg(getWidth(), getHeight(), mContext, getResources().getColor(R.color.colorCloudBackground));
        mHalo = new Halo(20,getWidth(), getHeight(), mContext, getResources().getColor(R.color.colorCloudBackground));
        for (int i = 8; i >= 0; i--) {
            try {
                SunBeam sunBeam = new SunBeam(20,getWidth(), getHeight(), mContext, mColors[i], i * 150);
                mSunBeams.add(sunBeam);
            } catch (Exception e) {

            }
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        for (int i = 0; i < mSunBeams.size(); i++) {
            mSunBeams.get(i).ControlY(event.values[1]);
            mSunBeams.get(i).ControlX(event.values[0]);

            mHalo.ControlY(event.values[1]);
            mHalo.ControlX(event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
