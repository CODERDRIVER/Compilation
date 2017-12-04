package com.lxy.grammar.javabean;

/**
 * 二元运算
 */
public class BinaryOprationNode {
    public ExprNode leftChild;  //两个孩子中的左孩子
    public ExprNode rightChild; //两个孩子中的右孩子

    public ExprNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(ExprNode leftChild) {
        this.leftChild = leftChild;
    }

    public ExprNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(ExprNode rightChild) {
        this.rightChild = rightChild;
    }
}
