package com.panshen.com.rain.cloud;
//多云 白天--白色的云 橘黄色太阳 蓝色背景     夜晚--深色背景和闪动的星星 深色云 浅黄色太阳

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.util.AttributeSet;

import com.panshen.com.rain.BaseView;
import com.panshen.com.rain.activity.Utils;
import com.panshen.com.rain.mPoint;
import com.panshen.com.rain.R;

import java.util.ArrayList;
import java.util.Random;

public class CloudView extends BaseView {
    private Context mContext;
    private CloudBg cloudBg;
    private ArrayList<Cloud> clouds = new ArrayList<>();
    private ArrayList<CloudStar> stars = new ArrayList<>();
    mPoint currentMPoint;
    private int mCouldColor = 0;
    private int mCouldBackColor = 0;
    private int mCouldSunColor = 0;
    private Csun csun = null;
    private mode mMode;

    public CloudView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CloudView(Context context, mode mmode) {
        super(context);
        mContext = context;
        currentMPoint = new mPoint(0, getHeight());
        this.mMode = mmode;
        StartReverseYAnim();
        if (mMode.equals(mode.DAY)) {
            mCouldColor = getResources().getColor(R.color.colorCloudDay);
            mCouldSunColor = getResources().getColor(R.color.colorCloudSunDay);
            mCouldBackColor = getResources().getColor(R.color.colorCloudBackgroundDay);
        } else if (mMode.equals(mode.NIGHT)) {
            mCouldColor = getResources().getColor(R.color.colorCloudNight);
            mCouldSunColor = getResources().getColor(R.color.colorCloudSunNight);
            mCouldBackColor = getResources().getColor(R.color.colorCloudBackgroundNight);
        }
    }

    @Override
    protected int getSensorType() {
        return Sensor.TYPE_GRAVITY;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void StartReverseYAnim() {
        ValueAnimator animator = Utils.getAnim();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentMPoint = (mPoint) animation.getAnimatedValue();
                for (Cloud mcl : clouds) {
                    csun.ControlY(currentMPoint.getY());
                    mcl.ControlY(currentMPoint.getY());
                }
            }
        });
        animator.start();
    }

    @Override
    protected void drawSub(Canvas canvas) {
        if (clouds.size() != 0 && cloudBg != null) {

            cloudBg.draw(canvas);
            if(mMode.equals(mode.NIGHT))
            for(int i = 0;i<stars.size();i++){
                stars.get(i).draw(canvas);
            }

            for (int i = 0; i < clouds.size(); i++) {
                if (i == clouds.size() - 2) csun.draw(canvas);
                clouds.get(i).draw(canvas);
            }
        }

    }

    @Override
    protected void logic() {
        if (clouds.size() != 0 && cloudBg != null) {
            for (Cloud mcl : clouds) {
                mcl.move();
            }
        }
    }

    @Override
    protected void init() {
        cloudBg = new CloudBg(getWidth(), getHeight(),mContext, mCouldBackColor);
        csun = new Csun(getWidth(), getHeight(), mCouldSunColor);
        for (int i = 0; i < 5; i++) {
            Cloud cloud = new Cloud(new Random().nextInt(getWidth() / 20), getWidth(), getHeight(), mContext, mCouldColor);
            clouds.add(cloud);
        }
        for(int i = 0; i < 35; i++){
            CloudStar cloud = new CloudStar(new Random().nextInt(getWidth() / 20), getWidth(), getHeight(), mContext, mCouldColor);
            stars.add(cloud);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        for (Cloud mcl : clouds) {
            mcl.SetY(event.values[1]);
            mcl.SetX(event.values[0]);

            csun.SetY(event.values[1]);
            csun.SetX(event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public enum mode {
        DAY, NIGHT
    }
}
