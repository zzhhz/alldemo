package com.zzh.alldemo.base;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by zzh on 16-1-23.
 * 封装BaseActivity
 * Handler
 * Toast
 * initView()
 * initData()
 * setViewListener()
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected Context mContext;
    private Toast mToast;
    protected BaseHandler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mHandler = new BaseHandler();
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
     * 设置控件的监听事件
     */
    protected abstract void setViewListener();

    /**
     * 全局设置
     *
     * @param msg
     */
    protected abstract void handlerMessage(Message msg);

    public void showMessage(String str) {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, str, Toast.LENGTH_SHORT);
            mToast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            mToast.setText(str);
        }
        mToast.show();
    }

    private class BaseHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            handlerMessage(msg);
        }
    }

}
