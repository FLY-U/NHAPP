package com.zhanghao.nhapp.dialog;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zhanghao.nhapp.R;
import com.zhanghao.nhapp.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MySimpleDialog extends BaseDialog implements View.OnClickListener {

    @BindView(R.id.tv_delete)
    TextView tvDelete;
    @BindView(R.id.tv_woman)
    TextView tvWoman;
    @BindView(R.id.btn_cancle)
    Button btnCancle;
    @BindView(R.id.ll_out)
    LinearLayout llOut;
    Context context;

    public MySimpleDialog(Context context) {
        super(context);
        setContentView(R.layout.dialog_delete_photo);
        ButterKnife.bind(this);
        this.context = context;
        setLoaction(Gravity.BOTTOM); //调用父类方法，设置弹框位置

        init(); //初始化控件的点击事件
    }
    private void init() {
        btnCancle.setOnClickListener(this);
        tvWoman.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_woman:  //删除按钮
                dismiss();
                ToastUtils.showMyToast(context, R.layout.layout_toast_delete, R.id.toast);
                break;
            case R.id.btn_cancle:
                dismiss();
                break;
        }
    }
}
