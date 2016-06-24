package com.panshen.com.rain;


import java.util.ArrayList;

public class Polygon {
    private int[] x;
    private int[] y;
    private int startX;
    private int startY;
    private int r;
    private ArrayList<RPoint> points = new ArrayList<>();

    public Polygon(int[] x, int[] y, int r) {
        this.x = x;
        this.y = y;
        startX = 0;
        startY = -r;
        this.r = r;
    }

    public void posOfPoint(int bianshu) {
        x[0] = startX;
        y[0] = startY;
        RPoint p;
        for (int i = 0; i < bianshu; i++) {
            p = nextPoint(((2 * Math.PI) / bianshu) * i);
            x[i] = (int) p.getX();
            y[i] = (int) p.getY();
            points.add(p);
        }
    }

    public ArrayList<RPoint> getPoints() {
        return points;
    }

    public RPoint nextPoint(double arc) {
        RPoint p = new RPoint();
        p.setX((int) (x[0] - r * Math.sin(arc)));
        p.setY((int) (y[0] + r - r * Math.cos(arc)));
        return p;
    }
}
