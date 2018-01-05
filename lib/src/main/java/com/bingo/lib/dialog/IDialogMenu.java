/*
 * Copyright (C) 2017 zhengjun, fanwe (http://www.fanwe.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bingo.lib.dialog;

import android.view.View;
import android.widget.BaseAdapter;

import com.bingo.lib.dialog.impl.DialogBase;

import java.util.List;

public interface IDialogMenu
{
    /**
     * 设置标题文字
     *
     * @param text
     * @return
     */
    IDialogMenu setTextTitle(String text);

    /**
     * 设置取消文字
     *
     * @param text
     * @return
     */
    IDialogMenu setTextCancel(String text);

    /**
     * 设置回调
     *
     * @param callback
     * @return
     */
    IDialogMenu setCallback(Callback callback);

    /**
     * 设置列表数据
     *
     * @param objects
     * @return
     */
    IDialogMenu setItems(Object... objects);

    /**
     * 设置列表数据
     *
     * @param listObject
     * @return
     */
    IDialogMenu setItems(List<Object> listObject);

    /**
     * 设置适配器
     *
     * @param adapter
     * @return
     */
    IDialogMenu setAdapter(BaseAdapter adapter);


    interface Callback
    {
        void onClickItem(View v, int index, DialogBase dialog);

        void onClickCancel(View v, DialogBase dialog);
    }
}
