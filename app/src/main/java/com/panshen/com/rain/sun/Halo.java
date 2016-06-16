package com.panshen.com.rain.sun;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;

import com.panshen.com.rain.BaseActiveElement;
import com.panshen.com.rain.Polygon;
import com.panshen.com.rain.mPoint;

import java.util.ArrayList;

 class Halo implements BaseActiveElement {
    private Paint mPaint;
    private int mWidth, mHeight;
    private int mColor;
    private ArrayList<mPoint> points = new ArrayList<>();
    private ArrayList<Path> paths = new ArrayList<>();
    private float xx = 1.0f;
    private float cX, cY = -100f;
    private float xxx;
    private float mAlpha;
    private float fff;

    public Halo(int xxx, int width, int height, Context context, int color) {
        mWidth = width;
        mHeight = height;
        mColor = color;
        cX = mWidth / 2;
        cY = mHeight / 2;
        this.xxx = xxx;
        init();
    }

    public void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.WHITE);
        paths.add(new Path());
        paths.add(new Path());
        paths.add(new Path());
        paths.add(new Path());
        Polygon mp = new Polygon(new int[6], new int[6], 100);
        mp.posOfPoint(6);
        points.addAll(mp.getPoints());

        //初始化n个多边形的path
        for (int p = 0; p < paths.size(); p++) {
            Polygon mmp = new Polygon(new int[6], new int[6], (p + 1) * 30);
            mmp.posOfPoint(6);
            mmp.getPoints();
            for (int i = 0; i < points.size(); i++) {
                if (i == 0)
                    paths.get(p).moveTo(mmp.getPoints().get(0).getX(), mmp.getPoints().get(0).getY());
                paths.get(p).lineTo(mmp.getPoints().get(i).getX(), mmp.getPoints().get(i).getY());
            }
            paths.get(p).lineTo(mmp.getPoints().get(0).getX(), mmp.getPoints().get(0).getY());
        }
    }

    public void move() {

    }

    public void SetY(float i) {
        cY = mHeight / 2 + i * 10;

    }

    public void SetX(float i) {
        cX = mWidth / 2 + i * 10;
        fff = 0 - (i * 8);
    }

    public void Alpha(float f) {
        if (f < 0.0f) return;
        mAlpha = f * 25;
    }

    public void draw(Canvas canvas) {
        for (int i = 0; i < paths.size(); i++) {
            canvas.save();
            canvas.translate(cX + i * fff, cY + i * 200);
            canvas.rotate(xx);
            xx += 0.07f;
            if (xx >= 360.0f) xx = 0.0f;
            mPaint.setAlpha((int) mAlpha);
            canvas.drawPath(paths.get(i), mPaint);
            canvas.restore();
        }
    }
}
