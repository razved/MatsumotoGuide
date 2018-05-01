package com.example.android.matsumotoguide;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {
    private Context mContext;
    final int CATEGORY_COUNT = 4;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public int getCount() {
        return CATEGORY_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SightseeingFragment();
        } else if (position == 1) {
            return new HotelFragment();
        } else if (position == 2){
            return new MuseumFragment();
        } else {
            return new SpaFragment();
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.sightseeing_category);
        } else if (position == 1) {
            return mContext.getString(R.string.hotel_category);
        } else if (position == 2) {
            return mContext.getString(R.string.museum_category);
        } else {
            return mContext.getString(R.string.spa_category);
        }
    }
}
