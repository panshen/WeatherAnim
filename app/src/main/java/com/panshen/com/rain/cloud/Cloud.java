package com.panshen.com.rain.cloud;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.panshen.com.rain.Point;
import com.panshen.com.rain.PointEvaluator;

import java.util.Random;

public class Cloud {
    private Paint mPaint;
    private float radius, x, y;
    private Context mContext;
    private int mWidth, mHeight;
    private String BKC = "#4a9122";
    private int mColor;
    private int[] sizes = {50, 100, 80, 200};
    boolean isStartAnimCompl = false;
    private Point p;

    public Cloud(int width, int height, Context context, int color) {
        mWidth = width;
        mHeight = height;
        this.mContext = context;
        mColor = color;
        //mColor = Color.parseColor("#4a9122");
        radius = width / 4 + new Random().nextInt(200);
        init();
    }


    public void AnimEnd() {
        isStartAnimCompl = true;
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(mColor);
        x = new Random().nextInt(mWidth);
        y = new Random().nextInt(30);
    }

    public void move() {
        if (isStartAnimCompl) {

        }
//        if (radius < mWidth / 3 + sizes[new Random().nextInt(sizes.length)]) {
//            radius += 1;
//        }

    }

    public void ControlX(float i) {
        this.x += i*20;
    }

    public void reduceX() {
        this.x -= 1;
    }

    public void plusX() {
        this.x += 1;
    }
    public void reduceY() {
        this.y -= 30;
    }

    public void plusY() {
        this.y += 30;
    }

    public void ControlY(float i) {
        this.y = i*25;
    }
    public void ControlY(int i) {
        this.y = i;
    }

    public void ControlSize(float i) {
        this.radius = i + new Random().nextInt(200);
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(x, y, radius, mPaint);
    }

}
