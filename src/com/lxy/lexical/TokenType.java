package com.lxy.lexical;
/**
 * �Ǻ����
 * @author lxy
 *
 */
public enum TokenType {

	ORIGIN,SCALE,ROT,IS,		//������
	TO,STEP,DRAW,FOR,FROM,	//������
	T,		//����
	SEMICO,L_BRACKET,R_BRACKET,COMMA,	//�ָ���
	PLUS,MINUS,MUL,DIV,POWER,	//�����
	FUNC,	//����
	CONST_ID,	//����
	NONTOKEN,	//�ռǺ�
	ERRORTOKEN	//����Ǻ�
}
