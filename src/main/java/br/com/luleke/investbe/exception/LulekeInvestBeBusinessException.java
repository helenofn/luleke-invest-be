package br.com.luleke.investbe.exception;

import br.com.luleke.investbe.config.enums.MessagesEnum;
import lombok.Getter;

@Getter
public class LulekeInvestBeBusinessException extends RuntimeException{

	private static final long serialVersionUID = -2387614585956869949L;
	private MessagesEnum messageEnum;
	
	public LulekeInvestBeBusinessException(MessagesEnum message) {
		super(String.format("Erro code: %s / Message: %s", message.getCodeMessage(), message.getMessage()));
		this.messageEnum = message;
	}

	
}
