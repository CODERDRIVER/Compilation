package com.lxy.grammar.grammarInterfaceImpl;

import com.lxy.grammar.Main;
import com.lxy.grammar.grammarInterface.GrammarInterface;
import com.lxy.grammar.proxy.RecursiveProgramInterfaceProxy;
import com.lxy.grammar.recursiveProgramInterface.RecursiveProgramInterface;
import com.lxy.grammar.recursiveProgramInterfaceImpl.RecursiveProgramInterfaceImpl;
import com.lxy.grammar.utils.GrammarTree;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class GrammarInterfaceImpl implements GrammarInterface
{
    public static  RecursiveProgramInterface recursiveProgramInterface = new RecursiveProgramInterfaceImpl();
    public static InvocationHandler invocationHandler = new RecursiveProgramInterfaceProxy(recursiveProgramInterface);
    public static RecursiveProgramInterface recursiveProgramInterfaceProxy = (RecursiveProgramInterface) Proxy.newProxyInstance(recursiveProgramInterface.getClass().getClassLoader(),recursiveProgramInterface.getClass().getInterfaces(),invocationHandler);



    @Override
    public void parser(String filename) {

        System.out.println("enter in parser");
        //初始化词法分析器
        if(!Main.lexicalInterface.InitScanner(filename))
        {
            System.out.println("词法分析器初始化失败");
        }
        GrammarTree.fetchToken();   //得到第一个记号

        recursiveProgramInterface.program();    //开始进行递归下降分析

        Main.lexicalInterface.closeScanner();   //关闭词法分析器
        System.out.println("exit from parser");
    }
}
