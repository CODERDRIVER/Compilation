package com.lxy.grammar.javabean;

/**
 * 原子表达式
 */
public class AtomNode {
    public double caseConst;    //常数
    public String caseParam;    //函数参数

    public double getCaseConst() {
        return caseConst;
    }

    public void setCaseConst(double caseConst) {
        this.caseConst = caseConst;
    }

    public String getCaseParam() {
        return caseParam;
    }

    public void setCaseParam(String caseParam) {
        this.caseParam = caseParam;
    }
}
