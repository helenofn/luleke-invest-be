package br.com.luleke.investbe.exception;

import br.com.luleke.investbe.config.enums.MessagesEnum;

public class InvalidEmailException extends LulekeInvestBeBusinessException{

	private static final long serialVersionUID = -5987840710858910414L;
	
	public InvalidEmailException() {
		super(MessagesEnum.INVALID_MAIL);
	}

}
