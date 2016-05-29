package com.panshen.com.rain.rain;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.util.AttributeSet;

import com.panshen.com.rain.BaseView;
import com.panshen.com.rain.R;

public class RainView extends BaseView {

	private ArrayList<RainItem> list = new ArrayList<>();
	private int rainNum = 80;
	private int size;
	private int rainColor;
	private boolean randColor;

	public RainView(Context context, AttributeSet attrs) {
		super(context, attrs);

		TypedArray ta = context.obtainStyledAttributes(attrs,
				R.styleable.RainView);

		rainNum = ta.getInteger(R.styleable.RainView_rainNum, 80);
		size = ta.getInteger(R.styleable.RainView_size, 20);
		rainColor = ta.getInteger(R.styleable.RainView_rainColor, 0xffffffff);
		randColor = ta.getBoolean(R.styleable.RainView_randColor, false);
		ta.recycle();
	}

	public RainView(Context context) {
		super(context);
	}

	@Override
	protected void drawSub(Canvas canvas) {
		for (RainItem item : list) {
			item.draw(canvas);
		}
	}

	@Override
	protected void logic() {
		for (RainItem item : list) {
			item.move();
		}
	}

	@Override
	protected void init() {
		for (int i = 0; i < rainNum; i++) {
			RainItem item = new RainItem(getWidth(), getHeight(), size,
					rainColor, randColor);
			list.add(item);
		}
	}

	@Override
	public void onSensorChanged(SensorEvent event) {

	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {

	}
}
