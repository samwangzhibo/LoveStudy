package com.example.wangzhibo.lovestudy;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import com.example.wangzhibo.lovestudy.handler.HandlerActivity;
import com.example.wangzhibo.lovestudy.service.MathService;

public class MainActivity extends Activity implements View.OnClickListener, ServiceConnection{
    MathService mathService;
    Button commuteWithServiceBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_goto_handler_act).setOnClickListener(this);
        commuteWithServiceBtn = findViewById(R.id.btn_commute_with_service);
        commuteWithServiceBtn.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_goto_handler_act:
                    startActivity(new Intent(MainActivity.this, HandlerActivity.class));
                    break;
            case R.id.btn_commute_with_service:
                if (mathService == null) {
                    //开启service
                    Intent intent = new Intent(MainActivity.this, MathService.class);
                    bindService(intent, this, BIND_AUTO_CREATE);
                    commuteWithServiceBtn.setText("连接成功，点击获取service数据");
                }else {
                    commuteWithServiceBtn.setText("获取service数据 : " + mathService.getNum());
                }
                break;
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(this);
        mathService.release();
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        mathService = ((MathService.MathBinder) service).getService();
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        mathService = null;
    }
}
