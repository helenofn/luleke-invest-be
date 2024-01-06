package br.com.luleke.investbe.rule;

import org.springframework.stereotype.Component;

import br.com.luleke.investbe.exception.InvalidWalletNameException;
import br.com.luleke.investbe.rule.config.AbstractRule;
import br.com.luleke.investbe.util.StringUtils;

@Component
public class ValidWalletNameRule extends AbstractRule<String>{

	@Override
	public void validate() {
		if (StringUtils.isEmpty(this.valueObject) || this.valueObject.length() < 3 || this.valueObject.length() > 50)
			throw new InvalidWalletNameException();
	}

}
