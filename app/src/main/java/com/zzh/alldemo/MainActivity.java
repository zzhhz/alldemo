package com.zzh.alldemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.zzh.alldemo.activity.TestActivity;
import com.zzh.alldemo.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button:
                Intent intent = new Intent(this, TestActivity.class);
                startActivity(intent);
                break;
        }
    }
}