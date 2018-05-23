package com.zhanghao.nhapp.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.zhanghao.nhapp.MainActivity;
import com.zhanghao.nhapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FirstFragment extends Fragment implements View.OnClickListener{
    @BindView(R.id.custname)
    EditText custname;
    @BindView(R.id.custphone)
    EditText custphone;
    @BindView(R.id.county)
    EditText county;
    PopupWindow popup;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this, view);
        initClickEvent();
        initPopupWindow();
        return view;
    }
    private void initClickEvent() {
        county.setOnClickListener(this);
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
    public void onClick(View view){
        switch (view.getId()){
            case R.id.county:
                popup.showAsDropDown(view.findViewById(R.id.county), 0,
                        0);
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
