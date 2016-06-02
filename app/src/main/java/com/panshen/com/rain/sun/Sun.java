package com.panshen.com.rain.sun;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;

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

    private int cX, cY;
    private ArrayList<mPoint> points = new ArrayList<>();
    private int PolygonWidth;

    public Sun(int width, int height, Context context, int color, int PolygonWidth) {
        mWidth = width;
        mHeight = height;
        this.mContext = context;
        mColor = color;

        cX = mWidth / 2;
        cY = mHeight / 2;
        this.PolygonWidth = PolygonWidth;
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
    }

    public void move() {

    }

    public void draw(Canvas canvas) {
        Path path = new Path();
        canvas.save();
        canvas.translate(cX, 0);

        canvas.rotate(xx);
        xx += PolygonWidth / 200;
        if (xx >= 360) xx = 0;

        for (int i = 0; i < points.size(); i++) {
            if (i == 0)
                path.moveTo(points.get(0).getX(), points.get(0).getY());
            path.lineTo(points.get(i).getX(), points.get(i).getY());
        }
        path.lineTo(points.get(0).getX(), points.get(0).getY());
        path.close();
        canvas.drawPath(path, mPaint);
        canvas.restore();
    }
}