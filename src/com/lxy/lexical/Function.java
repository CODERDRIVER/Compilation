package com.lxy.lexical;

import com.lxy.lexical.bean.Token;

public interface Function {
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
	public char getChar();
	/**
	 * ����һ���ַ�
	 */
	public void backChar(char ch);
	/**
	 * ���Ѿ�ʶ����ַ���ӵ�TokenBuffer��
	 */
	public void addCharTokenString(char ch);
	/**
	 * ���StringBuffer
	 */
	public void cleanStringBuffer();
	/**
	 * ����ʶ������ַ����ڷ��ű��в�����Ӧ�ļǺ�
	 * ����ҵ����򷵻ظüǺţ���������򷵻ش���Ǻ�
	 */
	public Token judgeKeyToken(String idString);

}
