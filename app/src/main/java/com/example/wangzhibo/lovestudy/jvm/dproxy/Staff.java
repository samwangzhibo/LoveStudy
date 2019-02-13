package com.example.wangzhibo.lovestudy.jvm.dproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 会员类
 * Created by samwangzhibo on 2019/1/31.
 */

public class Staff implements InvocationHandler {
    private String name;
    private Boss boss;

    public Staff(Boss boss, String name) {
        this.boss = boss;
        this.name = name;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = method.invoke(boss, args);
        System.out.println(name+"替"+object);
        return object;
    }
}
