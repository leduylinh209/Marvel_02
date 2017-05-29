package com.framgia.marvel.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.framgia.marvel.ui.fragment.ImageFragment;

import java.util.List;

/**
 * Created by asus on 5/30/2017.
 */
public class ImagePagerAdapter extends FragmentPagerAdapter {
    private List<ImageFragment> mFragments;

    public ImagePagerAdapter(FragmentManager fm, List<ImageFragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
