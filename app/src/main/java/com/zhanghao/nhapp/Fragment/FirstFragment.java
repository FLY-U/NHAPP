package com.zhanghao.nhapp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;

import com.zhanghao.nhapp.Entity.Area;
import com.zhanghao.nhapp.R;
import com.zhanghao.nhapp.adapter.SpinnerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirstFragment extends Fragment implements View.OnClickListener,AdapterView.OnItemSelectedListener {
    @BindView(R.id.custname)
    EditText custname;
    @BindView(R.id.custphone)
    EditText custphone;
    PopupWindow popup;
    @BindView(R.id.county)
    Spinner county;
    private ArrayList<Area> mData = null;
    private BaseAdapter myAdadpter = null;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this, view);
        initPopupWindow();
        mData = new ArrayList<Area>();
        bindViews();
        return view;
    }

    private void initPopupWindow() {
        View v = getActivity().getLayoutInflater().inflate(
                R.layout.popuplayout, null);
        popup = new PopupWindow(v, LinearLayout.LayoutParams.MATCH_PARENT, 190, true);


        popup.setFocusable(true);
        //该属性设置为true则你在点击屏幕的空白位置也会退出
        popup.setTouchable(true);

        popup.setOutsideTouchable(true);
        popup.setAnimationStyle(R.style.PopupAnimation);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.county:
                popup.showAsDropDown(view.findViewById(R.id.county), 0,
                        0);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void bindViews() {
        mData.add(new Area("石家庄"));
        mData.add(new Area("晋州"));
        mData.add(new Area("辛集"));
        myAdadpter = new SpinnerAdapter<Area>(mData,R.layout.item_spin_area) {

            @Override
            public void bindView(ViewHolder holder, Area obj) {
                holder.setText(R.id.area_name, obj.getName());
            }
        };
        county.setAdapter(myAdadpter);
        county.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
