package com.example.mvvm0619;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

public class FragmentViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public FragmentViewPagerAdapter(@NonNull FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.fragments = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
