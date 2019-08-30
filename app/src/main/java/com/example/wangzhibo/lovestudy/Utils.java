package com.example.wangzhibo.lovestudy;

import android.content.Context;

/**
 * Created by samwangzhibo on 2019-08-29.
 */
public class Utils {
  public static int dip2px(Context context, float dpValue) {
    final float scale = context.getResources().getDisplayMetrics().density;
    return (int) (dpValue * scale + 0.5f);
  }
}
