package com.devil.shapeutil.selector;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.ColorRes;
import android.view.View;
import android.widget.TextView;

import com.devil.shapeutil.DddShapeUtils;
import com.devil.shapeutil.interfaces.IDevilShape;


/**
 * 背景状态选择器（颜色背景、图片背景）
 */

public class DevilDrawableSelector implements IDevilShape<Drawable, View> {
    //触摸颜色
    private Drawable mPressedDrawable;
    //正常颜色
    private Drawable mNormalDrawable;
    //是否设置TextView颜色选择器
    private boolean isSelectorColor;
    private ColorStateList mColorStateList;


    /**
     * .
     * 背景状态选择器（背景Drawable）
     *
     * @param pressedDrawable 触摸颜色 例：Context.getResources.getDrawable(R.drawable/mipmap.xxx)
     * @param normalDrawable  正常颜色 例：Context.getResources.getDrawable(R.drawable/mipmap.xxx)
     * @return DrawableSelector
     */
    public DevilDrawableSelector selectorBackground(Drawable pressedDrawable, Drawable normalDrawable) {
        this.mPressedDrawable = pressedDrawable;
        this.mNormalDrawable = normalDrawable;
        return this;
    }

    /**
     * 设置背景选择器同时设置字体颜色颜色器
     *
     * @param pressedColorResId 触摸颜色 例：R.color.colorPrimary
     * @param normalColorResId  正常颜色 例：R.color.colorPrimary
     * @return DrawableSelector
     */
    public DevilDrawableSelector selectorColor(Context context, @ColorRes int pressedColorResId, @ColorRes int normalColorResId) {
        DevilColorSelector mColorSelector = new DevilColorSelector();
        mColorStateList = mColorSelector
                .selectorColor(context.getResources().getColor(pressedColorResId), context.getResources().getColor(normalColorResId))
                .build();
        this.isSelectorColor = true;
        return this;
    }


    /**
     * 设置背景选择器同时设置字体颜色颜色器
     *
     * @param pressedColor 触摸颜色 例：#ffffff
     * @param normalColor  正常颜色 例：#ffffff
     * @return DrawableSelector
     */
    public DevilDrawableSelector selectorColor(String pressedColor, String normalColor) {
        DevilColorSelector mColorSelector = new DevilColorSelector();
        mColorStateList = mColorSelector.selectorColor(Color.parseColor(pressedColor), Color.parseColor(normalColor)).build();
        this.isSelectorColor = true;
        return this;
    }


    @Override
    public void into(View view) {
        view.setBackground(createDrawableSelector());
        if (isSelectorColor) {
            try {
                ((TextView) view).setTextColor(mColorStateList);
            } catch (Exception e) {
                e.printStackTrace();
                throw new ExceptionInInitializerError("设置字体颜色选择器（Selector）请传入TextView（包括Button）！！！");
            }
        }
    }

    /**
     * @return 返回背景Drawable   ps：如果同时设置字体颜色选择器，此处不生效，直接into就行。
     */
    @Override
    public Drawable build() {
        return createDrawableSelector();
    }

    /**
     * 创建触摸颜色变化
     *
     * @return StateListDrawable
     */
    private StateListDrawable createDrawableSelector() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, mPressedDrawable);// 按下显示的图片
        stateListDrawable.addState(new int[]{}, mNormalDrawable);// 抬起显示的图片
        return stateListDrawable;
    }
}
