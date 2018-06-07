package com.zhanghao.nhapp.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;

public class BaseDialog extends Dialog{
    public BaseDialog(Context context) {
        super(context);
        //默认设置弹框在屏幕的底部
        getWindow().setGravity(Gravity.BOTTOM);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00000000"))); //设置背景为透明色
    }
    //设置弹框在屏幕的底部
    public void setLoaction(int loaction)
    {
        getWindow().setGravity(loaction);
    }
}
