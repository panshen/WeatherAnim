package com.panshen.com.rain.mist;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.panshen.com.rain.BaseActiveElement;
import com.panshen.com.rain.R;

public class MistBg implements BaseActiveElement {
    private Paint mPaint;
    private int mWidth, mHeight;
    private int mColor;
    private Context mContext;

    public MistBg(int width, int height, Context context, int color) {
        mWidth = width;
        mHeight = height;
        mColor = color;
        mContext = context;
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
        drawDay(canvas);
    }

    public void drawDay(Canvas canvas) {
        canvas.drawRect(0, 0, mWidth, mHeight, mPaint);
    }

    @Override
    public void SetX(float i) {

    }

    @Override
    public void SetY(float i) {

    }
}
