// IRemoteService.aidl
package com.example.wangzhibo.lovestudy.service;
import com.example.wangzhibo.lovestudy.service.IServiceCallback;
// Declare any non-default types here with import statements

interface IRemoteService {
    int getNum();
    void setEnd(boolean isEnd);
    void registerListener(IServiceCallback callBack);
    void unRegisterListener(IServiceCallback callBack);
}
