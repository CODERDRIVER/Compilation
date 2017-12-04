package com.lxy.lexical.bean;

import com.lxy.lexical.TokenType;

/**
 * �Ǻ���
 * @author lxy
 *
 */
public class Token {

	private TokenType type;	//�Ǻ�����
	private String lexeme;	//ԭʼ������ַ���
	private double value;	//����Ǻ��ǳ������ǳ�����ֵ
	private String functionName;	//����Ǻ��Ǻ��������Ǻ��������� 
	
	//�չ���
	public Token()
	{
		
	}
	//���캯��
	public Token(TokenType type, String lexeme, double value, String functionName) {
		super();
		this.type = type;
		this.lexeme = lexeme;
		this.value = value;
		this.functionName = functionName;
	}
	/**
	 * @return the type
	 */
	public TokenType getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(TokenType type) {
		this.type = type;
	}
	/**
	 * @return the lexeme
	 */
	public String getLexeme() {
		return lexeme;
	}
	/**
	 * @param lexeme the lexeme to set
	 */
	public void setLexeme(String lexeme) {
		this.lexeme = lexeme;
	}
	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}
	/**
	 * @return the functionName
	 */
	public String getFunctionName() {
		return functionName;
	}
	/**
	 * @param functionName the functionName to set
	 */
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	@Override
	public String toString() {
		return "<"+type.name()+"	"+lexeme+"	"+value+"	"+functionName+">";
	}
}
