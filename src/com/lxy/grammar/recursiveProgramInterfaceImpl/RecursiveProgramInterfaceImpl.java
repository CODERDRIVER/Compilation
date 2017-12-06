package com.lxy.grammar.recursiveProgramInterfaceImpl;

import com.lxy.Semantic.utils.SemanticUtil;
import com.lxy.Semantic.utils.SetValueUtil;
import com.lxy.grammar.Main;
import com.lxy.grammar.errorHandler.SyntaxError;
import com.lxy.grammar.grammarInterfaceImpl.GrammarInterfaceImpl;
import com.lxy.grammar.javabean.AtomNode;
import com.lxy.grammar.javabean.ExprNode;
import com.lxy.grammar.recursiveProgramInterface.RecursiveProgramInterface;
import com.lxy.grammar.utils.GrammarTree;
import com.lxy.lexical.TokenType;
import com.lxy.lexical.bean.Token;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;


public class RecursiveProgramInterfaceImpl implements RecursiveProgramInterface {

    /**
     * Program ----> {Statement SEMICO}
     */
    @Override
    public void program() {

        while(Main.token.getType()!=TokenType.NONTOKEN)
        {
            statement();
            GrammarTree.matchToken(TokenType.SEMICO);
        }
    }

    /**
     * Statement---->OriginStatement | ScaleStatement | RotStatement | ForStatement
     */
    @Override
    public void statement() {

        System.out.println("enter in statement");
        TokenType tokenType = Main.token.getType();
        switch (tokenType)
        {
            case ORIGIN:
                originStatement();
                break;
            case SCALE:
                scaleStatement();
                break;
            case ROT:
                rotStatement();
                break;
            case FOR:
                forStatement();
                break;
            default:
                new SyntaxError(2).printErrorMsg(2);
        }
        System.out.println("exit from statement");
    }

    /**
     * OriginStatement ---> ORIGIN IS L_BRACKET Expression COMMA Expression R_BRACKET
     */
    @Override
    public void originStatement() {
        double x,y;
        System.out.println("enter in originStatement");
        ExprNode xExprNode,yExprNode;
        GrammarTree.matchToken(TokenType.ORIGIN);
        GrammarTree.matchToken(TokenType.IS);
        GrammarTree.matchToken(TokenType.L_BRACKET);
        xExprNode = expression();
        //获得初始的x坐标值
        x= SemanticUtil.getExprValue(xExprNode);
        GrammarTree.printSyntaxTree(xExprNode,1);
        GrammarTree.matchToken(TokenType.COMMA);
        yExprNode = expression();
        //获得初始的y坐标值
        y = SemanticUtil.getExprValue(yExprNode);
        GrammarTree.printSyntaxTree(yExprNode,1);
        GrammarTree.matchToken(TokenType.R_BRACKET);
        //设置x,y的值
        SetValueUtil.setOrigin(x,y);
        System.out.println("exit from originStatement");
    }

    /**
     * RotStatement ----> ROT IS Expression
     */
    @Override
    public void rotStatement() {
        double rot;
        System.out.println("enter in rotStatement");
        ExprNode exprNode;
        GrammarTree.matchToken(TokenType.ROT);
        GrammarTree.matchToken(TokenType.IS);
        exprNode = expression();
        rot = SemanticUtil.getExprValue(exprNode);
        GrammarTree.printSyntaxTree(exprNode,1);
        SetValueUtil.setRot(rot);
        System.out.println("exit from rotStatement");
    }

    /**
     * ScaleStatement ---> SCALE IS  L_BRACKET Expression COMMA Expression R_BRACKET
     */
    @Override
    public void scaleStatement() {
        double xSacle,yScale;
        System.out.println("enter in scaleStatement");
        ExprNode xExprNode,yExprNode;
        GrammarTree.matchToken(TokenType.SCALE);
        GrammarTree.matchToken(TokenType.IS);
        GrammarTree.matchToken(TokenType.L_BRACKET);
        xExprNode = expression();
        xSacle = SemanticUtil.getExprValue(xExprNode);
        GrammarTree.printSyntaxTree(xExprNode,1);
        GrammarTree.matchToken(TokenType.COMMA);
        yExprNode = expression();
        yScale = SemanticUtil.getExprValue(yExprNode);
        GrammarTree.printSyntaxTree(yExprNode,1);
        GrammarTree.matchToken(TokenType.R_BRACKET);
        SetValueUtil.setScale(xSacle,yScale);
        System.out.println("exit from scaleStatment");
    }

    /**
     * FORSTATEMENT 的递归下降子程序
     * FOR T FROM Expression TO Expression STEP Expression
     *  DRAW L_BRACKET Expression COMMA R_BRACKET
     */
    @Override
    public void forStatement() {
        double start,end,step;
        System.out.println("enter in forStatement");
        ExprNode startExprNode,endExprNode,stepExprNode,xExprNode,yExprNode;

        GrammarTree.matchToken(TokenType.FOR);
        System.out.println("matchtoken FOR");
        GrammarTree.matchToken(TokenType.T);
        System.out.println("mathtoken T");
        GrammarTree.matchToken(TokenType.FROM);
        System.out.println("matchtoken FROM");
        //起点表达式的语法树
        startExprNode = expression();
        start = SemanticUtil.getExprValue(startExprNode);
        GrammarTree.printSyntaxTree(startExprNode,1);
        GrammarTree.matchToken(TokenType.TO);
        System.out.println("matchtoken TO");
        //终点表达式的语法树
        endExprNode = expression();
        end = SemanticUtil.getExprValue(endExprNode);
        GrammarTree.printSyntaxTree(endExprNode,1);
        GrammarTree.matchToken(TokenType.STEP);
        System.out.println("matchtoken STEP");
        //步长表达式的语法树
        stepExprNode = expression();
        step = SemanticUtil.getExprValue(stepExprNode);
        GrammarTree.printSyntaxTree(stepExprNode,1);
        GrammarTree.matchToken(TokenType.DRAW);
        System.out.println("matchtoken DRAW");
        GrammarTree.matchToken(TokenType.L_BRACKET);
        System.out.println("matchtoken L_BRACKET");
        //横坐标表达式的语法树
        xExprNode = expression();
        GrammarTree.printSyntaxTree(xExprNode,1);
        GrammarTree.matchToken(TokenType.COMMA);
        System.out.println("matchtoken COMMA");
        //纵坐标表达式的语法树
        yExprNode = expression();
        GrammarTree.printSyntaxTree(yExprNode,1);
        GrammarTree.matchToken(TokenType.R_BRACKET);
        System.out.println("matchtoken R_BRACKET");
        SemanticUtil.drawLoop(start,end,step,xExprNode,yExprNode);
        System.out.println("exit from forStatement");
    }

    /**
     * Expression ------> Term{(Plus|MINUS)TERM}
     * @return
     */

    @Override
    public ExprNode expression() {
        System.out.println("enter in expression");
        ExprNode leftExprNode,rightExprNode;    //左右子树的节点
        TokenType currentTokenType; //当前记号类型
        leftExprNode = term();
        while(Main.token.getType()==TokenType.MINUS||Main.token.getType()==TokenType.PLUS)
        {
            currentTokenType = Main.token.getType();
            GrammarTree.matchToken(currentTokenType);
            rightExprNode = term();
            leftExprNode = GrammarTree.makeExprNode(currentTokenType,leftExprNode,rightExprNode);
        }
        System.out.println("exit from expression");
        return leftExprNode;
    }

    /**
     * Term --------> Factor{(MUL|DIV)Factor}
     * @return
     */
    @Override
    public ExprNode term() {
//        System.out.println("enter in term");
        ExprNode leftExprNode,rightExprNode;
        TokenType currTokenType;    //当前结点类型
        leftExprNode = factor();
        while(Main.token.getType()==TokenType.MUL||Main.token.getType()==TokenType.DIV)
        {
            currTokenType = Main.token.getType();
            GrammarTree.matchToken(currTokenType);
            rightExprNode = factor();
            leftExprNode = GrammarTree.makeExprNode(currTokenType,leftExprNode,rightExprNode);
        }
//        System.out.println("exit from term");
        return leftExprNode;
    }

    /**
     * Factor ---> PLUS Factor | MINUS Factor | Component
     * @return
     */

    @Override
    public ExprNode factor() {

        TokenType currentType;  //当前结点类型
        ExprNode leftExprNode,rightExprNode;

        currentType = Main.token.getType();

        if(Main.token.getType()==TokenType.PLUS)    //匹配一元加运算
        {
            GrammarTree.matchToken(currentType);
            rightExprNode = factor();
        }else if(Main.token.getType()==TokenType.MINUS) //匹配一元减
        {
            GrammarTree.matchToken(currentType);
            rightExprNode = factor();
            leftExprNode = new ExprNode();
            AtomNode atomNode = new AtomNode();
            atomNode.setCaseConst(0.0);
            leftExprNode.setOpCode(TokenType.CONST_ID);
            leftExprNode.setAtomNode(atomNode);
            rightExprNode = GrammarTree.makeExprNode(currentType,leftExprNode,rightExprNode);
        }else{
                rightExprNode = component();
        }
        return rightExprNode;
    }

    /**
     * Component ---> Atom POWER Component | Atom
     * @return
     */
    @Override
    public ExprNode component() {
        ExprNode leftExprNode,rightExprNode;
        TokenType currentTokenType;
        leftExprNode = atom();
        if(Main.token.getType()==TokenType.POWER)
        {
            GrammarTree.matchToken(TokenType.POWER);
            currentTokenType = Main.token.getType();
            rightExprNode = component();
            leftExprNode = GrammarTree.makeExprNode(currentTokenType,leftExprNode,rightExprNode);
        }
        return leftExprNode;
    }

    /**
     * Atom ---->CONST_ID
     *
     *          | T
     *          | FUNC L_BRACKET Expression R_BRACKET
     *          | L_BRACKET Expression R_BRACKET
     * @return
     */

    @Override
    public ExprNode atom() {
        ExprNode childExprNode=null,tempExprNode=null;
        Token token = Main.token;
        TokenType currentTokenType = token.getType();
        if(currentTokenType==TokenType.CONST_ID)
        {
            GrammarTree.matchToken(currentTokenType);
            childExprNode = GrammarTree.makeExprNode(currentTokenType,token.getValue());
        }else if(currentTokenType==TokenType.T)
        {
            GrammarTree.matchToken(TokenType.T);
            childExprNode = GrammarTree.makeExprNode(TokenType.T,token.getLexeme());
        }else if(currentTokenType==TokenType.FUNC)
        {
            GrammarTree.matchToken(currentTokenType);
            GrammarTree.matchToken(TokenType.L_BRACKET);
            tempExprNode = expression();
            childExprNode = GrammarTree.makeExprNode(TokenType.FUNC,token.getFunctionName(),tempExprNode);
            GrammarTree.matchToken(TokenType.R_BRACKET);
        }else if(currentTokenType==TokenType.L_BRACKET){
            GrammarTree.matchToken(TokenType.L_BRACKET);
            childExprNode = expression();
            GrammarTree.matchToken(TokenType.R_BRACKET);
        }else{
            new SyntaxError(2).printErrorMsg(2);
        }
        return childExprNode;
    }
}
