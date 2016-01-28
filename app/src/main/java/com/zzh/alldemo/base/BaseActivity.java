package com.zzh.alldemo.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
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
 */
public class BaseActivity extends AppCompatActivity implements View.OnClickListener{
    protected Context mContext;
    private Toast mToast;
    private TextView mToastView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    public void show(final String str){
        if (!TextUtils.isEmpty(str)){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (mToastView == null) {
                        mToastView = new TextView(mContext);
                        mToastView.setBackgroundColor(Color.parseColor("#7bfffbf0"));
                    }
                    if (mToast == null){
                        mToast = new Toast(mContext);
                    }
                    mToastView.setText(str);
                    mToast.setView(mToastView);
                    mToast.setGravity(Gravity.CENTER, 0, 0);
                    mToast.show();
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
    }

}
