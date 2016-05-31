package com.panshen.com.rain.cloud;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;

import com.panshen.com.rain.BaseView;
import com.panshen.com.rain.mPoint;
import com.panshen.com.rain.PointEvaluator;
import com.panshen.com.rain.R;

import java.util.ArrayList;
import java.util.Random;

public class CloudView extends BaseView {
    private Context mContext;
    CloudBg cb;
    private ArrayList<Cloud> clouds = new ArrayList<>();
    mPoint currentMPoint;
    private int[] colors = {Color.parseColor("#9ea8b1b4"), Color.parseColor("#9fffffff"), Color.parseColor("#9e3a4859")};
    private ArrayList<Integer> size = null;

    public CloudView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CloudView(Context context) {
        super(context);
        mContext = context;
        currentMPoint = new mPoint(0, getHeight());
        //StartDropAnim();
        //StartReverseAnimY();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void StartDropAnim() {
        mPoint startMPoint = new mPoint(0, -1000);
        mPoint endMPoint = new mPoint(0, 0);
        ValueAnimator DropAnim = ValueAnimator.ofObject(new PointEvaluator(), startMPoint, endMPoint);
        DropAnim.setDuration(1500);
        DropAnim.setInterpolator(new OvershootInterpolator());
        DropAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentMPoint = (mPoint) animation.getAnimatedValue();
                for (Cloud mcl : clouds) {
                    mcl.ControlY((int) currentMPoint.getY());
                }
            }
        });
        DropAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                // StartReverseAnimY();
                for (Cloud mcl : clouds) {
                    //mcl.AnimEnd();
                }
            }
        });
        DropAnim.start();
    }

    public void StartReverseAnimY() {
        mPoint startMPoint = new mPoint(0, 0);
        mPoint endMPoint = new mPoint(0, -100);
        ValueAnimator ReverseAnim = ValueAnimator.ofObject(new PointEvaluator(), startMPoint, endMPoint);
        ReverseAnim.setDuration(2000);
        ReverseAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        ReverseAnim.setRepeatCount(ValueAnimator.INFINITE);
        ReverseAnim.setRepeatMode(ValueAnimator.REVERSE);
        ReverseAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentMPoint = (mPoint) animation.getAnimatedValue();
                for (Cloud mcl : clouds) {
                    mcl.ControlY((int) currentMPoint.getY());
                }
            }
        });
        ReverseAnim.start();
    }


    @Override
    protected void drawSub(Canvas canvas) {
        if (clouds.size() != 0 && cb != null) {
            cb.draw(canvas);
            for (Cloud mcl : clouds) {
                mcl.draw(canvas);
            }
        }
    }

    @Override
    protected void logic() {
        if (clouds.size() != 0 && cb != null) {
            for (Cloud mcl : clouds) {
                mcl.move();
            }
        }
    }

    @Override
    protected void init() {
        cb = new CloudBg(getWidth(), getHeight(), mContext, getResources().getColor(R.color.colorCloudBackground));
        size = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            size.add(new Random().nextInt(getWidth() / 20));
        }
        for (int i = 0; i < 5; i++) {
            Cloud cloud = new Cloud(size.get(i), getWidth(), getHeight(), mContext, colors[new Random().nextInt(colors.length)]);
            clouds.add(cloud);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        for (Cloud mcl : clouds) {
            mcl.ControlY(event.values[1]);
            mcl.ControlX(event.values[0]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
