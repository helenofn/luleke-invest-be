package br.com.luleke.investbe.service.auth.rule.exception;

import br.com.luleke.investbe.config.enums.MessagesEnum;
import br.com.luleke.investbe.exception.LulekeInvestBeBusinessException;

public class UserAlreadyExistsException extends LulekeInvestBeBusinessException{
	
	private static final long serialVersionUID = 1446514680875461043L;

	public UserAlreadyExistsException() {
		super(MessagesEnum.USER_ALREADY_EXISTIS);
	}

}
