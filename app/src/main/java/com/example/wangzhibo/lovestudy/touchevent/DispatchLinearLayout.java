package com.example.wangzhibo.lovestudy.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import android.widget.Scroller;

/**
 * scroller的使用
 *  1.重写{@link #computeScroll()} 其中使用 {@link Scroller#computeScrollOffset()}判断是否结束滑动，调用ScrollTo(dx,dy)
 *  2.startScroll 开始滑动 调用invalidate方法
 *
 *  scrollBy(0, 100)的原理
 *  调用ScrollTo() 正数的话 视图往Y轴上移动  可以理解为当前窗口的移动 而不是背景的移动s
 *
 * Created by samwangzhibo on 2019/1/25.
 */

public class DispatchLinearLayout extends LinearLayout {
    private static final String TAG = "DispatchLinearLayout";
    Scroller scroller;
    OverScroller overScroller;
    public DispatchLinearLayout(Context context) {
        this(context, null);

    }

    public DispatchLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        scroller = new Scroller(context);
        overScroller = new OverScroller(context);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
//        Log.e(TAG, " dispatchTouchEvent : " + ev.getAction());
        boolean superResult = super.dispatchTouchEvent(ev);
//        Log.e(TAG, " dispatchTouchEvent result: " + superResult);
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        Log.e(TAG, "  onInterceptTouchEvent : " + ev.getAction());
        boolean superResult = super.onInterceptTouchEvent(ev);
//        Log.e(TAG, " onInterceptTouchEvent result: " + superResult);
        return superResult;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
//        Log.e(TAG, "  onTouchEvent : " + ev.getAction());
        boolean superResult = super.onTouchEvent(ev);
//        Log.e(TAG, " onTouchEvent result: " + superResult);
        return superResult;
    }

    @Override
    public void computeScroll() {
       Log.e(TAG, "computeScroll getScrollY : " + getScrollY());
       if (scroller.computeScrollOffset()){
           scrollTo(scroller.getCurrX(), scroller.getCurrY());
           postInvalidate();
       }

//        if (overScroller.computeScrollOffset()){
//            scrollTo(overScroller.getCurrX(), overScroller.getCurrY());
//           postInvalidate();
//        }

    }

    public void testScroll() {
//        scrollBy(0, 100);

//        startScroll();

        fling();
    }

    private void fling() {
//        scroller.fling(0, 0, 1000, 1000,
//            0, 300, 0, 300);

//        scroller.fling(0, 0, -100, -100,
//                -1000, 300, -1000, 300);

        overScroller.fling(0, 0, -3000, -3000,
                100, 900, 100, 900, 0, 0);

        invalidate();
    }

    private void startScroll() {
        scroller.startScroll(300, 300, -300, -300, 3000);
        invalidate();
    }

    public void reset() {
        scrollTo(0, 0);
    }
}
