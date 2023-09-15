package br.com.luleke.investbe.exception;

import br.com.luleke.investbe.config.enums.MessagesEnum;

public class AccountEmailAlreadyExistsException extends LulekeInvestBeBusinessException{
	
	private static final long serialVersionUID = 1446514680875461043L;

	public AccountEmailAlreadyExistsException() {
		super(MessagesEnum.ACCOUNT_MAIL_ALREADY_EXISTIS);
	}

}
