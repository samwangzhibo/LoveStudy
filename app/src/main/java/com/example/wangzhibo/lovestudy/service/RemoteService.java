package com.example.wangzhibo.lovestudy.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class RemoteService extends Service {
    public RemoteService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new RemoteBinder();
    }

    public class RemoteBinder extends Binder {
        //返回service
        public RemoteService getService(){
            return RemoteService.this;
        }
    }
}
