package com.devil.shapeutil.test;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.devil.shapeutil.DddShapeUtils;
import com.devil.shapeutil.shape.DevilShape;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Context mContext = this;
        //圆形
        TextView tv_oval_solid = findViewById(R.id.tv_oval_solid);
        DddShapeUtils.shape(mContext, DevilShape.OVAL).solid(R.color.colorAccent).into(tv_oval_solid);
        TextView tv_oval_line = findViewById(R.id.tv_oval_line);
        DddShapeUtils.shape(mContext, DevilShape.OVAL).solid(R.color.colorAccent).line(1, R.color.colorPrimary).into(tv_oval_line);
        TextView tv_oval_dash_line = findViewById(R.id.tv_oval_dash_line);
        DddShapeUtils.shape(mContext, DevilShape.OVAL).solid(R.color.colorAccent).dashLine(1, R.color.colorPrimary, 5, 5).into(tv_oval_dash_line);
        //矩形
        TextView tv_rect_solid_radius = findViewById(R.id.tv_rect_solid_radius);
        DddShapeUtils.shape(mContext, DevilShape.RECTANGLE).solid(R.color.colorAccent).radius(5).into(tv_rect_solid_radius);
        TextView tv_rect_line_radius = findViewById(R.id.tv_rect_line_radius);
        DddShapeUtils.shape(mContext, DevilShape.RECTANGLE).solid(R.color.colorAccent).line(1, R.color.colorPrimary).radius(5).into(tv_rect_line_radius);
        TextView tv_rect_dash_line_radius = findViewById(R.id.tv_rect_dash_line_radius);
        DddShapeUtils.shape(mContext, DevilShape.RECTANGLE).solid(R.color.colorAccent).dashLine(1, R.color.colorPrimary, 5, 5).radius(5).into(tv_rect_dash_line_radius);
        //圆角（常用）
        TextView tv_rect_solid = findViewById(R.id.tv_rect_solid);
        DddShapeUtils.shape(mContext, DevilShape.RECTANGLE).solid(R.color.colorAccent).radius(999).into(tv_rect_solid);
        TextView tv_rect_line = findViewById(R.id.tv_rect_line);
        DddShapeUtils.shape(mContext, DevilShape.RECTANGLE).line(1, R.color.colorAccent).radius(999).into(tv_rect_line);
        //触摸反馈
        Button btn_selector_background = findViewById(R.id.btn_selector_background);
        DddShapeUtils.selectorBackground(
                DddShapeUtils.shape(mContext, DevilShape.RECTANGLE).solid(R.color.colorPrimary).radius(999).build(),
                DddShapeUtils.shape(mContext, DevilShape.RECTANGLE).solid(R.color.colorAccent).radius(999).build())
                .into(btn_selector_background);
        Button btn_selector_background_color = findViewById(R.id.btn_selector_background_color);
        DddShapeUtils.selectorBackground(
                DddShapeUtils.shape(mContext, DevilShape.RECTANGLE).solid(R.color.colorPrimary).radius(999).build(),
                DddShapeUtils.shape(mContext, DevilShape.RECTANGLE).solid(R.color.colorAccent).radius(999).build())
                .selectorColor("#ffffff", "#000000")
                .into(btn_selector_background_color);
        //圆角
        TextView tv_rect_top_radius = findViewById(R.id.tv_rect_top_radius);
        DddShapeUtils.shape(mContext, DevilShape.RECTANGLE).solid(R.color.colorAccent).tlRadius(10).trRadius(10).into(tv_rect_top_radius);
        TextView tv_rect_bottom_radius = findViewById(R.id.tv_rect_bottom_radius);
        DddShapeUtils.shape(mContext, DevilShape.RECTANGLE).solid(R.color.colorAccent).blRadius(10).brRadius(10).into(tv_rect_bottom_radius);
        TextView tv_rect_diagonal1 = findViewById(R.id.tv_rect_diagonal1);
        DddShapeUtils.shape(mContext, DevilShape.RECTANGLE).solid(R.color.colorAccent).tlRadius(10).brRadius(10).into(tv_rect_diagonal1);
        TextView tv_rect_diagonal2 = findViewById(R.id.tv_rect_diagonal2);
        DddShapeUtils.shape(mContext, DevilShape.RECTANGLE).solid(R.color.colorAccent).trRadius(10).blRadius(10).into(tv_rect_diagonal2);
        TextView tv_rect_tl_radius = findViewById(R.id.tv_rect_tl_radius);
        DddShapeUtils.shape(mContext, DevilShape.RECTANGLE).solid(R.color.colorAccent).tlRadius(10).into(tv_rect_tl_radius);
        TextView tv_rect_tr_radius = findViewById(R.id.tv_rect_tr_radius);
        DddShapeUtils.shape(mContext, DevilShape.RECTANGLE).solid(R.color.colorAccent).trRadius(10).into(tv_rect_tr_radius);
        TextView tv_rect_bl_radius = findViewById(R.id.tv_rect_bl_radius);
        DddShapeUtils.shape(mContext, DevilShape.RECTANGLE).solid(R.color.colorAccent).blRadius(10).into(tv_rect_bl_radius);
        TextView tv_rect_br_radius = findViewById(R.id.tv_rect_br_radius);
        DddShapeUtils.shape(mContext, DevilShape.RECTANGLE).solid(R.color.colorAccent).brRadius(10).into(tv_rect_br_radius);
        //渐变
        TextView tv_gradient_linear_tb = findViewById(R.id.tv_gradient_linear_tb);
        DddShapeUtils.shape(mContext, DevilShape.RECTANGLE)
                .gradientLinear(DevilShape.TOP_BOTTOM, R.color.colorAccent, R.color.colorPrimary)
                .into(tv_gradient_linear_tb);
        TextView tv_gradient_linear_bt = findViewById(R.id.tv_gradient_linear_bt);
        DddShapeUtils.shape(mContext, DevilShape.RECTANGLE)
                .gradientLinear(DevilShape.BOTTOM_TOP, R.color.colorAccent, R.color.colorPrimary)
                .into(tv_gradient_linear_bt);
        TextView tv_gradient_linear_lr = findViewById(R.id.tv_gradient_linear_lr);
        DddShapeUtils.shape(mContext, DevilShape.RECTANGLE)
                .gradientLinear(DevilShape.LEFT_RIGHT, R.color.colorAccent, R.color.colorPrimary)
                .into(tv_gradient_linear_lr);
        TextView tv_gradient_linear_rl = findViewById(R.id.tv_gradient_linear_rl);
        DddShapeUtils.shape(mContext, DevilShape.RECTANGLE)
                .gradientLinear(DevilShape.RIGHT_LEFT, R.color.colorAccent, R.color.colorPrimary)
                .into(tv_gradient_linear_rl);
        TextView tv_gradient_sweep = findViewById(R.id.tv_gradient_sweep);
        DddShapeUtils.shape(mContext, DevilShape.OVAL)
                .gradientSweep(R.color.colorAccent, R.color.colorPrimary).into(tv_gradient_sweep);
        TextView tv_gradient_radial = findViewById(R.id.tv_gradient_radial);
        DddShapeUtils.shape(mContext, DevilShape.OVAL)
                .gradientRadial(30, R.color.colorAccent, R.color.colorPrimary).into(tv_gradient_radial);


    }
}
