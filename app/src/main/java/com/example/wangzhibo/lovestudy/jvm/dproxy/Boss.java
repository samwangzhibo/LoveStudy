package com.example.wangzhibo.lovestudy.jvm.dproxy;

/**
 * 老板类实现
 * Created by samwangzhibo on 2019/1/31.
 */

public class Boss implements IBossImpl {

    @Override
    public String buy(Object things) {
        return "老板买"+things;
    }

    @Override
    public String email(Object emailAddress) {
        return "老板发邮件"+emailAddress;
    }

}


