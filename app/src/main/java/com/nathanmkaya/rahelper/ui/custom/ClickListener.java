package com.nathanmkaya.rahelper.ui.custom;

import android.view.View;

/**
 * Created by nathan on 4/4/17.
 */

public interface ClickListener {
    void onItemClick(View view, int position);

    void onItemLongClick(View view, int position);
}
