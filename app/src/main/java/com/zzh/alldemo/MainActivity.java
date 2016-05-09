package com.zzh.alldemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;

import com.zzh.alldemo.activity.TestActivity;
import com.zzh.alldemo.activity.ToolbarsActivity;
import com.zzh.alldemo.activity.WrapperActivity;
import com.zzh.alldemo.base.BaseActivity;
import com.zzh.eventbus.EventBusActivity;
import com.zzh.listview.ListViewActivity;
import com.zzh.permission.PermissionActivity;
import com.zzh.popwindow.PopWindowActivity;
import com.zzh.retrofit.RetrofitActivity;
import com.zzh.vaeview.VaeViewActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void handlerMessage(Message msg) {

    }

    @Override
    protected void setViewListener() {
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
        findViewById(R.id.button8).setOnClickListener(this);
        findViewById(R.id.button9).setOnClickListener(this);
        findViewById(R.id.button11).setOnClickListener(this);
        findViewById(R.id.button12).setOnClickListener(this);
        findViewById(R.id.button13).setOnClickListener(this);
        findViewById(R.id.button14).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, TestActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                Intent intent1 = new Intent(mContext, ToolbarsActivity.class);
                startActivity(intent1);
                break;
            case R.id.button6:
            case R.id.button7:
                Intent intent2 = new Intent(mContext, WrapperActivity.class);
                startActivity(intent2);
                break;
            case R.id.button8:
                Intent intent3 = new Intent(mContext, PopWindowActivity.class);
                startActivity(intent3);
                break;
            case R.id.button9:
                Intent intent4 = new Intent(mContext, EventBusActivity.class);
                startActivity(intent4);
                break;
            case R.id.button11:
                Intent intent5 = new Intent(mContext, PermissionActivity.class);
                startActivity(intent5);
                break;
            case R.id.button12:
                Intent intent6 = new Intent(mContext, ListViewActivity.class);
                startActivity(intent6);
                break;
            case R.id.button13:
                Intent intent7 = new Intent(mContext, VaeViewActivity.class);
                startActivity(intent7);
                break;
            case R.id.button14:
                Intent intent8 = new Intent(mContext, RetrofitActivity.class);
                startActivity(intent8);
                break;
            default:
                break;
        }
    }
}
