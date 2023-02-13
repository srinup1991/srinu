package com.slokam.springbootHibernate.ecxeptionhandler;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ourExceptionHandler
{
	@ExceptionHandler(Exception.class)
	ResponseEntity<String> handleException(Exception e)
	{
		ResponseEntity<String> re = new ResponseEntity<String>("got exception",HttpStatus.INTERNAL_SERVER_ERROR);
		return re;
	}
	@ExceptionHandler(IOException.class)
	ResponseEntity<String> handleIOException(Exception e)
	{
		ResponseEntity<String> re = new ResponseEntity<String>("got IOexception",HttpStatus.INTERNAL_SERVER_ERROR);
		return re;
	}
}
