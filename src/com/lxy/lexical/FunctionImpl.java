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
			if(value==-1)//到达文件末尾
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
		//清除StringBuffer
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
		//获取当前路径
		try {
			//打开文件流
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
		//过滤掉空格，换行，tab
		for(;;)
		{
			if(Main.flag==-1)
			{
				//到达文件末尾
				token.setType(TokenType.NONTOKEN);
				token.setValue(0.0);
				token.setFunctionName(null);
				return token;
			}
			if(!Utils.isSpace(ch))
			{
				//如果不是空格，退出
				break;
			}
			ch = getChar();
		}
		if(!Utils.isSpace(ch))
		{
			//将该字符加入缓冲中
			addCharTokenString(ch);
			//判断是否是ID
			if(Utils.isAlpha(ch))
			{
				//是ID 如果符合的话，一定是函数名 关键字 PI E
				for(;;)
				{
					ch = getChar();
					if(Utils.isNumberOrAlpha(ch))
					{
						addCharTokenString(ch);
					}else{
						//如果不是a-zA-Z0-9
						//且要回退
						backChar(ch);
						break;
					}
				}
				//找出对应的记号
				token = judgeKeyToken(Main.stringBuffer.toString());
				if(token!=null)
				{
					cleanStringBuffer();
					return token;
				}
				
			}else if(Utils.isDigit(ch))	//判断是否是数字
			{
				addCharTokenString(ch);
				//是数字常量
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
				//判断是不是小数
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
				//回退
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
					 * 有两种情况
					 * 1.一种是除法运算
					 * 2. 一种是注释
					 *//*
					ch = getChar();
					if(ch=='-')
					{
						//说明书是行注释
						ch = getChar();
						while(ch!='\n'&&Main.flag!=-1)
						{
							ch = getChar();
						}
						//回退
						backChar(ch);
						return getToken();
					}else{
						backChar(ch);
						token.setType(TokenType.MINUS);
						break;
					}
				case '*':
					*//**
					 * 有两种情况
					 *1. 乘法
					 *2. 乘方
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
					 * 有两种情况
					 * 1. 行注释
					 * 2. 除法
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
			//如果BufferedReader不为空
			if(null!=Main.bufferedReader)
			{
				Main.bufferedReader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}*/
}
