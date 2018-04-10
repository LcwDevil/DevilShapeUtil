package com.devil.shapeutil.selector;

import android.content.res.ColorStateList;
import android.widget.TextView;

import com.devil.shapeutil.interfaces.IDevilShape;


/**
 * 字体颜色状态选择器（字体颜色）
 */

public class DevilColorSelector implements IDevilShape<ColorStateList, TextView> {
    //触摸颜色
    private int pressedColor;
    //正常颜色
    private int normalColor;

    /**
     * 背景状态选择器（背景颜色）
     *
     * @param pressedColorResId 触摸颜色 例：R.color.colorPrimary
     * @param normalColorResId  正常颜色 例：R.color.colorPrimary
     * @return DrawableSelector
     */
    public DevilColorSelector selectorColor(int pressedColorResId, int normalColorResId) {
        this.pressedColor = pressedColorResId;
        this.normalColor = normalColorResId;
        return this;
    }


    @Override
    public void into(TextView textView) {
        textView.setTextColor(createColorSelector());
    }

    @Override
    public ColorStateList build() {
        return createColorSelector();
    }

    /**
     * 创建触摸颜色变化
     *
     * @return ColorStateList
     */
    private ColorStateList createColorSelector() {
        int[] colors = new int[]{pressedColor, normalColor};
        int[][] states = new int[2][];
        states[0] = new int[]{android.R.attr.state_pressed};
        states[1] = new int[]{};
        return new ColorStateList(states, colors);
    }
}
