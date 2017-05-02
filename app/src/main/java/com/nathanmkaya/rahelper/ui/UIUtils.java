package com.nathanmkaya.rahelper.ui;

import android.content.Context;
import android.support.annotation.MenuRes;
import android.support.v7.widget.PopupMenu;
import android.view.View;

/**
 * Created by nathan on 4/16/17.
 */

public class UIUtils {
    public static void showMenu(Context context, View view, @MenuRes int layout, PopupMenu.OnMenuItemClickListener listener) {
        PopupMenu popupMenu = new PopupMenu(context, view);
        popupMenu.inflate(layout);
        popupMenu.setOnMenuItemClickListener(listener);
        popupMenu.show();
    }
}
