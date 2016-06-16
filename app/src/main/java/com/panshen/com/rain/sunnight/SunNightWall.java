package com.panshen.com.rain.sunnight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

 class SunNightWall {
    private Paint mPaint;
    private int mWidth, mHeight;
    private int mColor;
    public SunNightWall(int width, int height, Context context, int color) {
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
