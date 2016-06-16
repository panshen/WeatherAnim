package com.panshen.com.rain.activity;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.panshen.com.rain.PointEvaluator;
import com.panshen.com.rain.mPoint;

public class Utils  {
    public static ValueAnimator getAnim(int dur){
        mPoint startMPoint = new mPoint(0, 0);
        mPoint endMPoint = new mPoint(0, -100);
        ValueAnimator ReverseAnim = ValueAnimator.ofObject(new PointEvaluator(), startMPoint, endMPoint);
        ReverseAnim.setDuration(dur);
        ReverseAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        ReverseAnim.setRepeatCount(ValueAnimator.INFINITE);
        ReverseAnim.setRepeatMode(ValueAnimator.REVERSE);
        return ReverseAnim;
    }
//    public void StartDropAnim() {
//        mPoint startMPoint = new mPoint(0, -1000);
//        mPoint endMPoint = new mPoint(0, 0);
//        ValueAnimator DropAnim = ValueAnimator.ofObject(new PointEvaluator(), startMPoint, endMPoint);
//        DropAnim.setDuration(1500);
//        DropAnim.setInterpolator(new OvershootInterpolator());
//        DropAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                currentMPoint = (mPoint) animation.getAnimatedValue();
//                for (Cloud mcl : clouds) {
//                    mcl.ControlY((int) currentMPoint.getY());
//                }
//            }
//        });
//        DropAnim.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                super.onAnimationEnd(animation);
//                // StartReverseAnimY();
//                for (Cloud mcl : clouds) {
//                    //mcl.AnimEnd();
//                }
//            }
//        });
//        DropAnim.start();
//    }
}
