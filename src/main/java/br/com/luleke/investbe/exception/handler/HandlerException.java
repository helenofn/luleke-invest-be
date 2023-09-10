package br.com.luleke.investbe.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.luleke.investbe.config.enums.MessagesEnum;
import br.com.luleke.investbe.exception.LulekeInvestBeBusinessException;
import br.com.luleke.investbe.response.dto.ReturnDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(value = LulekeInvestBeBusinessException.class)
	public ResponseEntity<Object> lulekeInvestBeBusinessException(HttpServletRequest req, LulekeInvestBeBusinessException e){
		log.info(String.format("Ocorreu um erro de negocio: %s", e.getMessage()), e);
		ReturnDTO err = new ReturnDTO(e.getMessageEnum());
		return ResponseEntity.status(e.getMessageEnum().getHttpStatus()).body(err);
	}

	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> hfnInvestException(HttpServletRequest req, Exception e){
		log.error(String.format("Ocorreu um erro inesperado: %s", e.getMessage()), e);
		ReturnDTO err = new ReturnDTO(MessagesEnum.INTERNAL_SERVER_ERROR);
		return ResponseEntity.status(MessagesEnum.INTERNAL_SERVER_ERROR.getHttpStatus()).body(err);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ReturnDTO err = new ReturnDTO(MessagesEnum.VALIDATION_ERROR);
		for (FieldError e : ex.getFieldErrors()){
			err.addError(e.getField(), e.getDefaultMessage());
		}
		return ResponseEntity.status(MessagesEnum.VALIDATION_ERROR.getHttpStatus()).body(err);
	}
	
	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		ReturnDTO err = new ReturnDTO(MessagesEnum.VALIDATION_ERROR);
	    for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
	    	String nomeCampo = violation.getPropertyPath()!=null? violation.getPropertyPath().toString() : "";
	    	err.addError(nomeCampo, violation.getMessage());
	    }
	    return ResponseEntity.status(MessagesEnum.VALIDATION_ERROR.getHttpStatus()).body(err);
	}
}
