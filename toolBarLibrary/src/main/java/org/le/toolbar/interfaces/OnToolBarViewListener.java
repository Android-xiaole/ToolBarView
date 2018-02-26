package org.le.toolbar.interfaces;

import android.widget.TextView;

/**
 * Created by le on 2018/2/24.
 */

public interface OnToolBarViewListener {

    void onToolBarLeftClickListener();
    void onToolBarTitleClickListener(TextView title);
    void onToolBarRightClickListener();
}
