package br.com.luleke.investbe.service.rule;

import org.springframework.stereotype.Component;

import br.com.luleke.investbe.exception.InvalidUserNameException;
import br.com.luleke.investbe.service.common.rule.AbstractRule;
import br.com.luleke.investbe.util.StringUtils;

@Component
public class ValidUserNameRule extends AbstractRule<String>{

	@Override
	public void validate() {
		if (StringUtils.isEmpty(this.valueObject) || this.valueObject.length() < 4 || this.valueObject.length() > 70)
			throw new InvalidUserNameException();
	}

}
