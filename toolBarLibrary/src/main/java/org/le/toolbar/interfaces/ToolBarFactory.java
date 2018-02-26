package org.le.toolbar.interfaces;

import android.support.annotation.ColorInt;

import org.le.toolbar.ToolBarView;

/**
 * Created by le on 2018/2/8.
 */

public interface ToolBarFactory {

    /**
     * 设置toolbar的高度
     * @param height
     */
//    ToolBarView setHeight(int height);

    /**
     * 设置toolbar的背景颜色
     * @param color
     */
    ToolBarView setBackgColor(@ColorInt int color);

    /**
     * 设置标题文字及字体样式
     * @param title
     * @param size
     * @param color
     */
    ToolBarView setTitle(String title,int size,@ColorInt int color);

    /**
     * 设置左边图片的信息
     * @param imgRes
     * @param width
     * @param height
     */
    ToolBarView setLeftImg(int imgRes,int width,int height);

    /**
     * 设置右边图片的信息
     * @param imgRes
     * @param width
     * @param height
     */
    ToolBarView setRightImg(int imgRes,int width,int height);

    /**
     * 设置左边字体信息
     * @param text
     * @param size
     * @param color
     */
    ToolBarView setLeftText(String text,int size,@ColorInt int color);

    /**
     * 设置右边字体信息
     * @param text
     * @param size
     * @param color
     */
    ToolBarView setRightText(String text,int size,@ColorInt int color);

    /**
     * 设置左边img和text的显示和隐藏
     * @param imgVisible
     * @param textVisible
     * @return
     */
    ToolBarView setLeftVisible(boolean imgVisible,boolean textVisible);

    /**
     * 设置右边img和text的显示和隐藏
     * @param imgVisible
     * @param textVisible
     * @return
     */
    ToolBarView setRightVisible(boolean imgVisible,boolean textVisible);

    /**
     * 设置点击事件
     * @param onToolBarViewListener
     * @return
     */
    ToolBarView setOnToolBarClickListener(OnToolBarViewListener onToolBarViewListener);

    /**
     * 重新绘制toolbarview
     */
    void show();
}
