package com.lxy.lexical;

import com.lxy.lexical.bean.Token;

public interface Function {
	/**
	 * 初始化函数
	 * fileName 为要分析的程序文件名
	 * @param fileName
	 * @return
	 */
	public boolean InitScanner(String fileName);
	/**
	 * 结束函数
	 * 关闭文件
	 */
	public void closeScanner();
	/**
	 *获得一个记号
	 */
	public Token getToken();
	/**
	 * 从源程序中读取一个字符
	 *
	 */
	public char getChar();
	/**
	 * 回退一个字符
	 */
	public void backChar(char ch);
	/**
	 * 将已经识别的字符添加到TokenBuffer中
	 */
	public void addCharTokenString(char ch);
	/**
	 * 清空StringBuffer
	 */
	public void cleanStringBuffer();
	/**
	 * 根据识别出的字符串在符号表中查找响应的记号
	 * 如果找到，则返回该记号，如果错误则返回错误记号
	 */
	public Token judgeKeyToken(String idString);

}
