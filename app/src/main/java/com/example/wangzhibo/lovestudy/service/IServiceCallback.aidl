// ServiceCallback.aidl
package com.example.wangzhibo.lovestudy.service;

// Declare any non-default types here with import statements

interface IServiceCallback {
    //Service通知Activity的方法
    //在里面设置按钮文案
    void notifyNum(int num);
}
