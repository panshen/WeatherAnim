package com.panshen.com.rain.activity;

import android.content.Context;
import android.view.View;

import com.panshen.com.rain.cloud.CloudView;
import com.panshen.com.rain.dust.DustView;
import com.panshen.com.rain.mist.Mist;
import com.panshen.com.rain.mist.MistView;
import com.panshen.com.rain.rain.mRainView;
import com.panshen.com.rain.sun.SunView;
import com.panshen.com.rain.sunnight.SunNightView;

public class WeatherView {
    private static WeatherView ourInstance = new WeatherView();

    public static WeatherView getInstance() {
        return ourInstance;
    }

    private WeatherView() {

    }

    public View get(Weather w, Situation s, Context con) {
        View view = null;
        if (w.equals(Weather.DUST)) {
            view = new DustView(con);
        } else if (w.equals(Weather.CLOUD)) {
            if (s.equals(Situation.DAY)) {
                view = new CloudView(con, Situation.DAY);
            } else if (s.equals(Situation.NIGHT)) {
                view = new CloudView(con, Situation.NIGHT);
            } else if (s.equals(Situation.OVERCAST)) {
                view = new CloudView(con, Situation.OVERCAST);
            }
        } else if (w.equals(Weather.MIST)) {
            view = new MistView(con);
        } else if (w.equals(Weather.RAIN)) {
            view = new mRainView(con);
        } else if (w.equals(Weather.SUN)) {
            view = new SunView(con);
        } else if (w.equals(Weather.SUNNIGHT)) {
            view = new SunNightView(con);
        }
        return view;
    }

    public enum Situation {
        DAY, NIGHT, OVERCAST
    }

    public enum Weather {
        CLOUD, DUST, MIST, RAIN, SUN, SUNNIGHT
    }
}
