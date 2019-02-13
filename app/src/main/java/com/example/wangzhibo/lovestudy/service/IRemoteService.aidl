// IRemoteService.aidl
package com.example.wangzhibo.lovestudy.service;
import com.example.wangzhibo.lovestudy.service.IServiceCallback;
// Declare any non-default types here with import statements

interface IRemoteService {
    //获取num
    int getNum();
    //关闭Service线程
    void setEnd(boolean isEnd);
    //注册binder
    void registerListener(IServiceCallback callBack);
    //关闭binder
    void unRegisterListener(IServiceCallback callBack);
}
