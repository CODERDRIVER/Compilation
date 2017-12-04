package com.lxy.grammar.proxy;

import com.lxy.grammar.recursiveProgramInterface.RecursiveProgramInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 使用动态代理来处理
 * enter  program
 * exit program
 * 这类重复的代码
 *
 * 动态代理必须实现InvocationHandler接口
 */
public class RecursiveProgramInterfaceProxy implements InvocationHandler {
    private Object target;  //代理的对象

    public RecursiveProgramInterfaceProxy()
    {
        super();
    }
    public RecursiveProgramInterfaceProxy(Object target)
    {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if(!method.getName().equalsIgnoreCase("toString")) {
            System.out.println("enter in " + method.getName());
            result = method.invoke(target, args);
            System.out.println("exit from " + method.getName());
            return result;
        }else{
            result = method.invoke(target,args);
        }
        return result;
    }
}
