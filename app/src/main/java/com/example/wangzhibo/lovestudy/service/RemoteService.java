package com.example.wangzhibo.lovestudy.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;

public class RemoteService extends Service {
    SendThread thread;
    private RemoteCallbackList<IServiceCallback> mRemoteCallbackList = new RemoteCallbackList<>();
    IServiceCallback iServicecallBack;
    public RemoteService() {
    }

    @Override
    public void onCreate() {
        thread = new SendThread();
        thread.start();
        thread.setITaskCallback(new SendThread.ITaskCallback() {
            @Override
            public void onTasking(int num) {
                try {
                    if (iServicecallBack != null) {
                        iServicecallBack.notifyNum(num);
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
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
            iServicecallBack = callBack;
        }

        @Override
        public void unRegisterListener(IServiceCallback callBack) throws RemoteException {
            iServicecallBack = null;
        }

    };

    public void release() {
        thread.setEnd(true);
    }
}
