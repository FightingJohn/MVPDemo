package com.tianlanse.mvpdemo.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by 木木 on 2016/6/14.
 * toast提示框
 */
public class ToastUtil {

    public static void shortToast(Context context, String text) {
        if(!TextUtils.isEmpty(text) && !"".equals(text.trim())){
            showToast(context, text, Toast.LENGTH_SHORT);
        }
    }

    public static void showToast(Context context, String text, int duration) {
        if (context == null){
            return;
        }
        if (context != null && context instanceof Activity) {
            if(((Activity) context).isFinishing()) {
                return;
            }
        }
        if(!TextUtils.isEmpty(text) && !"".equals(text.trim())){
            Toast.makeText(context, text, duration).show();
        }
    }
}
