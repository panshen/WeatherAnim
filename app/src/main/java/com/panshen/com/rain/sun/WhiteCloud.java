package com.panshen.com.rain.sun;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.panshen.com.rain.Point;

import java.util.Random;

public class WhiteCloud {
    private Paint mPaint;
    private int radius, x, y;
    private Context mContext;
    private int mWidth, mHeight;
    private String BKC = "#4a9122";
    private int mColor;
    private int[] sizes = {50,100,80,200};
    boolean isStartAnimCompl = false;
    private Point p;
    public WhiteCloud(int width, int height, Context context, int color) {
        mWidth = width;
        mHeight = height;
        this.mContext = context;
        mColor = color;
        radius = width/4+new Random().nextInt(200);
        init();
    }



    public void AnimEnd(){
        isStartAnimCompl = true;
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(mColor);
        x = new Random().nextInt(mWidth);
        y = new Random().nextInt(30);
    }

    public void move() {
        if(isStartAnimCompl){

        }
//        if (radius < mWidth / 3 + sizes[new Random().nextInt(sizes.length)]) {
//            radius += 1;
//        }
    }

    public void ControlX(int i) {
        this.x = i;
    }

    public void ControlY(int i) {
        this.y = i;
    }


    public void draw(Canvas canvas) {
        canvas.drawCircle(x, y, radius, mPaint);
    }

    private void drawCoordinateSystemm(Canvas canvas) {
        canvas.save();

        Paint fuzhuPaint = new Paint();
        fuzhuPaint.setColor(Color.parseColor("#e2000000"));
        fuzhuPaint.setStrokeWidth(5);
        fuzhuPaint.setAlpha(100);
        fuzhuPaint.setStyle(Paint.Style.FILL);

        canvas.drawRect(0, 0, mWidth, mHeight, fuzhuPaint);

        canvas.restore();
    }
}
