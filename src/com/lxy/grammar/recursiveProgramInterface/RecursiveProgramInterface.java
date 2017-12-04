package com.lxy.grammar.recursiveProgramInterface;

import com.lxy.grammar.javabean.ExprNode;

public interface RecursiveProgramInterface {

    public void program();
    public void statement();
    public void originStatement();
    public void rotStatement();
    public void scaleStatement();
    public void forStatement();

    public ExprNode expression();
    public ExprNode term();
    public ExprNode factor();
    public ExprNode component();
    public ExprNode atom();
}
