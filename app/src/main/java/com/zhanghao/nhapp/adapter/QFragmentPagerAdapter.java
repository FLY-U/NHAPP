package com.zhanghao.nhapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class QFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;

    public QFragmentPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        fragmentList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList==null?null:fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList==null?0:fragmentList.size();
    }
}
