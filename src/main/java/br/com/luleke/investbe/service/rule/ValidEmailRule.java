package br.com.luleke.investbe.service.rule;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import br.com.luleke.investbe.exception.InvalidEmailException;
import br.com.luleke.investbe.service.common.rule.AbstractRule;

@Component
public class ValidEmailRule extends AbstractRule<String>{

	@Override
	public void validate() {
		if (this.getValueObject() == null)
			throw new InvalidEmailException();
		String regexPattern = "^[A-Za-z0-9+_.-]+@(.+)[A-Za-z0-9]$";
		Pattern pattern = Pattern.compile(regexPattern);
		boolean isValid = pattern.matcher(this.getValueObject()).matches();
		if(!isValid)
		  throw new InvalidEmailException();
		
	}

}
