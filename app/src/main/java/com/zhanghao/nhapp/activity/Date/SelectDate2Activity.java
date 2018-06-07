package com.zhanghao.nhapp.activity.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zhanghao.nhapp.Base.BaseActivity;
import com.zhanghao.nhapp.R;
import com.zhanghao.nhapp.utils.LogUtils;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectDate2Activity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.tv_select_date)
    TextView tvSelectDate;
    @BindView(R.id.tv_start_date)
    TextView tvStartDate;
    @BindView(R.id.tv_end_date)
    TextView tvEndDate;

    private VDate _checkInVDate,_checkOutVDate;
    public final static long DAY_IN_MILLIS = 1 * 1000 * 60 * 60 * 24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date2);
        ButterKnife.bind(this);
        initClickEvent();
    }
    private void initClickEvent() {
        tvSelectDate.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_select_date:
                Date checkInDate = new Date(System.currentTimeMillis() + DAY_IN_MILLIS);
                _checkInVDate = new VDate(checkInDate);
                Date checkOutDate = new Date(System.currentTimeMillis() + DAY_IN_MILLIS * 2);//2���
                _checkOutVDate = new VDate(checkOutDate);
                Intent intent = new Intent(SelectDate2Activity.this, DateActivity.class);
                intent.putExtra("checkInDate", _checkInVDate);
                intent.putExtra("checkOutDate", _checkOutVDate);
                startActivityForResult(intent, 0);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (data != null) {
                switch (requestCode) {
                    case 0:
                        _checkInVDate = (VDate) (data.getSerializableExtra("checkInDate"));
                        _checkOutVDate = (VDate) (data.getSerializableExtra("checkOutDate"));
                        setDateViews(_checkInVDate, tvStartDate);
                        setDateViews(_checkOutVDate, tvEndDate);
                        break;
                }

            }
        }
    }
    /**
     */
    private void setDateViews(VDate vDate, TextView checkDate) {
        int year = vDate.getYear();
        int month = vDate.getMonth();
        int day = vDate.getDay();
//        LogUtils.i(year+"-"+month+"-"+day);
        int week = CalendarUtil.getWeek(year, month, day);
        String result = year + "-" + month + "-" + day;
        switch (week) {
            case Calendar.MONDAY:
                result += " 星期一";
                break;
            case Calendar.TUESDAY:
                result += " 星期二";
                break;
            case Calendar.WEDNESDAY:
                result += " 星期三";
                break;
            case Calendar.THURSDAY:
                result += " 星期四";
                break;
            case Calendar.FRIDAY:
                result += " 星期五";
                break;
            case Calendar.SATURDAY:
                result += " 星期六";
                break;
            case Calendar.SUNDAY:
                result += " 星期日";
                break;
        }
        checkDate.setText(result);
    }
}
