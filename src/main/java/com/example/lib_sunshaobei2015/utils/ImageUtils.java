package com.example.lib_sunshaobei2015.utils;

import android.app.Activity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by sunshaobei on 2017/6/2.
 */

public class ImageUtils {
    public static void LoadCircleImage(Activity context, String url, ImageView imageView)
    {
        Glide.with(context)
                .load(url)
                .transform(new GlideCircleTransform(context))
                .dontAnimate()
                .into(imageView);
    }
}
