package br.com.luleke.investbe.exception;

import br.com.luleke.investbe.config.enums.MessagesEnum;

public class InvalidUserNameException extends LulekeInvestBeBusinessException{

	private static final long serialVersionUID = 964962127646873550L;

	public InvalidUserNameException() {
		super(MessagesEnum.INVALID_USER_NAME);
	}
}
