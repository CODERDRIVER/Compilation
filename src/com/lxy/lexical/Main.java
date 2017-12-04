package com.lxy.lexical;

import java.io.BufferedReader;

import com.lxy.lexical.Iterface.LexicalInterface;
import com.lxy.lexical.Iterface.LexicalInterfaceImpl;
import com.lxy.lexical.bean.Token;

public class Main {
	
	public static BufferedReader bufferedReader = null;
	public static StringBuffer stringBuffer = null;
	public static int flag = 0;
	public static int lineNum=1;	//�к�
	
	/**
	 * @return the tokenTab
	 */
	public static Token[] getTokenTab() {
		return TokenTab;
	}
	/**
	 * @param tokenTab the tokenTab to set
	 */
	public static void setTokenTab(Token[] tokenTab) {
		TokenTab = tokenTab;
	}
	/**
	 * ��Ϊ�����֡����������������Լ���������������ΪID
	 * ͨ���������ű��ܹ�������ϸ�ֳ�����
	 */

	//���ּǺŵķ��ű�
	static Token TokenTab[]=
		{
				new Token(TokenType.CONST_ID,"PI",3.1415926,null),
				new Token(TokenType.CONST_ID,"E",2.71828,null),
				new Token(TokenType.T,"T",0.0,null),
				new Token(TokenType.FUNC,"SIN",0.0,"sin"),
				new Token(TokenType.FUNC,"COS",0.0,"cos"),
				new Token(TokenType.FUNC,"TAN",0.0,"tan"),
				new Token(TokenType.FUNC,"LN",0.0,"log"),
				new Token(TokenType.FUNC,"EXP",0.0,"exp"),
				new Token(TokenType.FUNC,"SQRT",0.0,"sqrt"),
				new Token(TokenType.ORIGIN,"ORIGIN",0.0,null),
				new Token(TokenType.SCALE,"SCALE",0.0,null),
				new Token(TokenType.ROT,"ROT",0.0,null),
				new Token(TokenType.IS,"IS",0.0,null),
				new Token(TokenType.FOR,"FOR",0.0,null),
				new Token(TokenType.FROM,"FROM",0.0,null),
				new Token(TokenType.TO,"TO",0.0,null),
				new Token(TokenType.STEP,"STEP",0.0,null),
				new Token(TokenType.DRAW,"DRAW",0.0,null),
		};
	public static void main(String[] args)
	{
		//��ʼ���Ǻţ�һ��ʼΪ����Ǻ�
		Token token = new Token(TokenType.ERRORTOKEN,"ERRORTOKEN",0.0,null);
		//����һ���ӿڵ�ʵ����
//		Function f = new FunctionImpl();
		LexicalInterface f = new LexicalInterfaceImpl();
		//���ó�ʼ������
		String fileName = "conf/test.txt";
		if(!f.InitScanner(fileName))
		{
			System.out.println("���ļ�����");
		}
		System.out.println("�Ǻ����	   	�ַ���	   ����ֵ		��������");
		System.out.println("----------------------------------------------");
		while(true)
		{
			token = f.getToken();
			if(!token.getType().equals(TokenType.NONTOKEN))	//�ж��Ƿ񵽴��ļ�����
			{
				System.out.printf("%4d,%12s,%12f,%12s\n",token.getType().ordinal(),token.getType(),token.getValue(),token.getFunctionName());
			}else{
				break;
			}
		}
		System.out.println("------------------------------------------------");
		f.closeScanner();	//�ر��ļ�
	}
}
