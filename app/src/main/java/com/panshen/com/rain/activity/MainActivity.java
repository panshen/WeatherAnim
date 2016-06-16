package com.panshen.com.rain.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.panshen.com.rain.R;
import com.panshen.com.rain.cloud.CloudView;
import com.panshen.com.rain.dust.DustView;
import com.panshen.com.rain.mist.MistView;
import com.panshen.com.rain.rain.mRainView;
import com.panshen.com.rain.sun.SunView;
import com.panshen.com.rain.sunnight.SunNightView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(WeatherView.getInstance().get(WeatherView.Weather.CLOUD, WeatherView.Situation.NIGHT, this));
    }
}
