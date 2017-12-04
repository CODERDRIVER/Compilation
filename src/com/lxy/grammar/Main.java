package com.lxy.grammar;

import com.lxy.grammar.grammarInterface.GrammarInterface;
import com.lxy.grammar.grammarInterfaceImpl.GrammarInterfaceImpl;
import com.lxy.lexical.Iterface.LexicalInterface;
import com.lxy.lexical.Iterface.LexicalInterfaceImpl;
import com.lxy.lexical.bean.Token;

/**
 * 语法分析的入口函数
 */
public class Main {

    public static Token token;
    //词法分析器的接口
    public static LexicalInterface lexicalInterface = new LexicalInterfaceImpl();
    //语法分析器的接口
    public GrammarInterface grammarInterface = new GrammarInterfaceImpl();

    public GrammarInterface getGrammarInterface() {
        return grammarInterface;
    }

    public static void main(String[] args) {
        String filename = "conf/test.txt";
        new Main().getGrammarInterface().parser(filename);
    }
}
