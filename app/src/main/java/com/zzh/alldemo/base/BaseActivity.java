package com.zzh.alldemo.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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
 * BaseBroadCastReceiver
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected Context mContext;
    private Toast mToast;
    protected BaseHandler mHandler;
    protected BaseReceiver mReceiver;
    protected IntentFilter mFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mHandler = new BaseHandler();
        if (mFilter == null)
            mFilter = new IntentFilter();
        if (mReceiver == null)
            mReceiver = new BaseReceiver();
        initRecceiver();
    }

    /**
     * 添加接收规则
     */
    private void initRecceiver() {
        ///mFilter
        ///mFilter.addAction();
    }

    protected void init(){
        initView();
        initData();
        setViewListener();
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
     * @param msg 接收到的Message
     */
    protected abstract void handlerMessage(Message msg);

    /**
     * 接收广播
     * @param context 上下文
     * @param intent 接收到的数据
     */
    protected void onBroadCastReceiver(Context context, Intent intent){

    }

    public void showMessage(String str) {
        if (mToast == null) {
            mToast = Toast.makeText(mContext, str, Toast.LENGTH_SHORT);
            mToast.setGravity(Gravity.CENTER, 0, 0);
        } else {
            mToast.setText(str);
        }
        mToast.show();
    }

    /**
     * Handler
     */
    private class BaseHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            handlerMessage(msg);
        }
    }

    /**
     * 广播
     */
    private class BaseReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            onBroadCastReceiver(context, intent);
        }
    }

}
