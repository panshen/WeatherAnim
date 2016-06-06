package com.panshen.com.rain.sunnight;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.panshen.com.rain.BaseActiveElement;

public class SunNight implements BaseActiveElement {
    private Paint mPaint;
    private RectF mRectF;
    private RectF mRectFCircle;
    private int mWidth, mHeight;
    private int mColor;
    private float mRate = 1.0f;
    private int xxx;
    private float cX, cY = -100f;
    private float redius;
    private int strokWidth;
    private int CircleLength;
    public SunNight(int CircleLength, int strokWidth, int xxx, int width, int height, int color) {
        mWidth = width;
        mHeight = height;
        mColor = color;
        this.xxx = 20;
        this.strokWidth = strokWidth;
        this.redius = xxx;
        this.CircleLength = CircleLength;
        cX = mWidth / 2;
        cY = mHeight / 2;
        init();
    }

    public void init() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(strokWidth);
        mPaint.setColor(mColor);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        //圆弧
        mRectF = new RectF(-redius, -redius, redius, redius);
        mRectFCircle = new RectF(-redius, -redius, redius, redius);
    }

    public void move() {

    }


    public void ControlY(float i) {
        cY = i * 30;
    }

    public void ControlX(float i) {
        cX = (xxx + i) * 20 - mWidth / 2;
    }

    public void draw(Canvas canvas) {

        canvas.save();
        canvas.translate(cX, cY);
        canvas.rotate(mRate);
        /*
        * 半径越大转的越快产生旋转不一致的感觉。
        * 应该让圆弧长度不一样 而速率一样
        * */
        mRate += redius / 1000f;
        if (mRate >= 360.0f) mRate = 0.0f;
        if (redius / 200 == 1 || redius / 700 == 1 || redius / 800 == 1 || redius / 1100 == 1)
            canvas.drawCircle(0, 0, redius, mPaint);
        else
            canvas.drawArc(mRectF, 0, CircleLength, false, mPaint);

        canvas.restore();
    }
}