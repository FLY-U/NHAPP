package com.zhanghao.nhapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhanghao.nhapp.Base.BaseActivity;
import com.zhanghao.nhapp.Fragment.FirstFragment;
import com.zhanghao.nhapp.adapter.QFragmentPagerAdapter;
import com.zhanghao.nhapp.widget.NoScrollViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.tv_title_main)
    TextView tvTitleMain;
    @BindView(R.id.activity_address)
    RelativeLayout activityAddress;
    @BindView(R.id.v_main)
    NoScrollViewPager vMain;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.ll_tab_1)
    LinearLayout llTab1;
    @BindView(R.id.ll_tab_2)
    LinearLayout llTab2;
    @BindView(R.id.ll_tab_3)
    LinearLayout llTab3;
    @BindView(R.id.imgview)
    ImageView imgview;
    @BindView(R.id.ag_msgcount)
    TextView agMsgcount;
    @BindView(R.id.tv_mg)
    TextView tvMg;
    @BindView(R.id.ll_tab_4)
    LinearLayout llTab4;
    @BindView(R.id.ll_main)
    LinearLayout llMain;
    private ArrayList<Fragment> fragmentArray;
    private QFragmentPagerAdapter fragmentAdapter;
    private LinearLayout lastTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //测试分支
        ButterKnife.bind(this);
        initClickEvent();
        initFragment(); //初始化Fragment
    }
    private void initFragment(){
        fragmentArray = new ArrayList<>();

        fragmentArray.add(new FirstFragment());
        fragmentAdapter = new QFragmentPagerAdapter(getSupportFragmentManager(), fragmentArray);
        vMain.setAdapter(fragmentAdapter);


        lastTab = llTab1;
        changePage(0, llTab1); //设置默认选中第一个
        tvTitleMain.setText("第一页");
    }
    private void changePage(int item, LinearLayout currentTab) {
        if (lastTab != null) {
            lastTab.setSelected(false);
            currentTab.setSelected(true);
            vMain.setCurrentItem(item, false);
            lastTab = currentTab;
        }

    }
    private void initClickEvent() {
        llTab1.setOnClickListener(this);
        llTab2.setOnClickListener(this);
        llTab3.setOnClickListener(this);
        llTab4.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.ll_tab_1:
                changePage(0, llTab1);
                tvTitleMain.setText("第一页");
                break;
            case R.id.ll_tab_2:
                changePage(1, llTab2);
                tvTitleMain.setText("第二页");
                break;
            case R.id.ll_tab_3:
                changePage(2, llTab3);
                tvTitleMain.setText("第三页");
                break;
            case R.id.ll_tab_4:
                changePage(3, llTab4);
                tvTitleMain.setText("第四页");
                break;
        }
    }

}
