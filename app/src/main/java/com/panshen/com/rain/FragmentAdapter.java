package com.panshen.com.rain;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.panshen.com.rain.fragment.frag_cloud;
import com.panshen.com.rain.fragment.frag_rain;

import java.util.ArrayList;

public class FragmentAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> frags;
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        frags = new ArrayList<>();
        frags.add(new frag_cloud());
        frags.add(new frag_rain());
    }

    @Override
    public Fragment getItem(int position) {
        return frags.get(position);
    }

    @Override
    public int getCount() {
        return frags.size();
    }
}
