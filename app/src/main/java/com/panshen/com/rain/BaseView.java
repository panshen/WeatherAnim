package com.panshen.com.rain;

import android.content.Context;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.AttributeSet;
import android.view.View;

public abstract class BaseView extends View implements SensorEventListener {

    private MyThread thread;
    private boolean running = true;
    private SensorManager sm;
    private Sensor sensor;
    private Context context;

    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        sm = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(getSensorType());
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    public BaseView(Context context) {
        super(context);
        this.context = context;

        sm = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(getSensorType());
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST);
    }

    protected abstract int getSensorType();

    protected abstract void drawSub(Canvas canvas);

    protected abstract void logic();

    protected abstract void init();

    class MyThread extends Thread {
        @Override
        public void run() {
            init();
            while (running) {

                logic();

                postInvalidate();

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected final void onDraw(Canvas canvas) {
        if (thread == null) {
            thread = new MyThread();
            thread.start();
        } else {
            drawSub(canvas);
        }
    }


    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        running = false;
        sm.unregisterListener(this);
        System.gc();
    }
}
