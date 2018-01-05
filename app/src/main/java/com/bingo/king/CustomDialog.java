package com.bingo.king;

import android.app.Activity;

import com.bingo.lib.dialog.impl.DialogConfirm;



public class CustomDialog extends DialogConfirm
{
    public CustomDialog(Activity activity)
    {
        super(activity);
        setCustomView(R.layout.dialog_custom);
    }
}
