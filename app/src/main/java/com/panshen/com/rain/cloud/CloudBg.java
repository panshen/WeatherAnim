package com.panshen.com.rain.cloud;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.panshen.com.rain.BaseActiveElement;
import com.panshen.com.rain.R;

public class CloudBg implements BaseActiveElement {
    private Paint mPaint;
    private int mWidth, mHeight;
    private int mColor;
    private boolean daymode;
    private Context mContext;

    /**
     * width 屏幕宽度
     * height 屏幕高度
     * color  背景主要颜色
     */
    public CloudBg(int width, int height, Context context, int color) {
        mWidth = width;
        mHeight = height;
        mColor = color;
        mContext = context;
        init();

    }

    public void init() {
        if (mColor == mContext.getResources().getColor(R.color.colorCloudBackgroundDay))
            daymode = true;
        else {
            daymode = false;
            mColor = mContext.getResources().getColor(R.color.colorCloudBackgroundNight);
        }
        mPaint = new Paint();
        mPaint.setColor(mColor);
    }

    @Override
    public void move() {

    }

    public void draw(Canvas canvas) {
        if (daymode) {
            drawDay(canvas);
        } else {
            drawNight(canvas);
        }
    }

    public void drawDay(Canvas canvas) {
        canvas.drawRect(0, 0, mWidth, mHeight, mPaint);
    }

    public void drawNight(Canvas canvas) {
        canvas.drawRect(0, 0, mWidth, mHeight, mPaint);


    }

    @Override
    public void SetX(float i) {

    }

    @Override
    public void SetY(float i) {

    }
}
