package com.lxy.lexical.Iterface;

import com.lxy.lexical.bean.Token;

public interface LexicalInterface {

	/**
	 * ��ʼ������
	 * fileName ΪҪ�����ĳ����ļ���
	 * @param fileName
	 * @return
	 */
	public boolean InitScanner(String fileName);
	/**
	 * ��������
	 * �ر��ļ�
	 */
	public void closeScanner();
	/**
	 *���һ���Ǻ�
	 */
	public Token getToken();
	/**
	 * ��Դ�����ж�ȡһ���ַ�
	 *
	 */
}
