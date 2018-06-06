package com.zhanghao.nhapp.utils;

import android.content.Context;
import android.content.Intent;

public class MoveUtils {
    /**
     * 跳转Activity
     *
     * @param context
     * @param clazz
     */
    public static void go(Context context, Class clazz) {
        context.startActivity(new Intent(context, clazz));
    }
}
