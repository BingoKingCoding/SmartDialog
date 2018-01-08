package com.bingo.lib.dialog.impl;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.bingo.lib.dialog.IDialogConfirm;
import com.bingo.lib.dialog.R;

/**
 * 带标题，内容，确定按钮和取消按钮的窗口
 */
public class DialogConfirm extends DialogBase implements IDialogConfirm
{
    public TextView tv_title;

    public FrameLayout fl_content;
    public TextView tv_content;

    public TextView tv_confirm;
    public TextView tv_cancel;

    private Callback mCallback;

    public DialogConfirm(Activity activity)
    {
        super(activity);
        init();
    }

    private void init()
    {
        setContentView(R.layout.lib_dialog_dialog_confirm);
        tv_title = (TextView) findViewById(R.id.tv_title);

        fl_content = (FrameLayout) findViewById(R.id.fl_content);
        tv_content = (TextView) findViewById(R.id.tv_content);

        tv_confirm = (TextView) findViewById(R.id.tv_confirm);
        tv_cancel = (TextView) findViewById(R.id.tv_cancel);

        tv_confirm.setOnClickListener(this);
        tv_cancel.setOnClickListener(this);
    }

    @Override
    public DialogConfirm setCustomView(int layoutId)
    {
        fl_content.removeAllViews();
        LayoutInflater.from(getContext()).inflate(layoutId, fl_content, true);
        return this;
    }

    @Override
    public DialogConfirm setCustomView(View view)
    {
        fl_content.removeAllViews();
        fl_content.addView(view);
        return this;
    }

    @Override
    public DialogConfirm setCallback(Callback callback)
    {
        mCallback = callback;
        return this;
    }

    @Override
    public DialogConfirm setTextTitle(String text)
    {
        if (TextUtils.isEmpty(text))
        {
            tv_title.setVisibility(View.GONE);
        } else
        {
            tv_title.setVisibility(View.VISIBLE);
            tv_title.setText(text);
        }
        return this;
    }

    public DialogConfirm setTextContent(String text)
    {
        if (TextUtils.isEmpty(text))
        {
            tv_content.setVisibility(View.GONE);
        } else
        {
            tv_content.setVisibility(View.VISIBLE);
            tv_content.setText(text);
        }
        return this;
    }

    @Override
    public DialogConfirm setTextConfirm(String text)
    {
        if (TextUtils.isEmpty(text))
        {
            tv_confirm.setVisibility(View.GONE);
        } else
        {
            tv_confirm.setVisibility(View.VISIBLE);
            tv_confirm.setText(text);
        }
        changeBottomButtonIfNeed();
        return this;
    }

    @Override
    public DialogConfirm setTextCancel(String text)
    {
        if (TextUtils.isEmpty(text))
        {
            tv_cancel.setVisibility(View.GONE);
        } else
        {
            tv_cancel.setVisibility(View.VISIBLE);
            tv_cancel.setText(text);
        }
        changeBottomButtonIfNeed();
        return this;
    }

    @Override
    public DialogConfirm setTextColorTitle(int color)
    {
        tv_title.setTextColor(color);
        return this;
    }

    @Override
    public DialogConfirm setTextColorContent(int color)
    {
        tv_content.setTextColor(color);
        return this;
    }

    @Override
    public DialogConfirm setTextColorConfirm(int color)
    {
        tv_confirm.setTextColor(color);
        return this;
    }

    @Override
    public DialogConfirm setTextColorCancel(int color)
    {
        tv_cancel.setTextColor(color);
        return this;
    }

    @Override
    public void onClick(View v)
    {
        super.onClick(v);
        if (v == tv_confirm)
        {
            if (mCallback != null)
            {
                mCallback.onClickConfirm(v, this);
            }
            dismissAfterClickIfNeed();
        } else if (v == tv_cancel)
        {
            if (mCallback != null)
            {
                mCallback.onClickCancel(v, this);
            }
            dismissAfterClickIfNeed();
        }
    }

    protected void changeBottomButtonIfNeed()
    {
        if (tv_cancel.getVisibility() == View.VISIBLE && tv_confirm.getVisibility() == View.VISIBLE)
        {
            setBackgroundDrawable(tv_cancel, getContext().getResources().getDrawable(R.drawable.lib_dialog_sel_bg_button_bottom_left));
            setBackgroundDrawable(tv_confirm, getContext().getResources().getDrawable(R.drawable.lib_dialog_sel_bg_button_bottom_right));
        } else if (tv_cancel.getVisibility() == View.VISIBLE)
        {
            setBackgroundDrawable(tv_cancel, getContext().getResources().getDrawable(R.drawable.lib_dialog_sel_bg_button_bottom_single));
        } else if (tv_confirm.getVisibility() == View.VISIBLE)
        {
            setBackgroundDrawable(tv_confirm, getContext().getResources().getDrawable(R.drawable.lib_dialog_sel_bg_button_bottom_single));
        }
    }
}
