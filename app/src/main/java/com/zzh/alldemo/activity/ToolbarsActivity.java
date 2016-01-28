package com.zzh.alldemo.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import com.zzh.alldemo.R;
import com.zzh.alldemo.base.BaseActivity;

public class ToolbarsActivity extends BaseActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbars);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Toolbar");
        setSupportActionBar(toolbar);
    }
}
