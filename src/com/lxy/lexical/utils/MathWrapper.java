package com.lxy.lexical.utils;

public class MathWrapper {
	
	/**
	 * 方法可以是静态方法，也可以是实例方法
	 * 如果是静态方法在调用的时候可以Method.invoke(null,parameter)
	 * 如果不是静态方法，在调用的时候可以Method.invoke(new Object,parameter);
	 */
	public MathWrapper(){
		
	}
	/**
	 * 正弦函数
	 * @param a
	 * @return
	 */
	public  static double sin(double a)
	{
		return Math.sin(a);
	}
	/**
	 * 余弦函数
	 * @param a
	 * @return
	 */
	public static double cos(double a)
	{
		return Math.cos(a);
	}
	
	/**
	 * 正切函数
	 * @param a
	 * @return
	 */
	
	public static double tan(double a)
	{
		return Math.tan(a);
	}
	
}
