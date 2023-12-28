package br.com.luleke.investbe.rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import br.com.luleke.investbe.exception.InvalidUserPassException;
import br.com.luleke.investbe.rule.config.AbstractRule;
import br.com.luleke.investbe.util.StringUtils;

@Component
public class ValidUserPassRule extends AbstractRule<String>{

	/*
	  ^                                 # start of line
      (?=.*[0-9])                       # positive lookahead, digit [0-9]
      (?=.*[a-z])                       # positive lookahead, one lowercase character [a-z]
      (?=.*[A-Z])                       # positive lookahead, one uppercase character [A-Z]
      (?=.*[!@#&()–[{}]:;',?/*~$^+=<>]) # positive lookahead, one of the special character in this [..]
      .                                 # matches anything
      {8,20}                            # length at least 8 characters and maximum of 20 characters
      $                                 # end of line
	 */
	@Override
	public void validate() {
		if (StringUtils.isEmpty(this.valueObject) || this.valueObject.length() < 10)
			throw new InvalidUserPassException();
		
		String patterm = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
		Pattern pattern = Pattern.compile(patterm);
		Matcher matcher = pattern.matcher(this.valueObject);
		boolean isValid = matcher.matches();
		if(!isValid)
			throw new InvalidUserPassException();
		
	}

}
