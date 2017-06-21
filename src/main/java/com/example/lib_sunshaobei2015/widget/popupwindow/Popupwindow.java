package com.example.lib_sunshaobei2015.widget.popupwindow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.example.lib_sunshaobei2015.R;

/**
 * Created by sunshaobei on 2017/6/7.
 */

public class Popupwindow {

    private PopupWindow popupWindow;
    private View popupview;
    private int popupHeight;
    private int popupWidth;


    public Popupwindow(Context context,int rid) {
        popupview = LayoutInflater.from(context).inflate(rid, null);
        popupWindow = new PopupWindow(popupview, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setAnimationStyle(R.style.popupwindow_style);
        popupWindow.setBackgroundDrawable(new BitmapDrawable(context.getResources(), (Bitmap) null));
    }


    public <T extends View> T getView(int id){
        View view = popupview.findViewById(id);
        return (T) view;
    }

    public void showAtDown(View view)
    {
        popupWindow.showAsDropDown(view);
    }
    public void showAtUp(View view)
    {
        popupview.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        popupHeight = popupview.getMeasuredHeight();
        popupWidth = popupview.getMeasuredWidth();
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        //在控件上方显示
        popupWindow.showAtLocation(view, Gravity.NO_GRAVITY, (location[0] + view.getWidth() / 2) - popupWidth / 2, location[1] - popupHeight);

    }
}
