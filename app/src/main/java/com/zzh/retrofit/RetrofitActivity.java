package com.zzh.retrofit;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.zzh.ZZHConstants;
import com.zzh.alldemo.R;
import com.zzh.alldemo.base.BaseActivity;
import com.zzh.retrofit.model.HospitalAndDepartment;
import com.zzh.retrofit.service.ZZHService;

import retrofit.RestAdapter;

public class RetrofitActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        init();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        Log.d(TAG, "initData: -------start-------"+System.currentTimeMillis());
        Thread task = new Thread(){
            @Override
            public void run() {
                RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(ZZHConstants.URL_BASE_TEST_JSON)//
                        .build();
                ZZHService service = restAdapter.create(ZZHService.class);
                HospitalAndDepartment net = service.getDataFromNet("hospitalsAndDepartments");
                Log.d(TAG,""+net+"---"+System.currentTimeMillis());
            }
        };
        task.start();
    }

    @Override
    protected void setViewListener() {

    }

    @Override
    protected void handlerMessage(Message msg) {

    }

    @Override
    public void onClick(View v) {

    }
}
