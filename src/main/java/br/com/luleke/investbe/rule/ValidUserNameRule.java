package br.com.luleke.investbe.rule;

import org.springframework.stereotype.Component;

import br.com.luleke.investbe.exception.InvalidUserNameException;
import br.com.luleke.investbe.rule.config.AbstractRule;
import br.com.luleke.investbe.util.StringUtils;

@Component
public class ValidUserNameRule extends AbstractRule<String>{

	@Override
	public void validate() {
		if (StringUtils.isEmpty(this.valueObject) || this.valueObject.length() < 5 || this.valueObject.length() > 100)
			throw new InvalidUserNameException();
	}

}
