package br.com.luleke.investbe.exception;

import br.com.luleke.investbe.config.enums.MessagesEnum;

public class AccountWithoutRoleException extends LulekeInvestBeBusinessException{

	private static final long serialVersionUID = -6570403496052967615L;

	public AccountWithoutRoleException() {
		super(MessagesEnum.ACCOUNT_WITHOUT_ROLE);
	}
}
