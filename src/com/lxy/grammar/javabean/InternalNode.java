package com.lxy.grammar.javabean;

/**
 * 内部结点
 */
public class InternalNode {
    public ExprNode child;  //唯一的孩子
    public String funcName; //函数名字

    public ExprNode getChild() {
        return child;
    }

    public void setChild(ExprNode child) {
        this.child = child;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }
}
