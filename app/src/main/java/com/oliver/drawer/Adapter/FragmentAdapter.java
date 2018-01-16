package com.oliver.drawer.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Oliver on 1/11/2018.
 */

public class FragmentAdapter extends FragmentPagerAdapter {
    ArrayList<Fragment> fragmenti = new ArrayList<>();
    ArrayList<String> titles = new ArrayList<>();

    public void AddFragments(Fragment fragment){
        fragmenti.add(fragment);

    }


    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmenti.get(position);
    }

    @Override
    public int getCount() {
        return fragmenti.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
