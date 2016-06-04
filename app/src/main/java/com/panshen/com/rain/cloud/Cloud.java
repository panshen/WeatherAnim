package com.panshen.com.rain.cloud;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.panshen.com.rain.Beam;

import java.util.Random;

public class Cloud implements Beam {
    private Paint mPaint;
    private float radius, x, y;
    private Context mContext;
    private int mWidth, mHeight;
    private int mColor;
    private int xx;

    public Cloud(int xx, int width, int height, Context context, int color) {
        this.mWidth = width;
        this.xx = xx;
        this.mHeight = height;
        this.mContext = context;
        this.mColor = color;

        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(mColor);

        this.radius = mWidth / 4 + new Random().nextInt(200);
        this.x = new Random().nextInt(mWidth);
        this.y = new Random().nextInt(100);
    }

    public void move() {

    }

    public void ControlX(float i) {
       x = ((xx + i) * 30);
    }

    public void ControlY(float i) {
        y = i * 20;
    }

    public void ControlY(int i) {
        y = i;
    }

    public void ControlX(int i) {
        x = i;
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(x, y, radius, mPaint);
    }
}
