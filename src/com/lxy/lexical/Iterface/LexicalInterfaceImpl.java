package com.lxy.lexical.Iterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.lxy.lexical.Function;
import com.lxy.lexical.FunctionImpl;
import com.lxy.lexical.Main;
import com.lxy.lexical.TokenType;
import com.lxy.lexical.bean.Token;
import com.lxy.lexical.utils.Utils;

public class LexicalInterfaceImpl implements LexicalInterface {

	Function f = new FunctionImpl();
	@Override
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
		
		char ch = f.getChar();
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
			ch = f.getChar();
		}
		if(!Utils.isSpace(ch))
		{
			//�����ַ����뻺����
			f.addCharTokenString(ch);
			//�ж��Ƿ���ID
			if(Utils.isAlpha(ch))
			{
				//��ID ������ϵĻ���һ���Ǻ����� �ؼ��� PI E
				for(;;)
				{
					ch = f.getChar();
					if(Utils.isNumberOrAlpha(ch))
					{
						f.addCharTokenString(ch);
					}else{
						//�������a-zA-Z0-9
						//��Ҫ����
						f.backChar(ch);
						break;
					}
				}
				//�ҳ���Ӧ�ļǺ�
				token = f.judgeKeyToken(Main.stringBuffer.toString());
				if(token!=null)
				{
					f.cleanStringBuffer();
					return token;
				}
				
			}else if(Utils.isDigit(ch))	//�ж��Ƿ�������
			{
				//f.addCharTokenString(ch);
				//�����ֳ���
				for(;;)
				{
					ch = f.getChar();
					if(Utils.isDigit(ch))
					{
						f.addCharTokenString(ch);
					}else{
						break;
					}
				}
				//�ж��ǲ���С��
				if(".".equals(ch))
				{
					f.addCharTokenString(ch);
					for(;;)
					{
						if(Utils.isDigit(ch))
						{
							f.addCharTokenString(ch);
						}else{
							break;
						}
					}
				}
				//����
				f.backChar(ch);
				token.setType(TokenType.CONST_ID);
				token.setValue(Double.parseDouble(Main.stringBuffer.toString()));
				f.cleanStringBuffer();
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
					/**
					 * ���������
					 * 1.һ���ǳ�������
					 * 2. һ����ע��
					 */
					ch = f.getChar();
					if(ch=='-')
					{
						//˵��������ע��
						ch = f.getChar();
						while(ch!='\n'&&Main.flag!=-1)
						{
							ch = f.getChar();
						}
						//����
						f.backChar(ch);
						return getToken();
					}else{
						f.backChar(ch);
						token.setType(TokenType.MINUS);
						break;
					}
				case '*':
					/**
					 * ���������
					 *1. �˷�
					 *2. �˷�
					 */
					ch = f.getChar();
					if(ch=='*')
					{
						token.setType(TokenType.POWER);
						break;
					}else{
						f.backChar(ch);
						token.setType(TokenType.MUL);
						break;
					}
				case '/':
					/**
					 * ���������
					 * 1. ��ע��
					 * 2. ����
					 */
					ch = f.getChar();
					if(ch=='/')
					{
						ch = f.getChar();
						while(ch!='\n'&&Main.flag!=-1)
						{
							ch = f.getChar();
						}
						f.backChar(ch);
						return getToken();
					}else{
						f.backChar(ch);
						token.setType(TokenType.DIV);
						break;
					}
				default:
					token.setType(TokenType.ERRORTOKEN);
					break;
				}
				f.cleanStringBuffer();
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
	}

}
