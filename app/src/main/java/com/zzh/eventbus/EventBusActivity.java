package com.zzh.eventbus;

import android.content.Intent;
import android.os.Message;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zzh.alldemo.R;
import com.zzh.alldemo.base.BaseActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * eventbus3.0.0的简单使用，与eventbus2.4有些区别。使用方法不一样
 */
public class EventBusActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus);
        EventBus.getDefault().register(this);
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
        findViewById(R.id.button10).setOnClickListener(this);
        findViewById(R.id.sticky).setOnClickListener(this);
    }

    @Override
    protected void handlerMessage(Message msg) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button10:
                Intent intent = new Intent();
                intent.setAction("com.zzh.demo");
                EventBus.getDefault().post(intent);
                //POST方法中传入的参数必须和接收的参数类型一直，否则方法是不执行的
                showMessage("----!!!!!!!!!!!");
                break;
            case R.id.sticky:
                Intent intent1 = new Intent();
                intent1.setAction("com.zzh.demo2");
                EventBus.getDefault().postSticky(intent1);
                showMessage("----222222222222");
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /**
     * @param intent
     * @Subscribe(threadMode = ThreadMode.MAIN)<br/>
     * ASYNC
     * BACKGROUND
     * POSTING
     * 以什么模式运行程序
     * 在那个线程中执行，必须要有，否则程序要出现异常<br/>
     * ThreadMode.MAIN：主线程执行
     * <p>
     *     org.greenrobot.eventbus.EventBusException: Subscriber class
     *     com.zzh.eventbus.EventBusActivity and its super classes have no public methods with the
     *     @Subscribe annotation
     * </p>
     * onEventMainThread:参数 Intent，指的是<br/>
     * EventBus.getDefault().post(Intent)/EventBus.getDefault().postSticky(Intent) 里面传入的参数必须是
     * Intent类型的参数，onEventMainThread方法才会执行，否则是不执行的
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(Intent intent) {
        if (intent != null) {
            if ("com.zzh.demo".equalsIgnoreCase(intent.getAction())) {
                Log.e("tag", "--------------" + intent.getAction());
            } else if ("com.zzh.demo2".equalsIgnoreCase(intent.getAction())) {
                Log.e("tag", "------222222--" + intent.getAction());
            }
        }
    }
}
