package br.com.luleke.investbe.exception;

import br.com.luleke.investbe.config.enums.MessagesEnum;

public class UserUnauthorizedException extends LulekeInvestBeBusinessException{

	private static final long serialVersionUID = -2093791870623938780L;

	public UserUnauthorizedException() {
		super(MessagesEnum.USER_UNAUTHORIZED);
	}

}
