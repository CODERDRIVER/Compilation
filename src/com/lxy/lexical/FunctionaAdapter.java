package com.lxy.lexical;

import com.lxy.lexical.bean.Token;

/**
 * FunctionµÄ¿ÕÊµÏÖ
 * @author lxy
 *
 */
public class FunctionaAdapter implements Function {

	@Override
	public boolean InitScanner(String fileName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void closeScanner() {
		// TODO Auto-generated method stub

	}

	@Override
	public Token getToken() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public char getChar() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void backChar(char ch) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCharTokenString(char ch) {
		// TODO Auto-generated method stub

	}

	
	@Override
	public Token judgeKeyToken(String idString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cleanStringBuffer() {
		// TODO Auto-generated method stub
		
	}
	
	
}
