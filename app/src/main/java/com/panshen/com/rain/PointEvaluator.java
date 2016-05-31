package com.panshen.com.rain;

import android.animation.TypeEvaluator;

public class PointEvaluator implements TypeEvaluator {

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        mPoint startMPoint = (mPoint) startValue;
        mPoint endMPoint = (mPoint) endValue;
        float x = startMPoint.getX() + fraction * (endMPoint.getX() - startMPoint.getX());
        float y = startMPoint.getY() + fraction * (endMPoint.getY() - startMPoint.getY());
        mPoint mPoint = new mPoint(x, y);
        return mPoint;
    }
}
