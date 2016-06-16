package com.panshen.com.rain.mist;
//此类代表一排 根据屏幕宽度 显示几个圆 一个圆 = 50dp

//Y轴坐标由view类传递进来

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.panshen.com.rain.BaseActiveElement;
import com.panshen.com.rain.mPoint;

import java.util.Random;

public class Mist implements BaseActiveElement {
    private Paint mPaint;
    private float radius = 300f, x, y;
    private int mWidth, mHeight;
    private int mColor;
    private int xx;
    private Random random;
    private float CenterY;
    mPoint currentMPoint;

    public Mist(int y, int xx, int width, int height, Context context, int color) {
        this.mWidth = width;
        this.xx = xx;
        this.y = y;
        this.mHeight = height;
        this.mColor = color;
        random = new Random();
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(mColor);
        this.x = random.nextInt(mWidth);
        CenterY = random.nextInt(100);
        currentMPoint = new mPoint(0, mHeight);
    }

    public void move() {

    }

    public void SetX(float i) {
        //x = ((xx + i) * 30);
    }

    public void SetY(float i) {
        //y = i * 20;
    }

    public void ControlY(float i) {
        CenterY = i;
    }

    public void ControlX(float i) {
        x = i;
    }

    public void draw(Canvas canvas) {
        canvas.save();
        canvas.translate(-100, CenterY);
        for (int i = 1; i < mWidth / radius+2; i++) {
            canvas.drawCircle(i*radius, y, radius, mPaint);
        }
        canvas.restore();
    }
}
