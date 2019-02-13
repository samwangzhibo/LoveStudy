package com.example.wangzhibo.lovestudy.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Created by samwangzhibo on 2019/1/25.
 */

public class DispatchFrameLayout extends FrameLayout {
    private static final String TAG = "DispatchFrameLayout";
    public DispatchFrameLayout(Context context) {
        super(context);
    }

    public DispatchFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, " dispatchTouchEvent : " + ev.getAction());
        boolean superResult = super.dispatchTouchEvent(ev);
        Log.e(TAG, " dispatchTouchEvent result: " + superResult);
        return superResult;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG, "  onInterceptTouchEvent : " + ev.getAction());
        boolean superResult = super.onInterceptTouchEvent(ev);
        Log.e(TAG, " onInterceptTouchEvent result: " + superResult);
        return superResult;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.e(TAG, "  onTouchEvent : " + ev.getAction());
        boolean superResult = super.onTouchEvent(ev);
        Log.e(TAG, " onTouchEvent result: " + superResult);
        return superResult;
    }
}
