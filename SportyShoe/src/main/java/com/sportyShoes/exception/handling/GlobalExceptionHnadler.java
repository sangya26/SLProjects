package com.sportyShoes.exception.handling;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHnadler {
	
	@ResponseBody
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<UserError> handleException(IllegalArgumentException exception){
		return ResponseEntity.badRequest().body(new UserError());
	}
	

}
