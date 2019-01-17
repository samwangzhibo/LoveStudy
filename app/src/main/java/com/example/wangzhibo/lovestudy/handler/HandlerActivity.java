package com.example.wangzhibo.lovestudy.handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

import com.example.wangzhibo.lovestudy.R;

/**
 *   最简单的Handler、Looper、Message使用指南一(附github源码) 文章的代码示例
 *   https://blog.csdn.net/wangzhibo666/article/details/86516422
 *   create by wangzhibo666
 */
public class HandlerActivity extends Activity {
    private static final int WHAT_MODIFY_TV = 100;
    TextView tvReciver;
    SendThread sendThread;
    Handler mainHandler2 = new Handler();
    Handler mainHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case WHAT_MODIFY_TV:
                    tvReciver.setText("接受子线程传递的参数：" + msg.obj);
                    break;
                default:
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        tvReciver = findViewById(R.id.tv_receiver);
        //开启一个子线程，一直朝主线程发送数据
        sendThread = new SendThread();
        sendThread.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //退出时候切记 关闭线程 回收资源 !!!!
        sendThread.setEnd(true);
    }

    class SendThread extends Thread {
        int num = 0;
        boolean isEnd = false;
        private final int DURATION_SLEEP = 1000;

        void setEnd(boolean end) {
            isEnd = end;
        }

        @Override
        public void run() {
            super.run();
            while (!isEnd) {
                mainHandler.sendMessage(Message.obtain(mainHandler, WHAT_MODIFY_TV, num++));
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
