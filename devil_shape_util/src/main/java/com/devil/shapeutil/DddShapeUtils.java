package com.devil.shapeutil;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;

import com.devil.shapeutil.selector.DevilColorSelector;
import com.devil.shapeutil.selector.DevilDrawableSelector;
import com.devil.shapeutil.shape.DevilShape;


/**
 * 代码设置Shape、Selector
 */

public class DddShapeUtils {

    /**
     * 设置样式（主要是椭圆和矩形）
     *
     * @return OvalShape
     */
    public static DevilShape shape(Context context, @DevilShape.Shape int shapeModel) {
        return new DevilShape(context, shapeModel);
    }

    /**
     * 背景状态选择器（背景颜色）
     *
     * @param pressedColorResId 触摸颜色 例：R.color.colorPrimary
     * @param normalColorResId  正常颜色 例：R.color.colorPrimary
     * @return DrawableSelector
     */
    public static DevilDrawableSelector selectorBackground(Context context, @ColorRes int pressedColorResId, @ColorRes int normalColorResId) {
        DevilDrawableSelector mDrawableSelector = new DevilDrawableSelector();
        return mDrawableSelector.selectorBackground(new ColorDrawable(context.getResources().getColor(pressedColorResId)), new ColorDrawable(context.getResources().getColor(normalColorResId)));
    }

    /**
     * .
     * 背景状态选择器（背景颜色）
     *
     * @param pressedColor 触摸颜色 例：#ffffff
     * @param normalColor  正常颜色 例：#ffffff
     * @return DrawableSelector
     */
    public static DevilDrawableSelector selectorBackground(String pressedColor, String normalColor) {
        DevilDrawableSelector mDrawableSelector = new DevilDrawableSelector();
        return mDrawableSelector.selectorBackground(new ColorDrawable(Color.parseColor(pressedColor)), new ColorDrawable(Color.parseColor(normalColor)));
    }

    /**
     * .
     * 背景状态选择器（背景Drawable）
     *
     * @param pressedDrawable 触摸颜色 例：Context.getResources.getDrawable(R.drawable/mipmap.xxx)
     * @param normalDrawable  正常颜色 例：Context.getResources.getDrawable(R.drawable/mipmap.xxx)
     * @return DrawableSelector
     */
    public static DevilDrawableSelector selectorBackground(Drawable pressedDrawable, Drawable normalDrawable) {
        DevilDrawableSelector mDrawableSelector = new DevilDrawableSelector();
        return mDrawableSelector.selectorBackground(pressedDrawable, normalDrawable);
    }


    /**
     * 字体颜色颜色器
     *
     * @param pressedColorResId 触摸颜色 例：R.color.colorPrimary
     * @param normalColorResId  正常颜色 例：R.color.colorPrimary
     * @return DrawableSelector
     */
    public static DevilColorSelector selectorColor(Context context, @ColorRes int pressedColorResId, @ColorRes int normalColorResId) {
        DevilColorSelector mColorSelector = new DevilColorSelector();
        return mColorSelector
                .selectorColor(context.getResources().getColor(pressedColorResId), context.getResources().getColor(normalColorResId));
    }


    /**
     * 字体颜色颜色器
     *
     * @param pressedColor 触摸颜色 例：#ffffff
     * @param normalColor  正常颜色 例：#ffffff
     * @return DrawableSelector
     */
    public static DevilColorSelector selectorColor(String pressedColor, String normalColor) {
        DevilColorSelector mColorSelector = new DevilColorSelector();
        return mColorSelector.selectorColor(Color.parseColor(pressedColor), Color.parseColor(normalColor));
    }

}
