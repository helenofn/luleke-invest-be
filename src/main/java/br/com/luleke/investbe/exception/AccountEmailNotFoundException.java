package br.com.luleke.investbe.exception;

import br.com.luleke.investbe.config.enums.MessagesEnum;

public class AccountEmailNotFoundException extends LulekeInvestBeBusinessException{

	private static final long serialVersionUID = -736851083220927331L;

	public AccountEmailNotFoundException() {
		super(MessagesEnum.ACCOUNT_NOT_FOUND);
	}
}
