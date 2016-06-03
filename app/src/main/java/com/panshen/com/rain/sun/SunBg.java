package com.panshen.com.rain.sun;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

public class SunBg {
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

    public void draw(Canvas canvas) {
        canvas.drawRect(0, 0, mWidth, mHeight, mPaint);
    }
}
