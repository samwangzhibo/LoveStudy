package com.example.wangzhibo.lovestudy.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

/**
 * Created by samwangzhibo on 2019/1/25.
 */

public class DispatchButton extends Button {
    private static final String TAG = "DispatchButton";
    public DispatchButton(Context context) {
        super(context);
    }

    public DispatchButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "  dispatchTouchEvent : " + ev.getAction());
        boolean superResult = super.dispatchTouchEvent(ev);
        Log.e(TAG, "  dispatchTouchEvent result : " + superResult);
        return superResult;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        Log.e(TAG, "  onTouchEvent : " + ev.getAction());
        boolean superResult = super.onTouchEvent(ev);
//        switch (ev.getAction()){
//            case MotionEvent.ACTION_DOWN:
//                Log.e(TAG, "  onTouchEvent result : " + false);
//                return false;
////                break;
//            case MotionEvent.ACTION_UP:
//                Log.e(TAG, "  onTouchEvent result : " + true);
//                return true;
////                break;
//        }
        Log.e(TAG, "  onTouchEvent result : " + superResult);
        return superResult;
    }

    @Override
    public boolean post(Runnable action) {
        return super.post(action);
    }
}
