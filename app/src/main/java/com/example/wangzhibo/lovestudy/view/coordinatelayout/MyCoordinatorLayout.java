package com.example.wangzhibo.lovestudy.view.coordinatelayout;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.NestedScrollingParentHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by samwangzhibo on 2019-06-12.
 */
public class MyCoordinatorLayout extends CoordinatorLayout {
  private static final String TAG = "MyCoordinatorLayout";
  NestedScrollingParentHelper mNestedScrollingParentHelper;
  public MyCoordinatorLayout(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public MyCoordinatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
  }

  @Override
  public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
    Log.e(TAG, "onStartNestedScroll: ");
    return super.onStartNestedScroll(child, target, nestedScrollAxes);
  }

  @Override
  public boolean onStartNestedScroll(View child, View target, int axes, int type) {
    Log.e(TAG, "onStartNestedScroll: ");
    return super.onStartNestedScroll(child, target, axes, type);
  }

  @Override
  public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {

    super.onNestedScrollAccepted(child, target, nestedScrollAxes);
  }

  @Override
  public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes, int type) {
    Log.e(TAG, "onNestedScrollAccepted: ");
    super.onNestedScrollAccepted(child, target, nestedScrollAxes, type);
  }

  @Override
  public void onStopNestedScroll(View target) {
    super.onStopNestedScroll(target);
  }

  @Override
  public void onStopNestedScroll(View target, int type) {
    Log.e(TAG, "onStopNestedScroll: ");
    super.onStopNestedScroll(target, type);
  }

  @Override
  public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
    super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed);
  }

  @Override
  public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
    Log.e(TAG, "onNestedScroll: ");
    super.onNestedScroll(target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
  }

  @Override
  public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
    super.onNestedPreScroll(target, dx, dy, consumed);
  }

  @Override
  public void onNestedPreScroll(View target, int dx, int dy, int[] consumed, int type) {
    Log.e(TAG, "onNestedPreScroll: ");
    super.onNestedPreScroll(target, dx, dy, consumed, type);
  }
}
