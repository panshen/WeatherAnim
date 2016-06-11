package com.panshen.com.rain.cloud;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.panshen.com.rain.BaseElement;

import java.util.Random;

public class CloudStar implements BaseElement {
    private Paint mPaint;
    private float x, y;
    private Context mContext;
    private int mWidth, mHeight;
    private Random random;
    private int Alpha;
    private boolean growthing = true;

    public CloudStar(int xx, int width, int height, Context context, int color) {
        this.mWidth = width;
        this.mHeight = height;
        this.mContext = context;
        random = new Random();
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        this.x = random.nextInt(mWidth);
        this.y = random.nextInt(mHeight / 2 + mHeight / 4);
        Alpha = random.nextInt(255);
    }

    public void draw(Canvas canvas) {
        if (growthing) {
            Alpha += 2;
        } else {
            Alpha -= 2;
        }

        if (Alpha >= 255) {
            growthing = false;
        }

        if (Alpha <= 0) {
            growthing = true;
        }

        mPaint.setAlpha(Alpha);
        if(Alpha >255|| Alpha <0)return;
        canvas.drawRect(x, y, x + 4, y + 4, mPaint);
    }
}
