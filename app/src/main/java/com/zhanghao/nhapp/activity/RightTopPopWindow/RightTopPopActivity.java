package com.zhanghao.nhapp.activity.RightTopPopWindow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zhanghao.nhapp.Base.BaseActivity;
import com.zhanghao.nhapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RightTopPopActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.tv_popwindow)
    TextView tvPopwindow;
    @BindView(R.id.activity_right_top_pop)
    RelativeLayout activityRightTopPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_right_top_pop);
        ButterKnife.bind(this);

        initClickEvent();
    }
    private void initClickEvent(){
        tvPopwindow.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.tv_popwindow:
                RightTopPopWindowUtils utils = new RightTopPopWindowUtils(RightTopPopActivity.this);
                utils.showPop(tvPopwindow,2);
                break;
        }
    }
}
