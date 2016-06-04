package com.panshen.com.rain.cloud;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;

import com.panshen.com.rain.Beam;

import java.util.Random;

public class CloudBg implements Beam{
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
