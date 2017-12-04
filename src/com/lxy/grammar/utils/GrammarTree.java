package com.lxy.grammar.utils;

import com.lxy.grammar.Main;
import com.lxy.grammar.errorHandler.SyntaxError;
import com.lxy.grammar.javabean.AtomNode;
import com.lxy.grammar.javabean.BinaryOprationNode;
import com.lxy.grammar.javabean.ExprNode;
import com.lxy.grammar.javabean.InternalNode;
import com.lxy.lexical.Iterface.LexicalInterface;
import com.lxy.lexical.Iterface.LexicalInterfaceImpl;
import com.lxy.lexical.TokenType;
import com.lxy.lexical.bean.Token;

public class GrammarTree {
    /**
     * 构建语法树
     * @param opcode
     * @param objects
     * @return
     */
    public static ExprNode makeExprNode(TokenType opcode,Object ...objects)
    {
        ExprNode exprNode = new ExprNode();
        exprNode.setOpCode(opcode);


        /**
         * 根据记号的类别构造不同的结点
         */
        if(opcode.equals(TokenType.CONST_ID))   //常数结点
        {
            AtomNode atomNode = new AtomNode();

            double value = (double)objects[0];
            atomNode.setCaseConst(value);
            exprNode.setAtomNode(atomNode);
            return exprNode;
        }else if(opcode.equals(TokenType.T))  //参数结点
        {
            AtomNode atomNode = new AtomNode();
            String value = (String)objects[0];
            atomNode.setCaseParam(value);

            exprNode.setAtomNode(atomNode);
            return exprNode;
        }else if(opcode.equals(TokenType.FUNC))
        {
            //第一个参数为函数名，第二个参数为参数结点
            InternalNode internalNode = new InternalNode();
            String funcname = (String)objects[0];
            internalNode.setFuncName(funcname);
            ExprNode atomNode = (ExprNode)objects[1];
            internalNode.setChild(atomNode);
            exprNode.setInternalNode(internalNode);
            return exprNode;
        }else{
            //二元运算结点,第一个为左孩子，第二个为右孩子
            BinaryOprationNode binaryOprationNode = new BinaryOprationNode();
            ExprNode exprNode1  = (ExprNode) objects[0];
            ExprNode exprNode2 = (ExprNode)objects[1];
            binaryOprationNode.setLeftChild(exprNode1);
            binaryOprationNode.setRightChild(exprNode2);
            exprNode.setBinaryOprationNode(binaryOprationNode);
            return exprNode;
        }
    }
    /**
     * 辅助子程序
     */
    public static void fetchToken(){    //调用词法分析器的gettoken获取记号

        Main.token = Main.lexicalInterface.getToken();
        if(Main.token.getType().equals(TokenType.ERRORTOKEN))
        {
            syntaxError(1);     //记号类型错误
        }
    }
    public static void matchToken(TokenType tokenType)  //匹配记号
    {
        if(!Main.token.getType().equals(tokenType))
        {
            syntaxError(2);     //记号类型不匹配
        }
        fetchToken();
    }
    public static void syntaxError(int errorType)   //错误输出
    {
        new SyntaxError(errorType).printErrorMsg(errorType);
    }

    /**
     *  先序遍历打印表达式结点
     */
    public static void printSyntaxTree(ExprNode root,int indent)    //indent 表示缩进的大小
    {
        for(int i=0;i<indent;i++){
            System.out.print("\t");
        }
        TokenType currentTokenType = root.getOpCode();
        switch (currentTokenType)
        {
            case PLUS:
                System.out.println("+");
                break;
            case MINUS:
                System.out.println("-");
                break;
            case MUL:
                System.out.println("*");
                break;
            case DIV:
                System.out.println("/");
                break;
            case POWER:
                System.out.println("**");
                break;
            case FUNC:
                System.out.println(root.getInternalNode().getFuncName());
                break;
            case CONST_ID:
                System.out.println(root.getAtomNode().getCaseConst());
                break;
            case T:
                System.out.println("T");
                break;
            default:
                System.out.println("error node !");
                return ;
        }
        if(currentTokenType==TokenType.CONST_ID||currentTokenType==TokenType.T) //叶子结点
        {
            return ;
        }else if(currentTokenType==TokenType.FUNC)
        {
            indent = indent+1;
            ExprNode exprNode = root.getInternalNode().getChild();
            GrammarTree.printSyntaxTree(exprNode,indent);
        }else{
            indent = indent+1;
            //打印两个孩子结点
            ExprNode leftExprNode,rightExprNode;
            leftExprNode = root.getBinaryOprationNode().getLeftChild();
            rightExprNode = root.getBinaryOprationNode().getRightChild();
            GrammarTree.printSyntaxTree(leftExprNode,indent);
            GrammarTree.printSyntaxTree(rightExprNode,indent);
        }
    }
}
