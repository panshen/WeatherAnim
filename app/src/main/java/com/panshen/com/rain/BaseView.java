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
    SensorManager sm;
    Sensor sensor;
    private Context context;
    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseView(Context context) {
        super(context);
        this.context = context;
    }

    protected abstract void drawSub(Canvas canvas);

    protected  abstract void logic();

    protected abstract void init();

    class MyThread extends Thread {
        @Override
        public void run() {
            init();
            while (running) {

                logic();

                postInvalidate();//draw

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
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        sm = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        running = false;
        sm.unregisterListener(this);
    }

}
