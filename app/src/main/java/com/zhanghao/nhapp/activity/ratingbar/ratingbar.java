package com.zhanghao.nhapp.activity.ratingbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import com.zhanghao.nhapp.R;
import com.zhanghao.nhapp.widget.MyRatingBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ratingbar extends AppCompatActivity {

    @BindView(R.id.ratingbar)
    RatingBar ratingbar;
    @BindView(R.id.star)
    MyRatingBar myRatingBar;
    @BindView(R.id.activity_rating_bar)
    LinearLayout activityRatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratingbar);
        ButterKnife.bind(this);
        initRatingBar();
        initData();
    }
    private void initRatingBar() {
        ratingbar.setRating(3);
    }

    //    自定义ratingbar
    private void initData() {
        myRatingBar.setClickable(false);
        myRatingBar.setStar(2.5f);

        myRatingBar.setClickable(true);
        myRatingBar.setOnRatingChangeListener(new MyRatingBar.OnRatingChangeListener() {
            @Override
            public void onRatingChange(float ratingCount) {
                Log.i("test111","ratingCount:"+ratingCount);
                myRatingBar.setStar(ratingCount);
            }
        });
    }
}
