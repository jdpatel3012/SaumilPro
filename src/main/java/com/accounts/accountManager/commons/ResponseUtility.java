package com.accounts.accountManager.commons;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtility {

	ResponseModel responseModel = new ResponseModel();
	SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date now = new Date();
	String strDate = sdfDate.format(now);

	public ResponseEntity<Object> successResponse(Object data) {
		responseModel.setData(data);
		responseModel.setDebugMessage(null);
		responseModel.setError(false);
		responseModel.setMessage(null);
		responseModel.setStatus(HttpStatus.OK);
		responseModel.setTimestamp(strDate);
		return new ResponseEntity<Object>(responseModel, new HttpHeaders(), HttpStatus.OK);
	}

	public ResponseEntity<Object> failureResponse(Exception ex, HttpStatus status, String message) {
		responseModel.setData(null);
		responseModel.setDebugMessage(ex.toString());
		responseModel.setError(true);
		responseModel.setMessage(message);
		responseModel.setStatus(status);
		responseModel.setTimestamp(strDate);
		return new ResponseEntity<Object>(responseModel, new HttpHeaders(), status);
	}

}
