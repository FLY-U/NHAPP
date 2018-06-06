package com.zhanghao.nhapp.common;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;
import android.provider.SyncStateContract;

import com.zhanghao.nhapp.Base.BaseActivity;

import org.xutils.x;

import java.util.LinkedHashMap;

public class MyApp extends Application {
    public static MyApp instance;

    //    已打开的Activity集合
    private LinkedHashMap<String, BaseActivity> activitys = new LinkedHashMap<>();

    @Override
    public void onCreate() {
        super.onCreate();
        //适配Android7.0 URI 拍照，应用安装问题
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
            builder.detectFileUriExposure();
        }

        instance = this;
        init();
    }

    private void init() {
        Constants.init(this);//初始化缓存目录
        x.Ext.init(this); //初始化xutils3网络框架
    }


    //打开一个Activity时调用
    public void openActivity(BaseActivity activity) {
        activitys.put(activity.getClass().getSimpleName(), activity);
    }

    //关闭一个Activity时调用
    public void closeActivity(String activityTAG) {
        BaseActivity baseActivity = activitys.get(activityTAG);
        baseActivity.finish();
        activitys.remove(activityTAG);
    }

    public BaseActivity getActivityByTAG(String TAG) {
        BaseActivity baseActivity = activitys.get(TAG);
        return baseActivity;
    }

    //单例模式中获取唯一的MyApp实例
    public static MyApp getInstance() {
        if (null == instance) {
            instance = new MyApp();
        }
        return instance;
    }
}
