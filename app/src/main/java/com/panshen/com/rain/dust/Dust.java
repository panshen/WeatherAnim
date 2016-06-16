package com.panshen.com.rain.dust;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.panshen.com.rain.BaseActiveElement;

import java.util.Random;

 class Dust implements BaseActiveElement {

    private int width;
    private int height;
    private float X;
    private float Y;
    private float optx,opty;
    private Paint paint;
    private Random random;
    private float[] opsx = {0.2f, 0.1f, 0.03f,0.4f,0.6f,-0.2f,-0.03f,-0.1f,-0.15f,-0.6f,-2.0f};
    private float[] dustWidth = {2.5f, 1f, 2f,1f};
    private float radius;
    private int color;
    public Dust(int width, int height,int color) {
        this.width = width;
        this.height = height;
        random = new Random();
        paint = new Paint();
        this.color = color;
        init();
    }

    private void init() {
        paint.setStrokeWidth(2);
        radius = dustWidth[new Random().nextInt(dustWidth.length)];
        paint.setColor(color);
        X = random.nextInt(width);
        Y = random.nextInt(height);
        optx = opsx[random.nextInt(opsx.length)];
        opty = opsx[random.nextInt(opsx.length)];
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(X, Y, radius, paint);
    }

    public void move() {

        X += optx+0.5f;

        Y += opty+0.5f;

        if (X > width || X < 0 || Y > height || Y < 0) {
            init();
        }
    }

    @Override
    public void SetX(float i) {
        //X += i*100;
    }

    @Override
    public void SetY(float i) {
       // Y += i*100;
    }

    public void ControlZ(float i) {
        //Y+=
    }
}
