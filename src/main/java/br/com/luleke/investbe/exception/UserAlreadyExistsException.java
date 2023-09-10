package br.com.luleke.investbe.exception;

import br.com.luleke.investbe.config.enums.MessagesEnum;

public class UserAlreadyExistsException extends LulekeInvestBeBusinessException{
	
	private static final long serialVersionUID = 1446514680875461043L;

	public UserAlreadyExistsException() {
		super(MessagesEnum.USER_ALREADY_EXISTIS);
	}

}
