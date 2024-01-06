package br.com.luleke.investbe.config.enums;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum MessagesEnum {
	
	SUCCESS_OK(HttpStatus.OK, "SUCCESS.OK", "Requisição processada com sucesso."),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "ERROR.INTERNAL.SERVER.ERROR", "Ocorreu um erro interno no servidor."),
	VALIDATION_ERROR(HttpStatus.NOT_ACCEPTABLE, "ERROR.VALIDATION.ERROS", "Ocorreram críticas a requisição enviada."),
	ACCOUNT_MAIL_ALREADY_EXISTIS(HttpStatus.CONFLICT, "ERROR.ACCOUNT.MAIL.ALREADY.EXISTIS", "E-mail já utilizado por outra conta de usuário."),
	ACCOUNT_NOT_FOUND(HttpStatus.NOT_FOUND, "ERROR.ACCOUNT.NOT.FOUND", "A conta do usuário não foi encontrada."),
	ACCOUNT_WITHOUT_ROLE(HttpStatus.CONFLICT, "ERROR.ACCOUNT.WITHOUT.ROLE", "A conta do usuário não roles associadas."),
	INVALID_MAIL(HttpStatus.CONFLICT, "ERROR.INVALID.MAIL", "E-mail inválido."),
	INVALID_USER_NAME(HttpStatus.CONFLICT, "ERROR.INVALID.USER_NAME", "Nome de usuário inválido."),
	INVALID_USER_PASS(HttpStatus.CONFLICT, "ERROR.INVALID.USER_PASS", "Senha de usuário inválida."),
	INVALID_WALLET_NAME(HttpStatus.CONFLICT, "ERROR.INVALID.WALLET_NAME", "Nome da carteira inválido."),
	USER_AND_PASS_NOT_MATCH(HttpStatus.CONFLICT, "ERROR.USER_AND_PASS_NOT_MATCH", "Usuário e senha não conferem."),
	USER_OR_PASS_NOT_PROVIDED(HttpStatus.CONFLICT, "ERROR.USER_OR_PASS_NOT_PROVIDED", "Usuário ou senha não fornecidos."),
	USER_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "ERROR.USER.UNAUTHORIZED", "Usuário não autorizado."),
	WALLET_NOT_FOUND(HttpStatus.NOT_FOUND, "ERROR.WALLET.NOT_FOUND", "Carteira não encontrada.");
	
	private HttpStatus httpStatus;
	private String codeMessage;
	private String message;
	
	private MessagesEnum(HttpStatus httpStatus, String codeMessage, String message) {
		this.httpStatus = httpStatus;
		this.codeMessage = codeMessage;
		this.message = message;
	}

}
