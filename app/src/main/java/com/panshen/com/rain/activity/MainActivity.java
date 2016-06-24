package com.panshen.com.rain.activity;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        setContentView(WeatherView.getInstance().get(WeatherView.Weather.MIST, WeatherView.Situation.NIGHT, this));
    }
}
