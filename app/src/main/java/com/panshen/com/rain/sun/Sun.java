package com.panshen.com.rain.sun;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

import com.panshen.com.rain.BaseActiveElement;
import com.panshen.com.rain.Polygon;
import com.panshen.com.rain.mPoint;

import java.util.ArrayList;

public class Sun implements BaseActiveElement {
    private Paint mPaint;
    private int mWidth, mHeight;
    private int mColor;
    private float xx = 1.0f;
    private int xxx;
    private float cX, cY = -100f;
    private ArrayList<mPoint> points = new ArrayList<>();
    private int PolygonWidth;
    Path path;

    public Sun(int xxx, int width, int height, Context context, int color, int PW) {
        mWidth = width;
        mHeight = height;
        mColor = color;
       this. xxx = xxx;
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

        Polygon mp = new Polygon(new int[9], new int[9], PolygonWidth);
        mp.posOfPoint(9);
        points.addAll(mp.getPoints());

        for (int i = 0; i < points.size(); i++) {
            if (i == 0)
                path.moveTo(points.get(0).getX(), points.get(0).getY());
            path.lineTo(points.get(i).getX(), points.get(i).getY());
        }
        path.lineTo(points.get(0).getX(), points.get(0).getY());
    }

    public void move() {

    }


    public void SetY(float i) {
        cY = i * 30;
    }

    public void SetX(float i) {
        cX = (xxx + i)*30;
    }

    public void draw(Canvas canvas) {

        canvas.save();
        canvas.translate(cX, cY);
        canvas.rotate(xx);

        xx += (float) PolygonWidth / 1500;
        if (xx >= 360.0f) xx = 0.0f;

        canvas.drawPath(path, mPaint);
        canvas.restore();
    }
}