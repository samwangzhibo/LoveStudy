package com.example.wangzhibo.lovestudy.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MathService extends Service {
    SendThread thread;
    public MathService() {
    }

    @Override
    public void onCreate() {
        thread = new SendThread();
        thread.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MathBinder();
    }

    public class MathBinder extends Binder{
        //返回service
        public MathService getService(){
            return MathService.this;
        }
    }

    //获取线程的num
    public int getNum(){
        return thread.getNum();
    }

    public void release() {
        thread.setEnd(true);
    }

    class SendThread extends Thread {
        int num = 0;
        boolean isEnd = false;
        private final int DURATION_SLEEP = 1000;

        /**
         * 关闭线程
         * @param end
         */
        void setEnd(boolean end) {
            isEnd = end;
        }

        public int getNum(){
            return num;
        }

        @Override
        public void run() {
            super.run();
            while (!isEnd) {
                num++;
                try {
                    //不释放资源 休眠
                    Thread.sleep(DURATION_SLEEP);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
