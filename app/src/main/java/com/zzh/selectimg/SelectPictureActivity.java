package com.zzh.selectimg;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zzh.alldemo.R;
import com.zzh.alldemo.base.BaseActivity;

/***
 * 选择图片
 */
public class SelectPictureActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_picture);
        initView();
        initData();
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

    }

    @Override
    protected void handlerMessage(Message msg) {

    }

    @Override
    public void onClick(View v) {

    }
}
