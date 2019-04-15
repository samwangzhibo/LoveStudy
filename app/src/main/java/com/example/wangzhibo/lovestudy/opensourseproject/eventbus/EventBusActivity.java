package com.example.wangzhibo.lovestudy.opensourseproject.eventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.wangzhibo.lovestudy.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class EventBusActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnEventBus, btnSw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);

        initViews();
        EventBus.getDefault().register(this);
    }

    private void initViews() {
        btnEventBus = findViewById(R.id.btn_event_bus);
        btnEventBus.setOnClickListener(this);
        btnSw = findViewById(R.id.btn_sw);
    }

    @Subscribe
    int onEvent(Event event){
        btnSw.setText(event.what);
        return event.what;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_event_bus:
                EventBus.getDefault().post(new Event(123));
                break;
        }
    }

}
