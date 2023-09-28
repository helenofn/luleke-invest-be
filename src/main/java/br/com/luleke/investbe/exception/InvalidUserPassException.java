package br.com.luleke.investbe.exception;

import br.com.luleke.investbe.config.enums.MessagesEnum;

public class InvalidUserPassException extends LulekeInvestBeBusinessException{

	private static final long serialVersionUID = 3444887298547235326L;

	public InvalidUserPassException() {
		super(MessagesEnum.INVALID_USER_PASS);
	}
}
