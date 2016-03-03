package com.zzh.popwindow;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.zzh.alldemo.R;
import com.zzh.alldemo.base.BaseActivity;
import com.zzh.popwindow.position.ToolTip;
import com.zzh.popwindow.position.ToolTipView;

public class PopWindowActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_window);
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

        findViewById(R.id.top_left_button).setOnClickListener(this);
        findViewById(R.id.top_right_button).setOnClickListener(this);
        findViewById(R.id.central_button).setOnClickListener(this);
        findViewById(R.id.bottom_left_button).setOnClickListener(this);
        findViewById(R.id.bottom_right_button).setOnClickListener(this);
        /**
         *
         */
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        findViewById(R.id.button7).setOnClickListener(this);
    }

    @Override
    protected void handlerMessage(Message msg) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.top_left_button:
                showToolTipView(v, Gravity.RIGHT, "Simple tool tip!",
                        ContextCompat.getColor(mContext, R.color.blue));
                break;
            case R.id.top_right_button:
                showToolTipView(v, Gravity.BOTTOM, "It is yet another very simple tool tip!",
                        ContextCompat.getColor(mContext, R.color.green));
                break;
            case R.id.central_button:
                showToolTipView(v, Gravity.END, "It is a very simple tool tip in the center!",
                        ContextCompat.getColor(mContext, R.color.magenta));
                break;
            case R.id.bottom_left_button:
                showToolTipView(v, Gravity.TOP, "Tool tip, once more!",
                        ContextCompat.getColor(mContext, R.color.maroon));
                break;
            case R.id.bottom_right_button:
                showToolTipView(v, Gravity.LEFT, "Magical tool tip!",
                        ContextCompat.getColor(mContext, R.color.navy));
                break;
            case R.id.button1:
            case R.id.button2:
            case R.id.button3:
            case R.id.button4:
            case R.id.button5:
            case R.id.button6:
            case R.id.button7:
            case R.id.button8:
                showToolTipViewWithParent((Button) v, Gravity.BOTTOM);
                break;
        }
    }

    private void showToolTipView(View anchorView, int gravity, CharSequence text, int backgroundColor) {
        showToolTipView(anchorView, gravity, text, backgroundColor, 0L);
    }

    private void showToolTipViewWithParent(final Button anchorView, int gravity) {
        showToolTipView(anchorView, (FrameLayout) findViewById(R.id.tool_tip_view_holder), gravity,
                "Tool tip for " + anchorView.getText(), Color.BLACK, 0L);
    }

    private void showToolTipView(final View anchorView, int gravity, CharSequence text, int backgroundColor, long delay) {
        showToolTipView(anchorView, null, gravity, text, backgroundColor, delay);
    }

    private void showToolTipView(final View anchorView, ViewGroup parentView, int gravity,
                                 CharSequence text, int backgroundColor, long delay) {
        if (anchorView.getTag() != null) {
            ((ToolTipView) anchorView.getTag()).remove();
            anchorView.setTag(null);
            return;
        }

        ToolTip toolTip = createToolTip(text, backgroundColor);
        ToolTipView toolTipView = createToolTipView(toolTip, anchorView, parentView, gravity);
        if (delay > 0L) {
            toolTipView.showDelayed(delay);
        } else {
            toolTipView.show();
        }
        anchorView.setTag(toolTipView);

        toolTipView.setOnToolTipClickedListener(new ToolTipView.OnToolTipClickedListener() {
            @Override
            public void onToolTipClicked(ToolTipView toolTipView) {
                anchorView.setTag(null);
            }
        });
    }

    private ToolTip createToolTip(CharSequence text, int backgroundColor) {
        Resources resources = getResources();
        int padding = resources.getDimensionPixelSize(R.dimen.padding);
        int textSize = resources.getDimensionPixelSize(R.dimen.text_size);
        int radius = resources.getDimensionPixelSize(R.dimen.radius);
        return new ToolTip.Builder()
                .withText(text)
                .withTextColor(Color.WHITE)
                .withTextSize(textSize)
                .withBackgroundColor(backgroundColor)
                .withPadding(padding, padding, padding, padding)
                .withCornerRadius(radius)
                .build();
    }

    private ToolTipView createToolTipView(ToolTip toolTip, View anchorView, ViewGroup parentView, int gravity) {
        return new ToolTipView.Builder(this)
                .withAnchor(anchorView)
                .withParent(parentView)
                .withToolTip(toolTip)
                .withGravity(gravity)
                .build();
    }
}
