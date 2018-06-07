package com.zhanghao.nhapp.Base;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.zhanghao.nhapp.common.MyApp;
import com.zhanghao.nhapp.dialog.ProgressDialog;

public class BaseFragment extends Fragment {
    public Context mContext;
    public MyApp myApp;
    public ProgressDialog progressDialog;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        myApp = MyApp.getInstance();
    }

    public void dialogShow(String message) {
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMsg(message);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void dialogShow() {
        dialogShow("加载中...");
    }

    public void dialogDismiss() {
        progressDialog.dismiss();
    }
    public void dialogComplete(ProgressDialog.OnCompleteListener listener, String complMessage) {
        progressDialog.complete(listener, complMessage);
    }
}
