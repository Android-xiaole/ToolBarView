package org.le.toolbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.le.toolbar.interfaces.OnToolBarViewListener;
import org.le.toolbar.interfaces.ToolBarFactory;

/**
 * Created by le on 2018/2/7.
 */

public class ToolBarView extends FrameLayout implements ToolBarFactory,View.OnClickListener{

    private Context context;

//    private int height;//toolbar的高度
    private int backgColor;//toolbar的背景色
    private String title = "title";//标题内容
    private int titleSize;//标题字体大小
    private int titleColor;//标题字体颜色
    private int leftImgRes;//左边的图片资源
    private int leftImgWid,leftImgHei;//左边的图片尺寸
    private int rightImgRes;//右边的图片资源
    private int rightImgWid,rightImgHei;//右边的图片尺寸
    private String leftText = "返回";//左边的字体内容
    private int leftTextSize;//左边的字体大小
    private int leftTextColor;//左边的字体颜色
    private String rightText = "确定";//右边的字体内容
    private int rightTextSize;//右边的字体大小
    private int rightTextColor;//右边的字体颜色
    private boolean leftImgVisible,leftTextVisible;
    private boolean rightImgVisible,rightTextVisible;

    private OnToolBarViewListener onToolBarViewListener;

    public ToolBarView(Context context) {
        super(context);
        init(context);
    }

    public ToolBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public ToolBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    public void init(Context context){
        this.context = context;
        show();
    }

    /**
     * getDimension和getDimensionPixelOffset的功能类似，
     * 都是获取某个dimen的值，但是如果单位是dp或sp，则需要将其乘以density
     * 如果是px，则不乘。并且getDimension返回float，getDimensionPixelOffset返回int.
     * 而getDimensionPixelSize则不管写的是dp还是sp还是px,都会乘以denstiy.
     * @param context
     * @param attrs
     */
    public void init(Context context,@Nullable AttributeSet attrs){
        this.context = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.toolBarView);
//        height = typedArray.getDimensionPixelOffset(R.styleable.toolBarView__height, dp2px(50));
        backgColor = typedArray.getInt(R.styleable.toolBarView_backgColor, Color.GRAY);
        String title = typedArray.getString(R.styleable.toolBarView_title);
        if (title !=null){
            this.title = title;
        }
        titleSize = px2dp(typedArray.getDimensionPixelOffset(R.styleable.toolBarView_titleSize,30));
        titleColor = typedArray.getInt(R.styleable.toolBarView_titleColor,Color.WHITE);
        leftImgRes = typedArray.getInt(R.styleable.toolBarView_leftImgRes,R.drawable.fanhui);
        leftImgHei = typedArray.getDimensionPixelOffset(R.styleable.toolBarView_leftImgHei,dp2px(28));
        leftImgWid = typedArray.getDimensionPixelOffset(R.styleable.toolBarView_leftImgWid,dp2px(28));
        leftImgVisible = typedArray.getBoolean(R.styleable.toolBarView_leftImgVisible,true);
        rightImgRes = typedArray.getInt(R.styleable.toolBarView_rightImgRes,R.drawable.queding);
        rightImgHei = typedArray.getDimensionPixelOffset(R.styleable.toolBarView_rightImgHei,dp2px(28));
        rightImgWid = typedArray.getDimensionPixelOffset(R.styleable.toolBarView_rightImgWid,dp2px(28));
        rightImgVisible = typedArray.getBoolean(R.styleable.toolBarView_rightImgVisible,true);
        String leftText = typedArray.getString(R.styleable.toolBarView_leftText);
        if (leftText != null){
            this.leftText = leftText;
        }
        leftTextSize = px2dp(typedArray.getDimensionPixelOffset(R.styleable.toolBarView_leftTextSize,30));
        leftTextColor = typedArray.getInt(R.styleable.toolBarView_leftTextColor,Color.WHITE);
        leftTextVisible = typedArray.getBoolean(R.styleable.toolBarView_leftTextVisible,true);
        String rightText = typedArray.getString(R.styleable.toolBarView_rightText);
        if (rightText != null){
            this.rightText = rightText;
        }
        rightTextSize = px2dp(typedArray.getDimensionPixelOffset(R.styleable.toolBarView_rightTextSize,30));
        rightTextColor = typedArray.getInt(R.styleable.toolBarView_rightTextColor,Color.WHITE);
        rightTextVisible = typedArray.getBoolean(R.styleable.toolBarView_rightTextVisible,true);
        show();
    }

//    @Override
//    public ToolBarView setHeight(int height) {
//        this.height = dp2px(height);
//        return this;
//    }

    @Override
    public ToolBarView setBackgColor(int color) {
        this.backgColor = color;
        return this;
    }

    @Override
    public ToolBarView setTitle(String title, int size, int color) {
        this.title = title;
        this.titleSize = size;
        this.titleColor = color;
        return this;
    }

    @Override
    public ToolBarView setLeftImg(int imgRes, int width, int height) {
        this.leftImgRes = imgRes;
        this.leftImgWid = dp2px(width);
        this.leftImgHei = dp2px(height);
        return this;
    }

    @Override
    public ToolBarView setRightImg(int imgRes, int width, int height) {
        this.rightImgRes = imgRes;
        this.rightImgWid = dp2px(width);
        this.rightImgHei = dp2px(height);
        return this;
    }

    @Override
    public ToolBarView setLeftText(String text, int size, int color) {
        this.leftText = text;
        this.leftTextSize = size;
        this.leftTextColor = color;
        return this;
    }

    @Override
    public ToolBarView setRightText(String text, int size, int color) {
        this.rightText = text;
        this.rightTextSize = size;
        this.rightTextColor = color;
        return this;
    }

    @Override
    public ToolBarView setLeftVisible(boolean imgVisible, boolean textVisible) {
        this.leftImgVisible = imgVisible;
        this.leftTextVisible = textVisible;
        return this;
    }

    @Override
    public ToolBarView setRightVisible(boolean imgVisible, boolean textVisible) {
        this.rightImgVisible = imgVisible;
        this.rightTextVisible = textVisible;
        return this;
    }

    @Override
    public ToolBarView setOnToolBarClickListener(OnToolBarViewListener onToolBarViewListener) {
        this.onToolBarViewListener = onToolBarViewListener;
        return this;
    }

    private View v;
    @Override
    public void show() {
        if(v == null){
            v = View.inflate(context,R.layout.toolbar,null);
        }
        LinearLayout lin_left = v.findViewById(R.id.lin_left);
        LinearLayout lin_right = v.findViewById(R.id.lin_right);
        TextView tv_title = v.findViewById(R.id.tv_title);
        ImageView iv_left = v.findViewById(R.id.iv_left);
        TextView tv_left = v.findViewById(R.id.tv_left);
        ImageView iv_right = v.findViewById(R.id.iv_right);
        TextView tv_right = v.findViewById(R.id.tv_right);
        //left view
        LinearLayout.LayoutParams lp_left = new LinearLayout.LayoutParams(leftImgWid,leftImgHei);
        iv_left.setLayoutParams(lp_left);
        iv_left.setImageResource(leftImgRes);
        if (leftImgVisible){
            iv_left.setVisibility(View.VISIBLE);
        }else{
            iv_left.setVisibility(View.GONE);
        }
        tv_left.setText(leftText);
        tv_left.setTextSize(leftTextSize);
        tv_left.setTextColor(leftTextColor);
        if (leftTextVisible){
            tv_left.setVisibility(View.VISIBLE);
        }else{
            tv_left.setVisibility(View.GONE);
        }

        //title view
        tv_title.setText(title);
        tv_title.setTextSize(titleSize);
        tv_title.setTextColor(titleColor);

        //right view
        LinearLayout.LayoutParams lp_right = new LinearLayout.LayoutParams(rightImgWid,rightImgHei);
        iv_right.setLayoutParams(lp_right);
        iv_right.setImageResource(rightImgRes);
        if (rightImgVisible){
            iv_right.setVisibility(View.VISIBLE);
        }else{
            iv_right.setVisibility(View.GONE);
        }
        tv_right.setText(rightText);
        tv_right.setTextSize(rightTextSize);
        tv_right.setTextColor(rightTextColor);
        if (rightTextVisible){
            tv_right.setVisibility(View.VISIBLE);
        }else{
            tv_right.setVisibility(View.GONE);
        }

        setBackgColor(backgColor);
        tv_title.setOnClickListener(this);
        lin_left.setOnClickListener(this);
        lin_right.setOnClickListener(this);
        View childAt = getChildAt(0);
        if (childAt == null){//判断如果没有子View就添加，防止多次调用show()方法重复添加view
            addView(v);
        }
//        invalidate();//重新绘制
    }

    @Override
    public void onClick(View view) {
        if (onToolBarViewListener == null){
            return;
        }
        int i = view.getId();
        if (i == R.id.lin_left) {
            onToolBarViewListener.onToolBarLeftClickListener();

        } else if (i == R.id.tv_title) {
            onToolBarViewListener.onToolBarTitleClickListener((TextView) view);

        } else if (i == R.id.lin_right) {
            onToolBarViewListener.onToolBarRightClickListener();

        }
    }

    public int px2dp(float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public int dp2px(float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
