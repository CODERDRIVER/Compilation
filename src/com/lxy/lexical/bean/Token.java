package com.lxy.lexical.bean;

import com.lxy.lexical.TokenType;

/**
 * 记号类
 * @author lxy
 *
 */
public class Token {

	private TokenType type;	//记号类型
	private String lexeme;	//原始输入的字符串
	private double value;	//如果记号是常数则是常数的值
	private String functionName;	//如果记号是函数，则是函数的名字 
	
	//空构造
	public Token()
	{
		
	}
	//构造函数
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
