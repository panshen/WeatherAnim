package com.panshen.com.rain.sun;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;

import com.panshen.com.rain.mPoint;

import java.util.ArrayList;

//pathmeasure
public class Sun {
    private Paint mPaint;
    private int mWidth, mHeight;
    private int mColor;
    private float xx = 1.0f;

    private float cX, cY = -100f;
    private ArrayList<mPoint> points = new ArrayList<>();
    private int PolygonWidth;
    Path path;

    public Sun(int width, int height, Context context, int color, int PW) {
        mWidth = width;
        mHeight = height;
        mColor = color;

        cX = mWidth / 2;
        cY = 200;
        PolygonWidth = PW;
        path = new Path();
        init();
    }

    public void init() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(3);
        mPaint.setColor(mColor);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);

        MyPolygon mp = new MyPolygon(new int[9], new int[9], PolygonWidth);
        mp.posOfPoint(9);
        points.addAll(mp.getPoints());

        for (int i = 0; i < points.size(); i++) {
            if (i == 0)
                path.moveTo(points.get(0).getX(), points.get(0).getY());
            path.lineTo(points.get(i).getX(), points.get(i).getY());
        }
        path.lineTo(points.get(0).getX(), points.get(0).getY());
        // path.reset();
    }

    public void move() {

    }

    public void ControlY(float i) {
        cY = i * 30;
    }

    public void ControlX(float i) {
        cX = i * 20;
    }

    public void draw(Canvas canvas) {

        canvas.save();
        canvas.translate(cX, cY);
        canvas.rotate(xx);

        //xx += PolygonWidth / 200;
        xx += (float)PolygonWidth/1000;
        if (xx >= 360.0f) xx = 0.0f;

        canvas.drawPath(path, mPaint);
        canvas.restore();
    }
}