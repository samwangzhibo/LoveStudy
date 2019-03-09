package com.example.wangzhibo.lovestudy.jvm.dproxy;

import java.lang.reflect.Proxy;

/**
 * Created by samwangzhibo on 2019/1/31.
 */

public class DProxyTest {
    public static void main(String[] args) {
        // 从源码中得知，设置这个值，可以把生成的代理类，输出出来。
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        IBossImpl staff = (IBossImpl) Proxy.newProxyInstance(DProxyTest.class.getClassLoader(),
                new Class[]{IBossImpl.class}, new Staff(new Boss(), "小秘"));
        staff.buy("奶茶");
        staff.email("12345@qq.com");
    }
}
