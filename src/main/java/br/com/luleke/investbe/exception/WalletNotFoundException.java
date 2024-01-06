package br.com.luleke.investbe.exception;

import br.com.luleke.investbe.config.enums.MessagesEnum;

public class WalletNotFoundException extends LulekeInvestBeBusinessException{

	private static final long serialVersionUID = -7133495269821193968L;

	public WalletNotFoundException() {
		super(MessagesEnum.WALLET_NOT_FOUND);
	}
}
