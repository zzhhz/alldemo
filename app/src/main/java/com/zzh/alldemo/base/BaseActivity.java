package com.zzh.alldemo.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zzh.alldemo.R;

/**
 * Created by zzh on 16-1-23.
 * 封装BaseActivity
 * Handler
 * Toast
 * initView()
 * initData()
 * setViewListener()
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener{
    protected Context mContext;
    private Toast mToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    /**
     * 初始化控件
     */
    protected abstract void initView();

    /**
     * 初始化数据
     */
    protected abstract void initData();

    /**
     * 全局设置
     * @param msg
     */
    protected abstract void handlerMessage(Message msg);

    /**
     * 设置控件的监听事件
     */
    protected abstract void setViewListener();

    public void showMessage(String str){
        if (mToast == null) {
            mToast = Toast.makeText(mContext, str, Toast.LENGTH_SHORT);
            mToast.setGravity(Gravity.CENTER, 0 , 0);
        }
        mToast.show();
    }

    @Override
    public void onClick(View v){

    }

    private class BaseHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            handlerMessage(msg);
        }
    }

}
