package org.fw.library_1;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * author : 进击的巨人
 * e-mail : zhouffan@qq.com
 * date   : 2021/5/22 22:12
 * desc   :
 * version: 1.0
 */
public class CustomView extends View {

    /**
     * 代码直接调用
     * @param context
     */
    public CustomView(Context context) {
        super(context);
    }

    /**
     * xml调用
     * @param context
     * @param attrs  自定义属性
     *               通过<declare-styleable> 为自定义view添加属性
     */
    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        // 解析布局属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomView);
        boolean aBoolean = typedArray.getBoolean(R.styleable.CustomView_layout_simple_attr, false);
        int gravity = typedArray.getInteger(R.styleable.CustomView_android_layout_gravity, 0);
        typedArray.recycle();
    }

    /**
     * 不会自动调用，一般第二个函数调用
     * @param context
     * @param attrs
     * @param defStyleAttr  view style
     */
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * api21之后才使用，不会自动调用，一般第二个函数调用
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public static void main(String[] args) {

        CustomView view = null;
        int left = view.getLeft();  //当前view的左上角与父view的左侧距离
        int right = view.getRight();//当前view的右上角与父view的左侧距离

        MotionEvent event = null;
        float x = event.getX();      //触摸点相对于 该view 的坐标系 坐标
        float rawX = event.getRawX();//触摸点相对于 屏幕默认 的坐标系 坐标
    }


}


