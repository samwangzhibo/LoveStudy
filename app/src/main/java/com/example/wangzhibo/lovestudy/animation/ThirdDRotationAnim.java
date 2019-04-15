package com.example.wangzhibo.lovestudy.animation;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.Transformation;

/**
 * 3D旋转动画  使用{@link Camera}
 * Created by samwangzhibo on 2019/3/22.
 */

public class ThirdDRotationAnim extends Animation{
    private int mCenterWidth, mCenterHeight;
    private Camera mCamera = new Camera();
    private float mRotateY = 0.0f;

    // 一般在此方法初始化一些动画相关的变量和值
    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        // 设置默认时长
        setDuration(4000);
        // 保持动画的结束状态
        setFillAfter(false);
        // 设置默认插值器
        setInterpolator(new BounceInterpolator());// 回弹效果的插值器
        mCenterWidth = width / 2;
        mCenterHeight = height /2;
    }

    // 暴露接口设置旋转角度
    public void setRotateY(float rotateY) {
        mRotateY = rotateY;
    }

    // 自定义动画的核心，在动画的执行过程中会不断回调此方法，并且每次回调interpolatedTime值都在不断变化(0----1)
    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        final Matrix matrix = t.getMatrix();
        mCamera.save();
        // 使用Camera设置Y轴方向的旋转角度
        mCamera.rotateY(mRotateY * interpolatedTime);
        // 将旋转变化作用到matrix上
        mCamera.getMatrix(matrix);
        mCamera.restore();

        // 通过pre方法设置矩阵作用前的偏移量来改变旋转中心
        matrix.preTranslate(mCenterWidth, mCenterHeight);// 在旋转之前开始位移动画
        matrix.postTranslate(-mCenterWidth, -mCenterHeight);// 在旋转之后开始位移动画
    }

}
