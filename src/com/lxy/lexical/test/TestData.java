package com.lxy.lexical.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import com.lxy.lexical.utils.MathWrapper;

public class TestData {

	@Test
	public void test()
	{
		StringBuffer sb = new StringBuffer("123");
		int len = sb.toString().length();
//		System.out.println(len);
//		sb.deleteCharAt(sb.toString().length()-1);
		sb.delete(0, len);
		System.out.println(sb.toString());
	}
	@Test
	public void testReg()
	{
//		String pattern = "[0-9a-zA-Z]";
//		//创建Pattern对象
//		Pattern p = Pattern.compile(pattern);
//		
//		//创建Matcher 对象
//		Matcher m = p.matcher("@");
//		System.out.println(m.find());
//		System.out.println(Utils.isNumberOrAlpha('a'));
		String str = null;
	}
	@Test
	public void testBufferReader() throws IOException
	{
		char[] ch = new char[1];
		int i=0;
		BufferedReader br = new BufferedReader(new FileReader(new File("conf/test.txt")));
		StringBuffer sb = new StringBuffer();
		while(i<=3)
		{
			br.mark(1);
			br.read(ch);
			sb.append(ch);
			br.reset();
			System.out.println(ch);
			i++;
		}
	}
	@Test
	public void testReflect() throws Exception
	{
		MathWrapper mathWrapper = new MathWrapper();
		Class<?> clazz = MathWrapper.class;
		Method[] methods = clazz.getDeclaredMethods();
		for(Method m: methods)
		{
			System.out.println(m);
		}
		Method method = clazz.getDeclaredMethod("sin", double.class);
		System.out.println(method.invoke(mathWrapper, Math.PI));
	}
}
