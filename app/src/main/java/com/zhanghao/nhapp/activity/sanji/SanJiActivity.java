package com.zhanghao.nhapp.activity.sanji;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zhanghao.nhapp.Base.BaseActivity;
import com.zhanghao.nhapp.R;
import com.zhanghao.nhapp.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SanJiActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.tv_sanji1)
    TextView tvSanji1;
    @BindView(R.id.tv_sanji2)
    TextView tvSanji2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_san_ji);
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v) {
        
    }
}
