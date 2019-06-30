package com.accounts.accountManager.commons;

import org.springframework.http.HttpStatus;

public class CustomResponseException extends Exception{
	
	private static final long serialVersionUID = 3314185813492994587L;
	
	private HttpStatus errCode;
	private String errMsg;
	private String errDebugMsg;

	
	public CustomResponseException(HttpStatus errCode, String errMsg, String errDebugMsg) {
		super();
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.errDebugMsg = errDebugMsg;
	}


	public HttpStatus getErrCode() {
		return errCode;
	}


	public void setErrCode(HttpStatus errCode) {
		this.errCode = errCode;
	}


	public String getErrMsg() {
		return errMsg;
	}


	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}


	public String getErrDebugMsg() {
		return errDebugMsg;
	}


	public void setErrDebugMsg(String errDebugMsg) {
		this.errDebugMsg = errDebugMsg;
	}


	@Override
	public String toString() {
		return getErrDebugMsg();
	}

}
