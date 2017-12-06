package com.lxy.Semantic;

import com.lxy.grammar.grammarInterface.GrammarInterface;
import com.lxy.grammar.grammarInterfaceImpl.GrammarInterfaceImpl;

import javax.swing.*;

public class Main {

    //分配全局变量
    public static double parameter = 0; //存储参数的值
    public static double origin_x = 0.0,origin_y=0.0;   //初始化x,y坐标
    public static double rot_angle=0.0; //初始化旋转角度
    public static double scale_x=1,scale_y=1;   //初始化比例因子
    //得到一个画图框架
    public static JFrame jFrame = new JFrame();
    //得到自己的面板
    public static SemanticPanel jPanel = new SemanticPanel();

    public static void init()
    {
        //初始化
        jFrame.setBounds(100,100,1000,1000);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(jPanel);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {

        GrammarInterface grammarInterface = new GrammarInterfaceImpl();
        init();
        grammarInterface.parser("conf/test.txt");
    }

}
