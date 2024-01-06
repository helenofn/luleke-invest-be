package br.com.luleke.investbe.exception;

import br.com.luleke.investbe.config.enums.MessagesEnum;

public class InvalidWalletNameException extends LulekeInvestBeBusinessException{

	private static final long serialVersionUID = 1L;

	public InvalidWalletNameException() {
		super(MessagesEnum.INVALID_WALLET_NAME);
	}
}
