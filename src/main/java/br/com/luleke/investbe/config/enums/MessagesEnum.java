package br.com.luleke.investbe.config.enums;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum MessagesEnum {
	
	SUCCESS_OK(HttpStatus.OK, "SUCCESS.OK", "Requisição processada com sucesso."),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "ERROR.INTERNAL.SERVER.ERROR", "Ocorreu um erro interno no servidor."),
	VALIDATION_ERROR(HttpStatus.NOT_ACCEPTABLE, "ERROR.VALIDATION.ERROS", "Ocorreram críticas a requisição enviada."),
	USER_ALREADY_EXISTIS(HttpStatus.CONFLICT, "ERROR.USER.ALREADY.EXISTIS", "Usuário já existente.");
	
	
	private HttpStatus httpStatus;
	private String codeMessage;
	private String message;
	
	private MessagesEnum(HttpStatus httpStatus, String codeMessage, String message) {
		this.httpStatus = httpStatus;
		this.codeMessage = codeMessage;
		this.message = message;
	}

}
