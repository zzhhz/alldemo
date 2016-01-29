package com.zzh.alldemo.activity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.zzh.alldemo.R;
import com.zzh.alldemo.base.BaseActivity;

/**
 * 测试封装的BaseActivity
 */
public class WrapperActivity extends BaseActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrapper);
        initView();
        setViewListener();
    }

    @Override
    protected void initView() {
        textView = (TextView) findViewById(R.id.textView2);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void handlerMessage(Message msg) {
    }

    @Override
    protected void setViewListener() {
        findViewById(R.id.button5).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button5:
                showMessage("显示的提示信息阿斯顿发送到发送到发送到显示的提示信息阿斯顿发送到发送到发送到显示的提示信息阿斯顿发送到发送到发送到显示的提示信息阿斯顿发送到发送到发送到");
                Message msg = Message.obtain(mHandler);
                msg.sendToTarget();
                break;
        }
    }
}
