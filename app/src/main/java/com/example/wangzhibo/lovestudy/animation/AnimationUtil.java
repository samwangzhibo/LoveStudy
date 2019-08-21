package com.example.wangzhibo.lovestudy.animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;

import com.example.wangzhibo.lovestudy.R;

/**
 * 动画测试类
 *
 * Created by samwangzhibo on 2019/3/20.
 */

public class AnimationUtil {
    View handleView;
    Context context;

    public AnimationUtil(View handleView) {
        this.handleView = handleView;
        this.context = handleView.getContext();
    }


    public void startAnim(View v) {
//        beginFrameAnim();

//        beginTweenAnim();

//        beginCustomTweenAnim();

//        beginPropertyAnim();

//      scaleFromRightBottomCorner(v);
      changeBigFromRightBottomCorner(v);
    }

  private void changeBigFromRightBottomCorner(View view) {

    AnimatorSet animatorSet = new AnimatorSet();

    // mask放大
    ValueAnimator maskWidthScaleAnimator = ObjectAnimator.ofFloat(view.getWidth(), 2 * view.getWidth());
    maskWidthScaleAnimator.setDuration(5000);
    ValueAnimator maskHeightScaleAnimator = ObjectAnimator.ofFloat(view.getHeight(), 2 * view.getHeight());
    maskHeightScaleAnimator.setDuration(5000);

    maskWidthScaleAnimator.addUpdateListener(animation -> {
      float width = (float) animation.getAnimatedValue();
      view.getLayoutParams().width = (int) width;
      view.requestLayout();
    });
    maskHeightScaleAnimator.addUpdateListener(animation -> {
      float height = (float) animation.getAnimatedValue();
      view.getLayoutParams().height = (int) height;
      view.requestLayout();
    });

    animatorSet.setInterpolator(new LinearInterpolator());
    animatorSet.playTogether(maskWidthScaleAnimator, maskHeightScaleAnimator);
    animatorSet.start();
  }

  /**
     * 1.开启帧动画
     */
    private void beginFrameAnim() {
        //和上述xml定义方法的效果相同
        AnimationDrawable ad = new AnimationDrawable();//1.创建AnimationDrawable对象
        ColorDrawable redDrawable = new ColorDrawable(Color.RED);
        ColorDrawable yellowDrawable = new ColorDrawable(Color.YELLOW);
        ColorDrawable blueDrawable = new ColorDrawable(Color.BLUE);
        ad.addFrame(redDrawable, 500); //2.添加图片帧和时间
        ad.addFrame(yellowDrawable, 500);
        ad.addFrame(blueDrawable, 500);

        ad.setOneShot(false);//3.设置是否执行一次
        handleView.setBackground(ad);//4.将帧动画作为view背景
        ad.start();//5.播放动画
    }

    /**
     * 2. 开启Tween动画
     */
    private void beginTweenAnim() {
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setFillAfter(true);

        TranslateAnimation translateAnimation = new TranslateAnimation(0, 500, 0, 500);
        translateAnimation.setDuration(3000);
        translateAnimation.setFillAfter(false);
        translateAnimation.setStartTime(System.currentTimeMillis() + 5000);
        animationSet.addAnimation(translateAnimation);


        RotateAnimation rotateAnimation = new RotateAnimation(0f, 180f,
                RotateAnimation.RELATIVE_TO_SELF, 0.5f,
        RotateAnimation.RELATIVE_TO_SELF, 0.5f);
        translateAnimation.setFillAfter(false);
        rotateAnimation.setDuration(3000);
        animationSet.addAnimation(rotateAnimation);

        handleView.startAnimation(animationSet);
    }

    /**
     * 2.1 开启自定义补间动画  通过插值器时间和Matrix
     *
     *  Viewe.Animation mCurrentAnimation
     */
    private void beginCustomTweenAnim(){
        Animation customAnimation = new CustomAnimation();
//        customAnimation.setFillAfter(true);
//        customAnimation.setDuration(3000);

//        customAnimation = new TVCloseAni();

        ThirdDRotationAnim thirdDRotationAnim = new ThirdDRotationAnim();
        thirdDRotationAnim.setRotateY(-30);

        handleView.startAnimation(thirdDRotationAnim);
    }

    /**
     * 3. 属性动画
     * VSync同步信号调用回调
     */
    public void beginPropertyAnim() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(handleView, "translationX", 0, 300);
        objectAnimator.start();
    }

    public void scaleFromRightBottomCorner(View view){
      view.setPivotX(view.getMeasuredWidth());
      view.setPivotY(view.getMeasuredHeight());

      AnimatorSet animatorSet = new AnimatorSet();

      // mask放大
      ValueAnimator maskWidthScaleAnimator = ObjectAnimator.ofFloat(1, 2);
      maskWidthScaleAnimator.setDuration(2000);
      ValueAnimator maskHeightScaleAnimator = ObjectAnimator.ofFloat(1, 2);
      maskHeightScaleAnimator.setDuration(2000);
      maskWidthScaleAnimator.addUpdateListener(animation -> {
        float scaleX = (float) animation.getAnimatedValue();
        view.setScaleX(scaleX);
      });
      maskHeightScaleAnimator.addUpdateListener(animation -> {
        float scaleY = (float) animation.getAnimatedValue();
        view.setScaleY(scaleY);
      });

      animatorSet.setInterpolator(new AccelerateInterpolator());
      animatorSet.playTogether(maskWidthScaleAnimator, maskHeightScaleAnimator);
      animatorSet.start();
    }



}
