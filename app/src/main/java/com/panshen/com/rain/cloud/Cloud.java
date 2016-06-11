package com.panshen.com.rain.cloud;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.panshen.com.rain.BaseActiveElement;

import java.util.Random;

public class Cloud implements BaseActiveElement {
    private Paint mPaint;
    private float radius, x, y;
    private Context mContext;
    private int mWidth, mHeight;
    private int mColor;
    private int xx;
    private int moveRate;
    private Random random;
    private float CenterY;

    public Cloud(int xx, int width, int height, Context context, int color) {
        this.mWidth = width;
        this.xx = xx;
        this.mHeight = height;
        this.mContext = context;
        this.mColor = color;
        random = new Random();
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(mColor);
        this.radius = mWidth / 4 + new Random().nextInt(200);
        this.moveRate = random.nextInt((int) radius / 5);
        this.x = random.nextInt(mWidth);
        this.y = random.nextInt(100);

        CenterY = random.nextInt(100);

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
