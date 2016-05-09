package com.zzh.vaeview;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zzh.alldemo.R;
import com.zzh.alldemo.base.BaseActivity;

public class VaeViewActivity extends BaseActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vae_view);
        init();
    }

    @Override
    protected void initView() {
        Log.e(TAG, "initView: initviewsv---------------");
    }

    @Override
    protected void initData() {
        Log.e(TAG, "initData: initData---------------");
    }

    @Override
    protected void setViewListener() {
        Log.e(TAG, "setViewListener: setViewListener---------------");
    }

    @Override
    protected void handlerMessage(Message msg) {

    }

    @Override
    public void onClick(View v) {

    }
}
