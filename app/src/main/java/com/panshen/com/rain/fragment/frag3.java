package com.panshen.com.rain.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.panshen.com.rain.activity.WeatherView;

public class frag3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return WeatherView.getInstance().get(WeatherView.Weather.CLOUD, WeatherView.Situation.NIGHT, getActivity());
    }
}
