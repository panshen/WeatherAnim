package com.panshen.com.rain.cloud;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.panshen.com.rain.BaseActiveElement;

import java.util.Random;


 class Csun implements BaseActiveElement {
    private Paint mPaint;
    private float radius, x, y;
    private int mWidth, mHeight;
    private int mColor;
    private int xx;
    private Random random;

    /**
     * xx 不知道
     * width view宽 height 高
     * color 颜色
     */
    public Csun(int width, int height, int color) {
        this.mWidth = width;
        this.mHeight = height;
        this.mColor = color;
        random = new Random();
        init();
    }

    private void init() {
        this.xx = mWidth / 35;
        mPaint = new Paint();
        mPaint.setColor(mColor);
        this.radius = mWidth / 8;
        this.x = mWidth - 200;
        this.y = 350;


    }

    public void move() {

    }

    public void SetX(float i) {
        x = ((xx + i) * 30);
    }

    public void SetY(float i) {
        y = ((xx / 2 + i) * 20);
    }

    public void ControlY(float i) {

    }

    @Override
    public void draw(Canvas canvas) {

        canvas.drawCircle(x, y, radius, mPaint);

    }
}

