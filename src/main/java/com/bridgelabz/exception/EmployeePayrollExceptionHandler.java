package com.bridgelabz.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.bridgelabz.dto.ResponseDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class EmployeePayrollExceptionHandler {

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handleMessageNotReadableException(
			HttpMessageNotReadableException exception){
		log.error("Invalid Format", exception);
		ResponseDTO responseDTO = new ResponseDTO("Exception while processing Rest Request!", "Format is incorrect!");
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exception){
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errorMessage = errorList.stream().map(objError -> objError.getDefaultMessage()).collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO("Exception while processing Rest Request!", errorMessage);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmployeePayrollCustomException.class)
	public ResponseEntity<ResponseDTO> handleAddressBookCustomException(EmployeePayrollCustomException exception){
		ResponseDTO responseDTO = new ResponseDTO("Exception while processing Rest Request!!", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmployeePayrollGlobalException.class)
	public ResponseEntity<ResponseDTO> handleGlobalException(Exception exception, Object body, HttpHeaders headers, HttpStatus status, WebRequest request){
		ResponseDTO responseDTO = new ResponseDTO("Exception while processing Rest Request!!!", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
}
