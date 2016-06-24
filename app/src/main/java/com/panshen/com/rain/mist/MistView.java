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
import com.panshen.com.rain.RPoint;
import com.panshen.com.rain.activity.Utils;

import java.util.ArrayList;
import java.util.Random;

public class MistView extends BaseView {
    private Context mContext;
    private MistBg MistBg;
    private ArrayList<Mist> mMists = new ArrayList<>();
    RPoint currentRPoint;
    private int mCouldBackColor = 0;
    private Random mRandom;
    private Resources mResources = getResources();
    private int mCloudColor;
    private int toColor = 0;
    private ArrayList<Integer> radius = new ArrayList();

    public MistView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MistView(Context context) {
        super(context);
        this.mContext = context;
        this.currentRPoint = new RPoint(0, getHeight());
        this.mRandom = new Random();
        toColor = mResources.getColor(R.color.colorMistBg);
        mCouldBackColor = mResources.getColor(R.color.colorMistBg);
        mCloudColor = mResources.getColor(R.color.colorMist);
        radius.add(100);
        radius.add(200);
        radius.add(150);
        StartReverseYAnim();
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
                currentRPoint = (RPoint) animation.getAnimatedValue();
                for (int i = 0; i < mMists.size(); i++) {
                    mMists.get(i).ControlY(currentRPoint.getY());
                }
            }
        });
        animator.start();
    }

    @Override
    protected void drawSub(Canvas canvas) {
        if (mMists.size() != 0 && MistBg != null) {
            MistBg.draw(canvas);
            for (int i = 0; i < mMists.size(); i++) {
                mMists.get(i).draw(canvas);
            }
        }
    }

    @Override
    protected void logic() {
    }

    @Override
    protected void init() {
        MistBg = new MistBg(getWidth(), getHeight(), mContext, mCouldBackColor);
        for (int i = 0; i < 20; i++) {
            Mist cloud = new Mist( mRandom.nextInt(getHeight()), mRandom.nextInt(getWidth()/20), getWidth(), getHeight(), mCloudColor, toColor,radius.get(mRandom.nextInt(radius.size())));
            mMists.add(cloud);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        for (int i = 0; i < mMists.size(); i++) {
            mMists.get(i).SetY(event.values[1]);
            mMists.get(i).SetX(event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
