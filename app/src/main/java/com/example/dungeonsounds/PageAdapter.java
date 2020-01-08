package com.example.dungeonsounds;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    private int numbertabs;

    public PageAdapter(FragmentManager fm, int numbertabs) {
        super(fm);
        this.numbertabs = numbertabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new fAtmosphere();
            case 1:
                return new fMusic();
            case 2:
                return new fEffects();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numbertabs;
    }

}
