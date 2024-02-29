package com.learning.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.learning.error.ErrorDetails;
import com.learning.exception.CourseNotFoundException;

@RestControllerAdvice
public class CoursesErrorControlAdvice {
	
	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleCourseNotFoundException(CourseNotFoundException ce)
	{
		ErrorDetails details=new ErrorDetails();
		details.setMessage(ce.getMessage());
		details.setStatus("404-Not Found");
		details.setDateTime(LocalDateTime.now());
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllExceptions(Exception e)
	{
		ErrorDetails details=new ErrorDetails();
		details.setDateTime(LocalDateTime.now());
		details.setMessage(e.getMessage());
		details.setStatus("600-Internal Server Error");
		return new ResponseEntity<ErrorDetails>(details,HttpStatus.CONFLICT);
	}

}
