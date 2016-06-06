package com.panshen.com.rain.cloud;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.panshen.com.rain.BaseActiveElement;

public class CloudBg implements BaseActiveElement {
    private Paint mPaint;
    private int radius, x, y;
    private Context mContext;
    private int mWidth, mHeight;
    private String BKC = "#4a9122";
    private int mColor;

    public CloudBg(int width, int height, Context context, int color) {
        mWidth = width;
        mHeight = height;
        this.mContext = context;
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
    public void ControlX(float i) {

    }

    @Override
    public void ControlY(float i) {

    }
}
