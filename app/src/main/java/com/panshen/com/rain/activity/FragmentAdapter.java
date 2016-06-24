package com.panshen.com.rain.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.panshen.com.rain.fragment.frag;
import com.panshen.com.rain.fragment.frag2;
import com.panshen.com.rain.fragment.frag3;
import com.panshen.com.rain.fragment.frag4;

import java.util.ArrayList;
import java.util.List;

public class FragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> frags = new ArrayList();

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        frags.add(new frag());
        frags.add(new frag2());
        frags.add(new frag3());
        frags.add(new frag4());
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
