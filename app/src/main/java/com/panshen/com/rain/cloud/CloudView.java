package com.panshen.com.rain.cloud;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;

import com.panshen.com.rain.BaseView;
import com.panshen.com.rain.Point;
import com.panshen.com.rain.PointEvaluator;
import com.panshen.com.rain.R;

import java.util.ArrayList;
import java.util.Random;

public class CloudView extends BaseView implements SensorEventListener {
    private Context mContext;
    //private ArrayList<Integer> mColors = new ArrayList();
    CloudBg cb;
    private ArrayList<Cloud> clouds = new ArrayList<>();
    Point currentPoint;
    SensorManager sm;
    Sensor sensor;
    private int[] colors = {Color.parseColor("#9ea8b1b4"), Color.parseColor("#9fffffff"), Color.parseColor("#9e3a4859")};
    private boolean animend = false;

    public CloudView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CloudView(Context context) {
        super(context);
        mContext = context;
        currentPoint = new Point(0, getHeight());
        StartDropAnim();
        sm = (SensorManager) mContext.getSystemService(Context.SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        sm.unregisterListener(this);
    }

    public void StartDropAnim() {
        Point startPoint = new Point(0, -1000);
        Point endPoint = new Point(0, 0);
        ValueAnimator DropAnim = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        DropAnim.setDuration(1500);
        DropAnim.setInterpolator(new OvershootInterpolator());
        DropAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (Point) animation.getAnimatedValue();
                for (Cloud mcl : clouds) {
                    mcl.ControlY((int) currentPoint.getY());
                }
            }
        });
        DropAnim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                // StartReverseAnim();
                for (Cloud mcl : clouds) {
                    //mcl.AnimEnd();
                }
                animend = true;
            }
        });
        DropAnim.start();
    }


    public void StartReverseAnim() {
        Point startPoint = new Point(0, 0);
        Point endPoint = new Point(0, -100);
        ValueAnimator ReverseAnim = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        ReverseAnim.setDuration(1000);
        ReverseAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        ReverseAnim.setRepeatCount(ValueAnimator.INFINITE);
        ReverseAnim.setRepeatMode(ValueAnimator.REVERSE);
        ReverseAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (Point) animation.getAnimatedValue();
                for (Cloud mcl : clouds) {
                    mcl.ControlY((int) currentPoint.getY());
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
            cb.move();
            for (Cloud mcl : clouds) {
                mcl.move();
            }
        }
    }

    @Override
    protected void init() {
        cb = new CloudBg(getWidth(), getHeight(), mContext, getResources().getColor(R.color.colorCloudBackground));

        for (int i = 0; i < 5; i++) {
            Cloud cloud = new Cloud(getWidth(), getHeight(), mContext, colors[new Random().nextInt(colors.length)]);
            clouds.add(cloud);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (animend) {
            Log.i("TAG [X] ", event.values[0] + "\n");
            Log.i("TAG [Y] ", event.values[1] + "\n");
            Log.i("TAG [Z] ", event.values[2] + "\n");

            for (Cloud mcl : clouds) {
                mcl.ControlY(event.values[1]);
                mcl.ControlX(event.values[0]);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
