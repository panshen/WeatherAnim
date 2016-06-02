package com.panshen.com.rain.sun;

import com.panshen.com.rain.mPoint;

import java.util.ArrayList;

class MyPolygon {
    private int[] x;
    private int[] y;
    private int startX;
    private int startY;
    private int r;
    private ArrayList<mPoint> points = new ArrayList<>();

    public MyPolygon(int[] x, int[] y,int r) {
        this.x = x;
        this.y = y;
        startX = 0;
        startY = -r;
        this.r = r;
    }

    public void posOfPoint(int bianshu) {
        x[0] = startX;
        y[0] = startY;
        mPoint p;
        for (int i = 0; i < bianshu; i++) {
            p = nextPoint(((2 * Math.PI) / bianshu) * i);
            x[i] = (int) p.getX();
            y[i] = (int) p.getY();
            points.add(p);
        }
    }

    public ArrayList<mPoint> getPoints() {
        return points;
    }

    public mPoint nextPoint(double arc) {
        mPoint p = new mPoint();
        p.setX((int) (x[0] - r * Math.sin(arc)));
        p.setY((int) (y[0] + r - r * Math.cos(arc)));
        return p;
    }
}
