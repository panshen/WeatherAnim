package com.panshen.com.rain;

import android.graphics.Canvas;

public interface Beam {
    void move();

    void draw(Canvas canvas);

    void ControlX(float i);

    void ControlY(float i);
}
