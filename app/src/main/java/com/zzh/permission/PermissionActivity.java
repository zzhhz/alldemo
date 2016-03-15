package com.zzh.permission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zzh.alldemo.R;
import com.zzh.alldemo.base.BaseActivity;

/**
 * 需要6.0的设备
 */
public class PermissionActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        //init();
        setViewListener();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void setViewListener() {
        findViewById(R.id.permission).setOnClickListener(this);
        Log.e("","----------setViewListener------");
    }

    @Override
    protected void handlerMessage(Message msg) {

    }

    @Override
    public void onClick(View v) {
        //TODO 权限测试还没个好方法
        switch (v.getId()) {
            case R.id.permission:
                checkPer();
                break;
        }

    }

    private void checkPer() {
        int permissionCheck = ContextCompat.checkSelfPermission(mContext,
                Manifest.permission.CALL_PHONE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            Log.e("","----------------"+permissionCheck);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 0);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 0:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    showMessage("000000000000");
                break;
        }
    }
}
