package com.zzh.alldemo.activity;

import android.os.Bundle;
import android.view.View;

import com.zzh.alldemo.R;
import com.zzh.alldemo.base.BaseActivity;

/**
 * 测试封装的BaseActivity
 */
public class WrapperActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrapper);
        findViewById(R.id.button5).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button5:
                show("显示的提示信息阿斯顿发送到发送到发送到显示的提示信息阿斯顿发送到发送到发送到显示的提示信息阿斯顿发送到发送到发送到显示的提示信息阿斯顿发送到发送到发送到");
                break;
        }
    }
}
