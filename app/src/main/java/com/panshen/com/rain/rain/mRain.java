package com.panshen.com.rain.rain;


import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

import com.panshen.com.rain.BaseActiveElement;

import java.util.Random;

 class mRain implements BaseActiveElement {

    private int width;
    private int height;
    private float X;
    private float Y;
    private float optx;
    private Paint paint;
    private Random random;
    private float[] opsx = {0.2f, 0.1f, 0.03f, 0.4f, 0.6f};
    private float[] dustWidth = {2.5f, 1f, 2f, 1f};
    private float radius;
    private int color;
    private float centerX, centerY;
    private int startX, startY;
    private int xx;
    Path path = new Path();
    public mRain(int width, int height, int color) {
        this.width = width;
        this.height = height;
        random = new Random();
        paint = new Paint();
        this.color = color;
        centerX = width / 2;
        centerY = height / 2;
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(color);
        radius = dustWidth[new Random().nextInt(dustWidth.length)];

        optx = opsx[random.nextInt(opsx.length)];
        this.xx = width / 35;

        startX = random.nextInt(width+300);
        startY = random.nextInt(height+300);

        init();
    }

    private void init() {
        X = random.nextInt(width);
        Y = random.nextInt(height);
    }

    public void draw(Canvas canvas) {

        path.reset();
        path.moveTo(startX,startY);
        path.lineTo(centerX,centerY);

        canvas.drawPath(path,paint);

    }

    public void move() {
//        X--;
//        Y--;
//        if (X == 0 || Y == 0) {
//            init();
//        }
    }

    @Override
    public void SetX(float i) {
        if (Math.abs(i) < 0.5f) return;
        centerX -= i * 5;
    }

    @Override
    public void SetY(float i) {
        if (Math.abs(i) < 0.5f) return;
        centerY += i * 5;
    }

    public void ControlZ(float i) {

    }
}
