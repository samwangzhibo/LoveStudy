package com.example.wangzhibo.lovestudy.animation;

import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * 自定义动画
 * Created by samwangzhibo on 2019/3/20.
 */

public class CustomAnimation extends Animation {
    private static final String TAG = "CustomAnimation";
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        float translationX = (float) Math.sin(interpolatedTime * 50) * 80;
        float translationY = (float) Math.sin(interpolatedTime * 50) * 80;
        // 50越大频率越高，80越小振幅越小

        Log.e(TAG, "interpolatedTime : " + interpolatedTime + ", translationX=" + translationX
                + ", translationY = " + translationY);
        t.getMatrix().setTranslate(translationX, translationY);

        super.applyTransformation(interpolatedTime, t);
    }
}
