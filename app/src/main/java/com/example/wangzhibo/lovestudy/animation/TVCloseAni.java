package com.example.wangzhibo.lovestudy.animation;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by samwangzhibo on 2019/3/21.
 */

public class TVCloseAni extends Animation {
    private int mCenterWidth, mCenterHeight;

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        // 设置默认时长
        setDuration(4000);
        // 保持动画的结束状态
        setFillAfter(false);
        // 设置默认插值器
        // setInterpolator(new BounceInterpolator());// 回弹效果的插值器
        mCenterWidth = width / 2;
        mCenterHeight = height /2;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        Matrix matrix = t.getMatrix();
        matrix.preScale(1,
                1 - interpolatedTime,
                mCenterWidth,
                mCenterHeight);
    }
}
