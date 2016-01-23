package com.zzh.alldemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by zzh on 16-1-23.
 */
public class BaseActivity extends AppCompatActivity implements View.OnClickListener{
    protected Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getApplicationContext();
    }

    @Override
    public void onClick(View v) {

    }
}
