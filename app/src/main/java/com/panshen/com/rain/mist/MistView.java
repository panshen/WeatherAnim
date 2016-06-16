package com.panshen.com.rain.mist;
//多云 白天--白色的云 橘黄色太阳 蓝色背景     夜晚--深色背景和闪动的星星 深色云 浅黄色太阳

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.util.AttributeSet;

import com.panshen.com.rain.BaseView;
import com.panshen.com.rain.R;
import com.panshen.com.rain.activity.Utils;
import com.panshen.com.rain.mPoint;

import java.util.ArrayList;
import java.util.Random;

public class MistView extends BaseView {
    private Context mContext;
    private MistBg cloudBg;
    private ArrayList<Mist> mMists = new ArrayList<>();
    mPoint currentMPoint;
    private int mCouldBackColor = 0;
    private int mCouldColor;
    private Random mRandom;
    private Resources mResources = getResources();;
    private int[] colors = {mResources.getColor(R.color.colorMist),mResources.getColor(R.color.colorMistt),mResources.getColor(R.color.colorMisttt),mResources.getColor(R.color.colorMistttt),mResources.getColor(R.color.colorMisttttt)};
    public MistView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MistView(Context context) {
        super(context);
        this.mContext = context;
        this.currentMPoint = new mPoint(0, getHeight());
        this.mRandom = new Random();

        StartReverseYAnim();
        mCouldColor = mResources.getColor(R.color.colorDustWall);
        mCouldBackColor = mResources.getColor(R.color.colorOverCast);
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
        ValueAnimator animator = Utils.getAnim(2000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentMPoint = (mPoint) animation.getAnimatedValue();
                for (int i = 0; i < mMists.size(); i++) {
                    mMists.get(i).ControlY(currentMPoint.getY());
                }
            }
        });
        animator.start();
    }

    @Override
    protected void drawSub(Canvas canvas) {
        if (mMists.size() != 0 && cloudBg != null) {

            cloudBg.draw(canvas);

            for (int i = 0; i < mMists.size(); i++) {
                mMists.get(i).draw(canvas);
            }
        }
    }

    @Override
    protected void logic() {
        if (mMists.size() != 0 && cloudBg != null) {
            for (Mist mcl : mMists) {
                mcl.move();
            }
        }
    }

    @Override
    protected void init() {
        cloudBg = new MistBg(getWidth(), getHeight(), mContext, mCouldBackColor);
        for (int i = 1; i <5; i++) {
            Mist cloud = new Mist(250*i,mRandom.nextInt(getWidth() / 20), getWidth(), getHeight(), mContext, colors[i-1]);
            mMists.add(cloud);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        for (Mist mist : mMists) {
            mist.SetY(event.values[1]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
