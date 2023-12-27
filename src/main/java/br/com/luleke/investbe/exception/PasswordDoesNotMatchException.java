package br.com.luleke.investbe.exception;

import br.com.luleke.investbe.config.enums.MessagesEnum;

public class PasswordDoesNotMatchException extends LulekeInvestBeBusinessException{

	private static final long serialVersionUID = 4086006154655309143L;

	public PasswordDoesNotMatchException() {
		super(MessagesEnum.USER_AND_PASS_NOT_MATCH);
	}
}
