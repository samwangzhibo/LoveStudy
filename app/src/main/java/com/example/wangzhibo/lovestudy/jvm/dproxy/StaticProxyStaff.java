package com.example.wangzhibo.lovestudy.jvm.dproxy;

/**
 * 员工类 静态代理
 * Created by samwangzhibo on 2019/2/4.
 */

public class StaticProxyStaff implements IBossImpl {
    Boss boss;

    public StaticProxyStaff(Boss boss) {
        this.boss = boss;
    }

    @Override
    public String buy(Object things) {
        return boss.buy(things);
    }

    @Override
    public String email(Object emailAddress) {
        return boss.email(emailAddress);
    }
}
