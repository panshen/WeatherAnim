package com.panshen.com.rain;

import android.animation.TypeEvaluator;

public class PointEvaluator implements TypeEvaluator {

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        RPoint startRPoint = (RPoint) startValue;
        RPoint endRPoint = (RPoint) endValue;
        float x = startRPoint.getX() + fraction * (endRPoint.getX() - startRPoint.getX());
        float y = startRPoint.getY() + fraction * (endRPoint.getY() - startRPoint.getY());
        RPoint RPoint = new RPoint(x, y);
        return RPoint;
    }
}
