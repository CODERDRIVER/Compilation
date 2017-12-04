package com.lxy.lexical;
/**
 * 记号类别
 * @author lxy
 *
 */
public enum TokenType {

	ORIGIN,SCALE,ROT,IS,		//保留字
	TO,STEP,DRAW,FOR,FROM,	//保留字
	T,		//参数
	SEMICO,L_BRACKET,R_BRACKET,COMMA,	//分隔符
	PLUS,MINUS,MUL,DIV,POWER,	//运算符
	FUNC,	//函数
	CONST_ID,	//常量
	NONTOKEN,	//空记号
	ERRORTOKEN	//出错记号
}
