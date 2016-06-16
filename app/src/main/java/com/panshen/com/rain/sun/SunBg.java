package com.panshen.com.rain.sun;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.panshen.com.rain.BaseActiveElement;


 class SunBg implements BaseActiveElement {
    private Paint mPaint;
    private int mWidth, mHeight;
    private int mColor;
    public SunBg(int width, int height, Context context, int color) {
        mWidth = width;
        mHeight = height;
        mColor = color;
        init();
    }

    public void init() {
        mPaint = new Paint();
        mPaint.setColor(mColor);
    }

    @Override
    public void move() {

    }

    public void draw(Canvas canvas) {
        canvas.drawRect(0, 0, mWidth, mHeight, mPaint);
    }

    @Override
    public void SetX(float i) {

    }

    @Override
    public void SetY(float i) {

    }
}
