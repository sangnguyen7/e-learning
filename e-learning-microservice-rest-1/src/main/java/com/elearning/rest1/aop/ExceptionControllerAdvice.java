package com.elearning.rest1.aop;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.elearning.exception.CourseTopicAlreadyExistException;
import com.elearning.exception.EntityNotFoundException;

/**
 * 
 * Advice class that check if a rest endpoint throws an exception and change the response code and message according.
 * 
 * @author Gustavo Orsi
 *
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

	/**
	 * 
	 * Catch <code>EntityNotFoundException</code> excption thrown by any endpoint and change the return code.
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	VndErrors courseNotFoundExceptionHandler(EntityNotFoundException ex) {
		return new VndErrors(HttpStatus.NOT_FOUND.getReasonPhrase(), ex.getMessage());
	}
	
	/**
	 * 
	 * Catch <code>CourseTopicAlreadyExistException</code> excption thrown by any endpoint and change the return code.
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(CourseTopicAlreadyExistException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	VndErrors courseTopicAlreadyExistExceptionHandler(CourseTopicAlreadyExistException ex) {
		return new VndErrors(HttpStatus.FORBIDDEN.getReasonPhrase(), ex.getMessage());
	}
	
	
	/**
	 * 
	 * Catch <code>IllegalArgumentException</code> excption thrown by any endpoint and change the return code.
	 * 
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	VndErrors illegalArgumentExceptionHandler(IllegalArgumentException ex) {
		return new VndErrors(HttpStatus.BAD_REQUEST.getReasonPhrase(), ex.getMessage());
	}
	

}
