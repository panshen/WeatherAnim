package com.panshen.com.rain.rain;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.panshen.com.rain.BaseElement;

 class RainWall implements BaseElement {
    private Paint mPaint;
    private int mWidth, mHeight;
    private int mColor;
    public RainWall(int width, int height, int color) {
        mWidth = width;
        mHeight = height;
        mColor = color;
        init();
    }

    public void init() {
        mPaint = new Paint();
        mPaint.setColor(mColor);
    }

    public void draw(Canvas canvas) {
        canvas.drawRect(0, 0, mWidth, mHeight, mPaint);
    }
}
