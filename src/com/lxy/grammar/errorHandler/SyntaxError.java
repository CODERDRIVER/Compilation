package com.lxy.grammar.errorHandler;

import com.lxy.grammar.Main;
import com.lxy.lexical.utils.Utils;

public class SyntaxError {

    private int errorType;  //错误类型

    //提供有参构造
    public SyntaxError(int errorType)
    {
        this.errorType = errorType;
    }

    public void printErrorMsg(int errorType)
    {
        switch (errorType)
        {
            case 1:
                System.out.println("lineNum: "+ Utils.getLineNum()+" the token type error"+ Main.token.getLexeme());       //记号类型错误
                throw new RuntimeException("the token type error");
            case 2:
                System.out.println("lineNum: "+Utils.getLineNum()+"记号类型不匹配"+ Main.token.getLexeme());      //记号类型不匹配
                return ;
            default:
                break;
        }
    }
}
