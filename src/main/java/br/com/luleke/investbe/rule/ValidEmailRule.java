package br.com.luleke.investbe.rule;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import br.com.luleke.investbe.exception.InvalidEmailException;
import br.com.luleke.investbe.rule.config.AbstractRule;

@Component
public class ValidEmailRule extends AbstractRule<String>{

	@Override
	public void validate() {
		if (this.getValueObject() == null)
			throw new InvalidEmailException();
		if(this.getValueObject().length() < 10 || this.getValueObject().length() > 150)
			throw new InvalidEmailException();
		String regexPattern = "^[A-Za-z0-9+_.-]+@(.+)[A-Za-z0-9]$";
		Pattern pattern = Pattern.compile(regexPattern);
		boolean isValid = pattern.matcher(this.getValueObject()).matches();
		if(!isValid)
		  throw new InvalidEmailException();
		
	}

}
