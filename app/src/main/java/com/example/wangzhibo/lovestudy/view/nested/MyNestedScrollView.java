package com.example.wangzhibo.lovestudy.view.nested;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by samwangzhibo on 2019-06-12.
 */
public class MyNestedScrollView extends NestedScrollView {
  private static final String TAG = "MyNestedScrollView";
  public MyNestedScrollView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public MyNestedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @Override
  public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
    Log.e(TAG, "onStartNestedScroll: ");
    return super.onStartNestedScroll(child, target, nestedScrollAxes);
  }

  @Override
  public void stopNestedScroll(int type) {
    Log.e(TAG, "stopNestedScroll: ");
    super.stopNestedScroll(type);
  }

  @Override
  public boolean hasNestedScrollingParent(int type) {
    Log.e(TAG, "hasNestedScrollingParent: ");
    return super.hasNestedScrollingParent(type);
  }

  @Override
  public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow, int type) {
    Log.e(TAG, "dispatchNestedScroll: ");
    return super.dispatchNestedScroll(dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, offsetInWindow, type);
  }

  @Override
  public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
    Log.e(TAG, "dispatchNestedPreScroll: ");
    return super.dispatchNestedPreScroll(dx, dy, consumed, offsetInWindow);
  }
}
