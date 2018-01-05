package com.bingo.king;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.bingo.lib.dialog.IDialogConfirm;
import com.bingo.lib.dialog.IDialogMenu;
import com.bingo.lib.dialog.impl.DialogBase;
import com.bingo.lib.dialog.impl.DialogConfirm;
import com.bingo.lib.dialog.impl.DialogMenu;
import com.bingo.lib.dialog.impl.DialogProgress;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickOpenDialogConfirm(View view)
    {
        DialogConfirm dialog = new DialogConfirm(this);
        dialog.setTextTitle("title")
                .setTextContent("content")
                .setTextCancel("cancel")
                .setTextConfirm("confirm")
                .setCallback(new IDialogConfirm.Callback()
                {
                    @Override
                    public void onClickCancel(View v, DialogBase dialog)
                    {
                        Toast.makeText(getApplicationContext(), "onClickCancel", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onClickConfirm(View v, DialogBase dialog)
                    {
                        Toast.makeText(getApplicationContext(), "onClickConfirm", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    public void onClickOpenDialogCustomConfirm(View view)
    {
        CustomDialog dialog = new CustomDialog(this);
        dialog.show();
    }

    public void onClickOpenDialogMenu(View view)
    {
        DialogMenu dialog = new DialogMenu(this);
        dialog.setTextTitle("请选择");
        dialog.setItems("LEWLY", "koukouz", "zhady", "NAPZ", "shNz", "heL^_x")
                .setCallback(new IDialogMenu.Callback()
                {
                    @Override
                    public void onClickCancel(View v, DialogBase dialog)
                    {
                        Toast.makeText(getApplicationContext(), "onClickCancel", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onClickItem(View v, int index, DialogBase dialog)
                    {
                        Toast.makeText(getApplicationContext(), "onClickItem:" + index, Toast.LENGTH_SHORT).show();
                    }
                }).showBottom();
    }

    public void onClickOpenDialogProgress(View view)
    {
        DialogProgress dialog = new DialogProgress(this);

        dialog.setCanceledOnTouchOutside(true);
        dialog.setTextMsg("加载中...").show();
    }
}
