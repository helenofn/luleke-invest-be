package br.com.luleke.investbe.exception;

import br.com.luleke.investbe.config.enums.MessagesEnum;

public class UserOrPassNotProvidedExcpetion extends LulekeInvestBeBusinessException{

	private static final long serialVersionUID = 5542131861952030906L;

	public UserOrPassNotProvidedExcpetion() {
		super(MessagesEnum.USER_OR_PASS_NOT_PROVIDED);
	}
}
