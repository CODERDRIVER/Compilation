package com.lxy.Semantic.utils;

import com.lxy.Semantic.Main;
import com.lxy.Semantic.SemanticException.DividedByZeroException;
import com.lxy.grammar.javabean.ExprNode;
import com.lxy.lexical.Function;
import com.lxy.lexical.FunctionaAdapter;
import com.lxy.lexical.TokenType;
import com.lxy.lexical.utils.MathWrapper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SemanticUtil {

    public static MathWrapper mathWrapper = new MathWrapper();
    public static Class<?> clazz = MathWrapper.class;
    public static double x = 0,y=0;
    //根据根节点获得该表达式的结果
    public static double getExprValue(ExprNode root)
    {
        if(root==null)
        {
            return 0.0;
        }
        TokenType tokenType = root.getOpCode();
        switch (tokenType)
        {
            case PLUS:
                return getExprValue(root.getBinaryOprationNode().leftChild)+
                getExprValue(root.getBinaryOprationNode().rightChild);
            case MINUS:
                return getExprValue(root.getBinaryOprationNode().leftChild)-
                        getExprValue(root.getBinaryOprationNode().rightChild);
            case MUL:
                return getExprValue(root.getBinaryOprationNode().rightChild)*getExprValue(
                        root.getBinaryOprationNode().getRightChild()
                );
            case DIV:
                if(getExprValue(root.getBinaryOprationNode().getRightChild())!=0)
                {
                    return getExprValue(root.getBinaryOprationNode().getLeftChild())/getExprValue(
                            root.getBinaryOprationNode().getRightChild()
                    );
                }else{
                        throw new DividedByZeroException("被除数不能为零");
                }
            case POWER:
                return Math.pow(getExprValue(root.getBinaryOprationNode().getLeftChild()),getExprValue(
                        root.getBinaryOprationNode().getRightChild()
                ));
            case FUNC:
                try {
                    Method method = clazz.getDeclaredMethod(root.getInternalNode().getFuncName(),double.class);
                    return (double) method.invoke(mathWrapper,getExprValue(root.getInternalNode().getChild()));
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            case CONST_ID:
                return root.getAtomNode().getCaseConst();
            case T:
                return Main.parameter;
            default:
                    return 0.0;
        }
    }

    //计算点的坐标值(Expression,Expression)
    public static void calcCoordinate(ExprNode xExprNode,ExprNode yExprNode)
    {
        /**
         * 以（0，0）为基准，旋转相应的角度
         */
        x = getExprValue(xExprNode)*Main.scale_x+Main.origin_x;
        y = getExprValue(yExprNode)*Main.scale_y+Main.origin_y;
        double z = Math.sqrt(x*x+y*y);
        double rot = Math.acos(x/z);
        x = z*Math.cos(rot-Main.rot_angle);
        y = z*Math.sin(rot-Main.rot_angle);
    }

    //绘制一个像素点,给出点的横纵坐标
    public static void drawPixel(double x,double y)
    {
        Main.jPanel.display(x,y);
    }
    //循环绘制所有的结点
    public static void drawLoop(double start,double end,double step,ExprNode xExprNode,ExprNode yExprNode)
    {
        double p = Main.parameter;
        for(p=start;p<=end;p+=step)
        {
            Main.parameter = p;
            //计算坐标
            calcCoordinate(xExprNode,yExprNode);
            drawPixel(x,y);
        }
    }


}
