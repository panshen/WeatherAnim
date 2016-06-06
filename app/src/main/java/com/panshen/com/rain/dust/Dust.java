package com.panshen.com.rain.dust;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.panshen.com.rain.BaseActiveElement;

import java.util.Random;

public class Dust implements BaseActiveElement {

    private int width;
    private int height;
    private float X;
    private float Y;
    private float opt;
    private Paint paint;
    private Random random;
    private float[] ops = {0.2f, 0.1f, 0.03f,0.4f,0.6f};
    private float[] dustWidth = {2.5f, 1f, 2f};
    private float radius;
    public Dust(int width, int height) {
        this.width = width;
        this.height = height;
        random = new Random();
        paint = new Paint();

        init();
    }

    private void init() {
        paint.reset();
        paint.setStrokeWidth(2);
        radius = dustWidth[new Random().nextInt(dustWidth.length)];
        paint.setColor(Color.parseColor("#d9be6d"));
        X = random.nextInt(width);
        Y = random.nextInt(height);
        opt = ops[random.nextInt(ops.length)];
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(X, Y, radius, paint);
    }

    public void move() {

        X += opt;

        Y += opt;

        if (X > width || X < 0 || Y > height || Y < 0) {
            init();
        }
    }

    @Override
    public void ControlX(float i) {
        X += i;
    }

    @Override
    public void ControlY(float i) {
        Y += i;
    }

    public void ControlZ(float i) {
        //Y+=
    }
}
