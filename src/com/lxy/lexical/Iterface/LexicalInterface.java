package com.lxy.lexical.Iterface;

import com.lxy.lexical.bean.Token;

public interface LexicalInterface {

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
}
