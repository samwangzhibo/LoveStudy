package com.example.wangzhibo.lovestudy;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.wangzhibo.lovestudy.handler.HandlerActivity;
import com.example.wangzhibo.lovestudy.service.IRemoteService;
import com.example.wangzhibo.lovestudy.service.IServiceCallback;
import com.example.wangzhibo.lovestudy.service.MathService;
import com.example.wangzhibo.lovestudy.service.RemoteService;

public class MainActivity extends Activity implements View.OnClickListener, ServiceConnection {
    private static final String TAG = "MainActivity";
    MathService mathService;
    Button commuteWithServiceBtn;
    ServiceConnection serviceConnection;

    IRemoteService iRemoteService;
    ServiceConnection remoteServiceConnection;
    Button commuteWithRemoteServiceBtn;

    Button commuteWithRemoteServiceBtn2;
    IServiceCallback callback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_goto_handler_act).setOnClickListener(this);
        commuteWithServiceBtn = findViewById(R.id.btn_commute_with_service);
        commuteWithServiceBtn.setOnClickListener(this);

        commuteWithRemoteServiceBtn = findViewById(R.id.btn_commute_with_remote_service);
        commuteWithRemoteServiceBtn.setOnClickListener(this);

        commuteWithRemoteServiceBtn2 = findViewById(R.id.btn_commute_with_remote_service_2);
        commuteWithRemoteServiceBtn2.setOnClickListener(this);
    }

    private void initRemoteServiceConnection() {
        remoteServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.e(TAG, Thread.currentThread().getName());
                iRemoteService = IRemoteService.Stub.asInterface(service);
                try {
                    iRemoteService.registerListener(callback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                try {
                    iRemoteService.unRegisterListener(callback);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                iRemoteService = null;
            }
        };

        callback = new IServiceCallback.Stub() {

            @Override
            public void notifyNum(final int num) throws RemoteException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        commuteWithRemoteServiceBtn2.setText("获取service数据 : " + num);
                    }
                });
            }
        };
    }

    private void initServiceConnnection() {
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mathService = ((MathService.MathBinder) service).getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                mathService = null;
            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_goto_handler_act:
                startActivity(new Intent(MainActivity.this, HandlerActivity.class));
                break;
            case R.id.btn_commute_with_service:
                if (mathService == null) {
                    //开启service
                    initServiceConnnection();
                    Intent intent = new Intent(MainActivity.this, MathService.class);
                    bindService(intent, this, BIND_AUTO_CREATE);
                    commuteWithServiceBtn.setText("连接成功，点击获取service数据");
                } else {
                    commuteWithServiceBtn.setText("获取service数据 : " + mathService.getNum());
                }
                break;

            case R.id.btn_commute_with_remote_service:
                if (iRemoteService == null) {
                    //开启service
                    initRemoteServiceConnection();
                    Intent intent = new Intent(MainActivity.this, RemoteService.class);
                    bindService(intent, remoteServiceConnection, BIND_AUTO_CREATE);
                    commuteWithRemoteServiceBtn.setText("连接成功，点击获取跨进程service数据");
                } else {
                    try {
                        commuteWithRemoteServiceBtn.setText("获取service数据 : " + iRemoteService.getNum());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.btn_commute_with_remote_service_2:
                if (iRemoteService == null) {
                    //开启service
                    initRemoteServiceConnection();
                    Intent intent = new Intent(MainActivity.this, RemoteService.class);
                    bindService(intent, remoteServiceConnection, BIND_AUTO_CREATE);
                    commuteWithRemoteServiceBtn2.setText("连接成功，点击获取跨进程service数据");
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (remoteServiceConnection != null) {
            unbindService(remoteServiceConnection);
        }
        if (serviceConnection != null) {
            unbindService(serviceConnection);
        }
        if (mathService != null){
            mathService.release();
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
//        iRemoteService = IRemoteService.Stub.asInterface(service);
        mathService = ((MathService.MathBinder) service).getService();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
//        iRemoteService = null;
        mathService = null;
    }
}
