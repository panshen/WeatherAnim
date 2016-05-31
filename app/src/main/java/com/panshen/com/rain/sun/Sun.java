package com.panshen.com.rain.sun;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;

import com.panshen.com.rain.mPoint;

import java.util.ArrayList;

public class Sun {
    private Paint mPaint;
    private int radius, x, y;
    private Context mContext;
    private int mWidth, mHeight;
    private String BKC = "#4a9122";
    private int mColor;
    private int Rheight = 200;
    private int xx = 1;
    Paint fuzhuPaint;
    Path path = new Path();
    private int cX, cY;
    private int[] xxz = new int[9];
    private int[] yxz = new int[9];
    private ArrayList<mPoint> points = new ArrayList<>();

    public Sun(int width, int height, Context context, int color) {
        mWidth = width;
        mHeight = height;
        this.mContext = context;
        mColor = color;
        init();
        cX = mWidth / 2;
        cY = mHeight / 2;
    }

    public void init() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(3);
        mPaint.setColor(mColor);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);

        MyPolygon mp = new MyPolygon(xxz, yxz);
        mp.posOfPoint(9);
        points.addAll(mp.getPoints());
    }

    public void move() {

    }

    public void draw(Canvas canvas) {
        canvas.translate(cX, cY);
        canvas.drawRect(0, 0, 10, 10, mPaint);

        for (int i = 0; i < points.size(); i++) {
            if (i == 0)
                path.moveTo(points.get(0).getX(), points.get(0).getY());

            path.lineTo(points.get(i).getX(), points.get(i).getY());
        }
        path.lineTo(points.get(0).getX(), points.get(0).getY());
        path.close();
        canvas.drawPath(path, mPaint);
    }
}