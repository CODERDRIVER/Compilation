package com.lxy.Semantic.utils;

import com.lxy.Semantic.Main;

public class SetValueUtil {
    //设置初始值
    public static  void setOrigin(double x,double y)
    {
        Main.origin_x = x;
        Main.origin_y = y;
    }

    //设置旋转角度
    public static  void setRot(double rot)
    {
        Main.rot_angle = rot;
    }
    public static  void setScale(double xScale,double yScale)
    {
        Main.scale_x = xScale;
        Main.scale_y = yScale;
    }
}
