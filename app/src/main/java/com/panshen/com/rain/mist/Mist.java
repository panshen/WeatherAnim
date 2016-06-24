package com.panshen.com.rain.mist;
//Min + (int)(Math.random() * ((Max - Min) + 1));

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;

import com.panshen.com.rain.BaseActiveElement;

import java.util.Random;

public class Mist implements BaseActiveElement {
    private Paint mPaint;
    private float radius, x, y;
    private int mWidth, mHeight;
    private int mColor;
    private int xx;
    private Random random;
    private int toColor = 0;

    public Mist(int y, int xx, int width, int height, int color, int tocolor, int radius) {
        this.mWidth = width;
        this.xx = xx;
        this.y = y;
        this.mHeight = height;
        this.mColor = color;
        this.toColor = tocolor;
        random = new Random();
        this.x = random.nextInt(mWidth);
        mPaint = new Paint();
        this.radius = radius;
        init();
    }

    private void init() {

        mPaint.setColor(mColor);
        mPaint.setShader(new LinearGradient(0, -radius + 100, 0, radius, new int[]{toColor, mColor},
                null, Shader.TileMode.CLAMP));
    }

    public void move() {

    }

    public void SetX(float i) {
        x = ((xx + i) * 30);
    }

    public void SetY(float i) {
        y = ((xx + i) * 20);
    }

    public void ControlY(float i) {
    }

    public void ControlX(float i) {
        x = i;
    }

    public void draw(Canvas canvas) {
        canvas.save();
        canvas.translate(x, y);
        canvas.drawCircle(0, 0, radius, mPaint);
        canvas.restore();
    }
}
