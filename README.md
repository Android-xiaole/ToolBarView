# ToolBarView

  不墨迹直接看效果
  
![image](https://github.com/Android-xiaole/ToolBarView/blob/master/ToolBarView.gif)

Demo中第一个是默认布局，没添加任何代码

第二个添加了一些自定义属性代码如下：

     toolBarView
                .setTitle("标题",18, Color.BLACK)
                .setLeftVisible(true,false)
                .setRightVisible(true,false)
                .setOnToolBarClickListener(this)
                .show();
                
还有点击事件：
    
    @Override
    public void onToolBarLeftClickListener() {
        toast.setText("点击的左边");
        toast.show();
    }

    @Override
    public void onToolBarTitleClickListener(TextView title) {
        toast.setText("点击的title");
        toast.show();
        title.setText("我被点击了");
    }

    @Override
    public void onToolBarRightClickListener() {
        toast.setText("点击的右边");
        toast.show();
    }
       
这里可以控制很多属性具体见：ToolBarFactory

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
                
                
