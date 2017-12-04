package com.lxy.grammar.javabean;

import com.lxy.lexical.TokenType;

/**
 * 语法分析节点
 */

public class ExprNode {

    //记号类型
    private TokenType OpCode;
    /**
     * 根据记号的类型可以把节点分为三类：
     *     1. 叶节点 原子表达式
     *    2. 两个孩子的内部节点   用于存放二元运算
     *   3. 一个孩子的内部节点   用于存放函数调用入sin(t)等构成的表达式
     */
    public AtomNode atomNode;   //原子节点
    public BinaryOprationNode binaryOprationNode;   //二元运算节点
    public InternalNode internalNode;   //内部节点

    public TokenType getOpCode() {
        return OpCode;
    }

    public void setOpCode(TokenType opCode) {
        OpCode = opCode;
    }

    public AtomNode getAtomNode() {
        return atomNode;
    }

    public void setAtomNode(AtomNode atomNode) {
        this.atomNode = atomNode;
    }

    public BinaryOprationNode getBinaryOprationNode() {
        return binaryOprationNode;
    }

    public void setBinaryOprationNode(BinaryOprationNode binaryOprationNode) {
        this.binaryOprationNode = binaryOprationNode;
    }

    public InternalNode getInternalNode() {
        return internalNode;
    }

    public void setInternalNode(InternalNode internalNode) {
        this.internalNode = internalNode;
    }
}
