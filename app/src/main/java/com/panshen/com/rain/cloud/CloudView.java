package com.panshen.com.rain.cloud;
//多云 白天--白色的云 橘黄色太阳 蓝色背景     夜晚--深色背景和闪动的星星 深色云 浅黄色太阳

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.util.AttributeSet;

import com.panshen.com.rain.BaseView;
import com.panshen.com.rain.activity.Utils;
import com.panshen.com.rain.activity.WeatherView;
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
    private int mCouldBackColor = 0;
    private int mCouldSunColor = 0;
    private Csun csun;
    private WeatherView.Situation mMode;
    private int CLOUDCOUNT = 7;
    private int[] dur = {-100, -200, -50, -180, -300};
    private ArrayList<Integer> mCouldColors = new ArrayList();
    private Random mRandom;
    private Resources mResources;


    public CloudView(Context context, WeatherView.Situation mmode) {
        super(context);
        this.mContext = context;
        this.currentMPoint = new mPoint(0, getHeight());
        this.mMode = mmode;
        this.mRandom = new Random();
        this.mResources = getResources();
        StartReverseYAnim();

        if (mMode.equals(WeatherView.Situation.DAY)) {

            mCouldColors.clear();
            mCouldColors.add(mResources.getColor(R.color.colorCloudDay));

            mCouldSunColor = mResources.getColor(R.color.colorCloudSunDay);
            mCouldBackColor = mResources.getColor(R.color.colorCloudBackgroundDay);
        } else if (mMode.equals(WeatherView.Situation.NIGHT)) {

            mCouldColors.clear();
            mCouldColors.add(mResources.getColor(R.color.colorCloudNight));
            mCouldColors.add(mResources.getColor(R.color.colorCloudNightt));
            mCouldColors.add(mResources.getColor(R.color.colorCloudNighttt));
            mCouldColors.add(mResources.getColor(R.color.colorCloudNightttt));

            mCouldSunColor = mResources.getColor(R.color.colorCloudSunNight);
            mCouldBackColor = mResources.getColor(R.color.colorCloudBackgroundNight);
        } else if (mMode.equals(WeatherView.Situation.OVERCAST)) {
            mCouldColors.clear();
            mCouldColors.add(mResources.getColor(R.color.colorOverCast));
            mCouldColors.add(mResources.getColor(R.color.colorOverCastt));
            mCouldColors.add(mResources.getColor(R.color.colorOverCasttt));

            mCouldBackColor = mResources.getColor(R.color.colorOverCastBG);
        }
    }

    @Override
    protected int getSensorType() {
        return Sensor.TYPE_GRAVITY;
    }


    public void StartReverseYAnim() {
        ValueAnimator animator = Utils.getAnim(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentMPoint = (mPoint) animation.getAnimatedValue();
                if (clouds == null || clouds.size() <= 0) return;
                for (int i = 0; i < clouds.size(); i++) {
                    csun.ControlY(currentMPoint.getY());
                    clouds.get(i).ControlY(currentMPoint.getY());
                }
            }
        });
        animator.start();
    }


    @Override
    protected void drawSub(Canvas canvas) {
        if (clouds.size() != 0 && cloudBg != null) {

            cloudBg.draw(canvas);
            if (mMode.equals(WeatherView.Situation.NIGHT))
                for (int i = 0; i < stars.size(); i++) {
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
    }

    @Override
    protected void init() {
        cloudBg = new CloudBg(getWidth(), getHeight(), mContext, mCouldBackColor);
        csun = new Csun(getWidth(), getHeight(), mCouldSunColor);
        for (int i = 0; i < CLOUDCOUNT; i++) {
            Cloud cloud = new Cloud(mRandom.nextInt(getWidth() / 20), getWidth(), getHeight(), mContext, mCouldColors.get(mRandom.nextInt(mCouldColors.size())));
            clouds.add(cloud);
        }

        for (int i = 0; i < 35; i++) {
            CloudStar cloud = new CloudStar(mRandom.nextInt(getWidth() / 20), getWidth(), getHeight(), mContext);
            stars.add(cloud);
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        for (int i = 0; i < clouds.size(); i++) {
            clouds.get(i).SetX(event.values[0]);
            clouds.get(i).SetY(event.values[1]);

            csun.SetY(event.values[1]);
            csun.SetX(event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        clouds.clear();
        clouds = null;
        stars.clear();
        stars = null;
        mCouldColors.clear();
        mCouldColors = null;
        System.gc();
    }
}
