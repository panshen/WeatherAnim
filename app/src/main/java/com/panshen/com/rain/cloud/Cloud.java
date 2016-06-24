package com.panshen.com.rain.cloud;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.panshen.com.rain.BaseActiveElement;
import com.panshen.com.rain.RPoint;

import java.util.Random;

 class Cloud implements BaseActiveElement {
    private Paint mPaint;
    private float radius, x, y;
    private int mWidth, mHeight;
    private int mColor;
    private int xx;
    private Random random;
    private float CenterY;
    RPoint currentRPoint;
    public Cloud(int xx, int width, int height, Context context, int color) {
        this.mWidth = width;
        this.xx = xx;
        this.mHeight = height;
        this.mColor = color;
        random = new Random();
        init();
    }


    private void init() {
        mPaint = new Paint();
        mPaint.setColor(mColor);
        this.radius = mWidth / 3 + new Random().nextInt(200);
        this.x = random.nextInt(mWidth);
        this.y = random.nextInt(100);
        CenterY = random.nextInt(100);
        currentRPoint = new RPoint(0, mHeight);
    }

    public void move() {

    }

    public void SetX(float i) {
        x = ((xx + i) * 30);
    }

    public void SetY(float i) {
        y = i * 20;
    }

    public void ControlY(float i) {
        CenterY = i;
    }

    public void ControlX(float i) {
        x = i;
    }

    public void draw(Canvas canvas) {
        canvas.save();
        canvas.translate(0, CenterY);

        canvas.drawCircle(x, y, radius, mPaint);

        canvas.restore();
    }
}
