package com.example.wangzhibo.lovestudy.jvm.dproxy;

import java.lang.reflect.Proxy;

/**
 * Created by samwangzhibo on 2019/1/31.
 */

public class DProxyTest {
    public static void main(String[] args) {
        IBossImpl staff = (IBossImpl) Proxy.newProxyInstance(DProxyTest.class.getClassLoader(),
                new Class[]{IBossImpl.class}, new Staff(new Boss(), "小秘"));
        staff.buy("奶茶");
        staff.email("12345@qq.com");
    }
}
