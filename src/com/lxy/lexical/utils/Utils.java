package com.lxy.lexical.utils;

import com.lxy.lexical.Main;

import java.util.regex.Pattern;

public class Utils {
	
	public static boolean isAlpha(char ch)
	{
		if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z'))
		{
			return true;
		}else{
			return false;
		}
	}
	public static boolean isDigit(char ch)
	{
		if(ch>='0'&&ch<='9')
		{
			return true;
		}else{
			return false;
		}
	}
	//判断是否是空格或者换行
	public static boolean isSpace(char ch)
	{
		if(ch!=' '&&ch!='\n'&&ch!='\r')
		{
			return false;
		}else{
			return true;
		}
	}
	public static boolean isNumberOrAlpha(char ch)
	{
		String pattern = "[0-9a-zA-Z]";
		return Pattern.matches(pattern, ""+ch);
	}
	public static  int getLineNum()
	{
		return Main.lineNum;
	}
}
