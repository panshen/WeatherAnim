package com.panshen.com.rain.dust;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.panshen.com.rain.BaseElement;

public class DustWall implements BaseElement {
    private Paint mPaint;
    private int mWidth, mHeight;
    private int mColor;
    public DustWall(int width, int height, int color) {
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
