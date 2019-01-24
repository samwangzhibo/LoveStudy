package com.example.wangzhibo.lovestudy.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;

/**
 * 最简单的Activity、Service使用、通信指南二(进程间通信)(附github源码)
 * https://blog.csdn.net/wangzhibo666/article/details/86611912
 */
public class RemoteService extends Service {
    private static final String TAG = "RemoteService";
    SendThread thread;
//    private RemoteCallbackList<IServiceCallback> mRemoteCallbackList = new RemoteCallbackList<>();
    IServiceCallback iServicecallBack;
    ArrayList<IServiceCallback> iServicecallBacks = new ArrayList<>();
    public RemoteService() {
    }

    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate");
        thread = new SendThread();
        thread.start();
        thread.setITaskCallback(new SendThread.ITaskCallback() {
            @Override
            public void onTasking(int num) {
                try {
//                    if (iServicecallBack != null) {
//                        iServicecallBack.notifyNum(num);
//                    }
                    for (IServiceCallback iServiceCallback : iServicecallBacks){
                        iServiceCallback.notifyNum(num);
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return remoteService;
    }

    IRemoteService.Stub remoteService = new IRemoteService.Stub() {
        @Override
        public int getNum() throws RemoteException {
            return thread.getNum();
        }

        @Override
        public void setEnd(boolean isEnd) throws RemoteException {
            if (isEnd) {
                release();
            }
        }

        @Override
        public void registerListener(IServiceCallback callBack) throws RemoteException {
//            iServicecallBack = callBack;
            iServicecallBacks.add(callBack);
        }

        @Override
        public void unRegisterListener(IServiceCallback callBack) throws RemoteException {
//            iServicecallBack = null;
            iServicecallBacks.clear();
        }

    };

    public void release() {
        thread.setEnd(true);
    }
}
