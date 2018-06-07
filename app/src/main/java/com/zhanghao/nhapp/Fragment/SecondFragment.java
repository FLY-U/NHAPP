package com.zhanghao.nhapp.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.zhanghao.nhapp.Base.BaseFragment;
import com.zhanghao.nhapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SecondFragment extends BaseFragment {
    @BindView(R.id.tb_fragment)
    TabLayout tbFragment;
    @BindView(R.id.v_fragment)
    ViewPager vFragment;
    Unbinder unbinder;
    private String titles[] = {"第一项","第二项","第三项","第四项","第五项","第六项","第七项","第八项","第九项","第十项"};
    public SecondFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        unbinder = ButterKnife.bind(this, view);
        setTab();
        return view;
    }
    private void setTab() {
        vFragment.setAdapter(new SimpleFragmentPagerAdapter(getChildFragmentManager()));
        tbFragment.setupWithViewPager(vFragment); //让TabLayout绑定ViewPager
        tbFragment.setTabMode(TabLayout.MODE_SCROLLABLE); //设置标签的显示模式
        tbFragment.setSelectedTabIndicatorColor(Color.parseColor("#4caf65"));


    }
    class SimpleFragmentPagerAdapter extends FragmentPagerAdapter
    {

        public SimpleFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            //给Fragment设置数据
            Bundle budle = new Bundle();
            budle.putInt("position",position);
            TabFragment tabFragment = new TabFragment();
            tabFragment.setArguments(budle);

            return  tabFragment;
        }

        @Override
        public int getCount() {
            if (titles == null || titles.length == 0) {
                return 0;
            }else {
                return titles.length;
            }
        }
        //初始化标题
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
