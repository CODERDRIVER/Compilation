package com.lxy.lexical.utils;

public class MathWrapper {
	
	/**
	 * ���������Ǿ�̬������Ҳ������ʵ������
	 * ����Ǿ�̬�����ڵ��õ�ʱ�����Method.invoke(null,parameter)
	 * ������Ǿ�̬�������ڵ��õ�ʱ�����Method.invoke(new Object,parameter);
	 */
	public MathWrapper(){
		
	}
	/**
	 * ���Һ���
	 * @param a
	 * @return
	 */
	public  static double sin(double a)
	{
		return Math.sin(a);
	}
	/**
	 * ���Һ���
	 * @param a
	 * @return
	 */
	public static double cos(double a)
	{
		return Math.cos(a);
	}
	
	/**
	 * ���к���
	 * @param a
	 * @return
	 */
	
	public static double tan(double a)
	{
		return Math.tan(a);
	}
	
}
