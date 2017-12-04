package com.lxy.lexical;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.lxy.lexical.bean.Token;
import com.lxy.lexical.utils.Utils;

public class FunctionImpl extends FunctionaAdapter {
	
	

	@Override
	public char getChar() {
		char ch[] = new char[1];
		try {
			Main.bufferedReader.mark(1);
			int value = Main.bufferedReader.read(ch);
			if(value==-1)//�����ļ�ĩβ
			{
				Main.flag = -1;
				return '\0';
			}else{
				if(ch[0]=='\n')
				{
					Main.lineNum = Main.lineNum+1;
				}
				return ch[0];
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ch[1];
	}

	@Override
	public void backChar(char ch) {
		// TODO Auto-generated method stub
		try {
			Main.bufferedReader.reset();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addCharTokenString(char ch) {
		// TODO Auto-generated method stub
		Main.stringBuffer.append(ch);
	}
	
	@Override
	public void cleanStringBuffer() {
		//���StringBuffer
		int len = Main.stringBuffer.length();
		Main.stringBuffer.delete(0,len);
	}
	@Override
	public Token judgeKeyToken(String idString) {
		for(Token token :Main.getTokenTab())
		{
			if(idString.equalsIgnoreCase(token.getLexeme()))
			{
				return token;
			}else{
				continue;
			}
		}
		return null;
	}
	
/*	@Override
	public boolean InitScanner(String fileName) {
		//��ȡ��ǰ·��
		try {
			//���ļ���
			Main.bufferedReader = new BufferedReader(new FileReader(new File(fileName)));
			Main.stringBuffer = new StringBuffer();
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Token getToken() {
		
		Token token = new Token();
		
		char ch = getChar();
		//���˵��ո񣬻��У�tab
		for(;;)
		{
			if(Main.flag==-1)
			{
				//�����ļ�ĩβ
				token.setType(TokenType.NONTOKEN);
				token.setValue(0.0);
				token.setFunctionName(null);
				return token;
			}
			if(!Utils.isSpace(ch))
			{
				//������ǿո��˳�
				break;
			}
			ch = getChar();
		}
		if(!Utils.isSpace(ch))
		{
			//�����ַ����뻺����
			addCharTokenString(ch);
			//�ж��Ƿ���ID
			if(Utils.isAlpha(ch))
			{
				//��ID ������ϵĻ���һ���Ǻ����� �ؼ��� PI E
				for(;;)
				{
					ch = getChar();
					if(Utils.isNumberOrAlpha(ch))
					{
						addCharTokenString(ch);
					}else{
						//�������a-zA-Z0-9
						//��Ҫ����
						backChar(ch);
						break;
					}
				}
				//�ҳ���Ӧ�ļǺ�
				token = judgeKeyToken(Main.stringBuffer.toString());
				if(token!=null)
				{
					cleanStringBuffer();
					return token;
				}
				
			}else if(Utils.isDigit(ch))	//�ж��Ƿ�������
			{
				addCharTokenString(ch);
				//�����ֳ���
				for(;;)
				{
					ch = getChar();
					if(Utils.isDigit(ch))
					{
						addCharTokenString(ch);
					}else{
						break;
					}
				}
				//�ж��ǲ���С��
				if(".".equals(ch))
				{
					addCharTokenString(ch);
					for(;;)
					{
						if(Utils.isDigit(ch))
						{
							addCharTokenString(ch);
						}else{
							break;
						}
					}
				}
				//����
				backChar(ch);
				token.setType(TokenType.CONST_ID);
				token.setValue(Double.parseDouble(Main.stringBuffer.toString()));
				cleanStringBuffer();
				return token;
			}else{
				token.setValue(0.0);
				token.setFunctionName(null);
				switch (ch) {
				case ';':
					token.setType(TokenType.SEMICO);
					break;
				case '(':
					token.setType(TokenType.L_BRACKET);
					break;
				case ')':
					token.setType(TokenType.R_BRACKET);
					break;
				case ',':
					token.setType(TokenType.COMMA);
					break;
				case '+':
					token.setType(TokenType.PLUS);
					break;
				case '-':
					*//**
					 * ���������
					 * 1.һ���ǳ�������
					 * 2. һ����ע��
					 *//*
					ch = getChar();
					if(ch=='-')
					{
						//˵��������ע��
						ch = getChar();
						while(ch!='\n'&&Main.flag!=-1)
						{
							ch = getChar();
						}
						//����
						backChar(ch);
						return getToken();
					}else{
						backChar(ch);
						token.setType(TokenType.MINUS);
						break;
					}
				case '*':
					*//**
					 * ���������
					 *1. �˷�
					 *2. �˷�
					 *//*
					ch = getChar();
					if(ch=='*')
					{
						token.setType(TokenType.POWER);
						break;
					}else{
						backChar(ch);
						token.setType(TokenType.MUL);
						break;
					}
				case '/':
					*//**
					 * ���������
					 * 1. ��ע��
					 * 2. ����
					 *//*
					ch = getChar();
					if(ch=='/')
					{
						ch = getChar();
						while(ch!='\n'&&Main.flag!=-1)
						{
							ch = getChar();
						}
						backChar(ch);
						return getToken();
					}else{
						backChar(ch);
						token.setType(TokenType.DIV);
						break;
					}
				default:
					token.setType(TokenType.ERRORTOKEN);
					break;
				}
				cleanStringBuffer();
				return token;
			}
		}
		return null;
	}
	
	@Override
	public void closeScanner() {
		try {
			//���BufferedReader��Ϊ��
			if(null!=Main.bufferedReader)
			{
				Main.bufferedReader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}*/
}
