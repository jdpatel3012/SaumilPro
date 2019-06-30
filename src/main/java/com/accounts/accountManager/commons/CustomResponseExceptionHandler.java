package com.accounts.accountManager.commons;

import javax.persistence.NonUniqueResultException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomResponseExceptionHandler extends ResponseEntityExceptionHandler {

	ResponseUtility responseUtility = new ResponseUtility();

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<Object> handle(Exception ex, WebRequest request) {
		return responseUtility.failureResponse(ex, HttpStatus.NOT_FOUND, "Null Pointer");
	}

	@ExceptionHandler(NonUniqueResultException.class)
	public ResponseEntity<Object> handleNonUniqueResultException(Exception ex, WebRequest request) {
		return responseUtility.failureResponse(ex, HttpStatus.NOT_FOUND, ex.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
		return responseUtility.failureResponse(ex, HttpStatus.NOT_ACCEPTABLE, ex.getMessage());
	}

	@ExceptionHandler(CustomResponseException.class)
	public ResponseEntity<Object> handleConstraintException(CustomResponseException ex, WebRequest request) {
		return responseUtility.failureResponse(ex, HttpStatus.NOT_ACCEPTABLE, ex.getErrMsg());
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ResponseEntity<Object> handleExceptionsInternalError(HttpServletRequest req, Exception ex) {
		return responseUtility.failureResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return responseUtility.failureResponse(ex, HttpStatus.NOT_ACCEPTABLE, "Parameter Values are invalid");
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return responseUtility.failureResponse(ex, HttpStatus.NOT_ACCEPTABLE, "Check Method Arguments");
	}
}
