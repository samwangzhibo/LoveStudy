package com.example.wangzhibo.lovestudy;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

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
    IServiceCallback callback;

    Button commuteWithRemoteServiceBtn2;
    ServiceConnection remoteServiceConnection2;
    IServiceCallback callback2;
    IRemoteService iRemoteService2;

    boolean isThisConnection = false;

    /**
     * 实现点击按钮的时候，还能触发背景的点击
     */
    Button testOntouchBtn;
    LinearLayout mainLl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, TAG + " onCreate");
        findViewById(R.id.btn_goto_handler_act).setOnClickListener(this);
        commuteWithServiceBtn = findViewById(R.id.btn_commute_with_service);
        commuteWithServiceBtn.setOnClickListener(this);

        commuteWithRemoteServiceBtn = findViewById(R.id.btn_commute_with_remote_service);
        commuteWithRemoteServiceBtn.setOnClickListener(this);

        commuteWithRemoteServiceBtn2 = findViewById(R.id.btn_commute_with_remote_service_2);
        commuteWithRemoteServiceBtn2.setOnClickListener(this);

        callback = new IServiceCallback.Stub() {
            @Override
            public void notifyNum(final int num) throws RemoteException {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        commuteWithRemoteServiceBtn.setText("获取service数据 : " + num);
                    }
                });
            }
        };

        testOntouchBtn = findViewById(R.id.btn_click_ontouch);
        testOntouchBtn.setOnClickListener(this);
        mainLl = findViewById(R.id.main_ll);
        mainLl.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        Log.e(TAG, TAG + " onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.e(TAG, TAG + " onResume");
        super.onResume();
    }

    private void initRemoteServiceConnection() {
        remoteServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                onRemoteServiceConnected(name, service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                onRemoteServiceDisconnected(name);
            }
        };
    }

    private void onRemoteServiceDisconnected(ComponentName name) {
//        try {
//            iRemoteService.unRegisterListener(callback);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
        iRemoteService = null;
    }

    private void onRemoteServiceConnected(ComponentName name, IBinder service) {
        iRemoteService = IRemoteService.Stub.asInterface(service);
//        try {
//            iRemoteService.registerListener(callback);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
    }

    private void initRemoteServiceConnection2() {
        remoteServiceConnection2 = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                iRemoteService2 = IRemoteService.Stub.asInterface(service);
                try {
                    iRemoteService2.registerListener(callback2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                try {
                    iRemoteService2.unRegisterListener(callback2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                iRemoteService2 = null;
            }
        };

        callback2 = new IServiceCallback.Stub() {

            @Override
            public void notifyNum(final int num) throws RemoteException {
                //这里是由binder线程调用的
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
                    bindService(intent, serviceConnection, BIND_AUTO_CREATE);
                    commuteWithServiceBtn.setText("连接成功，点击获取service数据");
                } else {
                    commuteWithServiceBtn.setText("获取service数据 : " + mathService.getNum());
                }
                break;

            case R.id.btn_commute_with_remote_service:
                if (iRemoteService == null) {
                    //开启service
//                    initRemoteServiceConnection();
                    isThisConnection = true;
                    Intent intent = new Intent(MainActivity.this, RemoteService.class);
                    bindService(intent, this, BIND_AUTO_CREATE);
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
                if (iRemoteService2 == null) {
                    //开启service
                    initRemoteServiceConnection2();
                    Intent intent = new Intent(MainActivity.this, RemoteService.class);
                    bindService(intent, remoteServiceConnection2, BIND_AUTO_CREATE);
                    commuteWithRemoteServiceBtn2.setText("连接成功，点击获取跨进程service数据");
                }
                break;
            case R.id.btn_click_ontouch:
                mainLl.performClick();
                Toast.makeText(MainActivity.this, "click btn", Toast.LENGTH_SHORT).show();
                break;
            case R.id.main_ll:
                Toast.makeText(MainActivity.this, "click main bg", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    protected void onPause() {
        Log.e(TAG, TAG + " onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.e(TAG, TAG + " onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.e(TAG, TAG + " onDestroy");
        super.onDestroy();
        if (remoteServiceConnection != null) {
            unbindService(remoteServiceConnection);
        }
        if (serviceConnection != null) {
            unbindService(serviceConnection);
        }
        if (remoteServiceConnection2 != null) {
            unbindService(remoteServiceConnection2);
        }
        if (isThisConnection) {
            unbindService(this);
        }
        if (mathService != null){
            mathService.release();
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        onRemoteServiceConnected(name, service);

//        mathService = ((MathService.MathBinder) service).getService();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        onRemoteServiceDisconnected(name);

//        mathService = null;
    }
}
